# gui.py
import tkinter as tk
from tkinter import ttk, messagebox, filedialog
from models import Student
from data_manager import DataManager
from analytics import Analytics
import pandas as pd
import os

DEFAULT_CSV = "students.csv"

class StudentApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Student Performance Management System")
        self.dm = DataManager(csv_path=DEFAULT_CSV)
        self._build_gui()
        self.refresh_table()

    def _build_gui(self):
        frm = ttk.Frame(self.root, padding=10)
        frm.grid(row=0, column=0, sticky='NSEW')

        # Input area
        input_frame = ttk.LabelFrame(frm, text="Add Student")
        input_frame.grid(row=0, column=0, sticky='W', padx=5, pady=5)

        ttk.Label(input_frame, text="ID").grid(row=0, column=0, sticky='E')
        self.e_id = ttk.Entry(input_frame, width=15)
        self.e_id.grid(row=0, column=1)

        ttk.Label(input_frame, text="Name").grid(row=0, column=2, sticky='E')
        self.e_name = ttk.Entry(input_frame, width=25)
        self.e_name.grid(row=0, column=3)

        ttk.Label(input_frame, text="Gender").grid(row=1, column=0, sticky='E')
        self.gender_var = tk.StringVar(value="Male")
        ttk.Combobox(input_frame, textvariable=self.gender_var, values=["Male", "Female", "Other"], width=13).grid(row=1, column=1)

        ttk.Label(input_frame, text="Qualification").grid(row=1, column=2, sticky='E')
        self.e_qual = ttk.Entry(input_frame, width=25)
        self.e_qual.grid(row=1, column=3)

        ttk.Label(input_frame, text="Marks (comma separated)").grid(row=2, column=0, sticky='E')
        self.e_marks = ttk.Entry(input_frame, width=50)
        self.e_marks.grid(row=2, column=1, columnspan=3, sticky='W')

        btn_add = ttk.Button(input_frame, text="Add Student", command=self.add_student)
        btn_add.grid(row=3, column=0, pady=6)

        btn_import = ttk.Button(input_frame, text="Import CSV", command=self.import_csv)
        btn_import.grid(row=3, column=1, pady=6)

        btn_export_json = ttk.Button(input_frame, text="Export to JSON", command=self.export_json)
        btn_export_json.grid(row=3, column=2, pady=6)

        btn_refresh = ttk.Button(input_frame, text="Refresh Table", command=self.refresh_table)
        btn_refresh.grid(row=3, column=3, pady=6)

        # Table area
        table_frame = ttk.LabelFrame(frm, text="Students")
        table_frame.grid(row=1, column=0, padx=5, pady=5, sticky='NSEW')
        cols = ('student_id', 'name', 'gender', 'qualification', 'marks', 'average', 'grade')
        self.tree = ttk.Treeview(table_frame, columns=cols, show='headings', height=10)
        for c in cols:
            self.tree.heading(c, text=c.title())
            self.tree.column(c, width=100, anchor='center')
        self.tree.grid(row=0, column=0, sticky='NSEW')
        scrollbar = ttk.Scrollbar(table_frame, orient=tk.VERTICAL, command=self.tree.yview)
        self.tree.configure(yscroll=scrollbar.set)
        scrollbar.grid(row=0, column=1, sticky='NS')

        # Analytics buttons
        analytics_frame = ttk.LabelFrame(frm, text="Analytics")
        analytics_frame.grid(row=2, column=0, padx=5, pady=5, sticky='W')

        btn_top = ttk.Button(analytics_frame, text="Show Top Performers", command=self.show_top)
        btn_top.grid(row=0, column=0, padx=4)

        btn_stats = ttk.Button(analytics_frame, text="Subject Stats", command=self.show_subject_stats)
        btn_stats.grid(row=0, column=1, padx=4)

        btn_grade_pie = ttk.Button(analytics_frame, text="Save Grade Pie", command=self.save_grade_pie)
        btn_grade_pie.grid(row=0, column=2, padx=4)

    def add_student(self):
        sid = self.e_id.get().strip()
        name = self.e_name.get().strip()
        gender = self.gender_var.get()
        qual = self.e_qual.get().strip()
        marks_txt = self.e_marks.get().strip()
        if not sid or not name or not marks_txt:
            messagebox.showerror("Validation Error", "Please fill ID, Name and Marks.")
            return
        try:
            marks = [float(x.strip()) for x in marks_txt.replace(',', ' ').split() if x.strip() != ""]
        except ValueError:
            messagebox.showerror("Validation Error", "Marks must be numeric (comma or space separated).")
            return
        student = Student(student_id=sid, name=name, gender=gender, qualification=qual, marks=marks)
        try:
            self.dm.save_student_csv(student)
            messagebox.showinfo("Saved", f"Student {name} saved.")
            self.clear_inputs()
            self.refresh_table()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def import_csv(self):
        path = filedialog.askopenfilename(title="Select CSV file", filetypes=[("CSV files", "*.csv"), ("All", "*.*")])
        if not path:
            return
        try:
            df = pd.read_csv(path)
            for _, row in df.iterrows():
                d = row.to_dict()
                marks_field = d.get('marks') or d.get('Marks') or d.get('MARKS') or ""
                if pd.isna(marks_field):
                    marks_field = ""
                student = Student.from_dict({
                    'student_id': str(d.get('student_id') or d.get('id') or ''),
                    'name': d.get('name') or '',
                    'gender': d.get('gender') or '',
                    'qualification': d.get('qualification') or '',
                    'marks': str(marks_field)
                })
                self.dm.save_student_csv(student)
            messagebox.showinfo("Imported", "CSV imported successfully.")
            self.refresh_table()
        except Exception as e:
            messagebox.showerror("Import Error", str(e))

    def export_json(self):
        students = self.dm.load_all_students_csv()
        try:
            self.dm.save_all_json(students)
            messagebox.showinfo("Exported", f"Exported {len(students)} students to JSON.")
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def refresh_table(self):
        for r in self.tree.get_children():
            self.tree.delete(r)
        students = self.dm.load_all_students_csv()
        for s in students:
            self.tree.insert('', tk.END, values=(
                s.student_id, s.name, s.gender, s.qualification,
                ';'.join(str(m) for m in s.marks), s.average(), s.grade()
            ))

    def show_top(self):
        students = self.dm.load_all_students_csv()
        analytics = Analytics(students)
        top = analytics.top_performers(5)
        if top.empty:
            messagebox.showinfo("Top Performers", "No data available.")
            return
        txt = top[['student_id', 'name', 'average', 'grade']].to_string(index=False)
        messagebox.showinfo("Top Performers", txt)

    def show_subject_stats(self):
        students = self.dm.load_all_students_csv()
        analytics = Analytics(students)
        stats = analytics.subject_stats()
        if 'error' in stats:
            messagebox.showerror("Subject Stats", stats['error'])
            return
        msg = []
        for subj, s in stats.items():
            msg.append(f"{subj} -> mean: {s['mean']}, median: {s['median']}, min: {s['min']}, max: {s['max']}")
        messagebox.showinfo("Subject Stats", "\n".join(msg) if msg else "No data")

    def save_grade_pie(self):
        students = self.dm.load_all_students_csv()
        analytics = Analytics(students)
        try:
            out = analytics.save_grade_pie(out_path='grade_distribution.png')
            messagebox.showinfo("Saved", f"Saved grade distribution to {out}")
            if os.name == 'nt':
                os.startfile(out)
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def clear_inputs(self):
        self.e_id.delete(0, tk.END)
        self.e_name.delete(0, tk.END)
        self.e_marks.delete(0, tk.END)
        self.e_qual.delete(0, tk.END)
