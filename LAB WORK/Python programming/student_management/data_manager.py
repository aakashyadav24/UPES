# data_manager.py
import csv
import json
from typing import List
from models import Student
import os

CSV_HEADERS = ['student_id', 'name', 'gender', 'qualification', 'marks']  # marks stored as semicolon-separated

class DataManager:
    def __init__(self, csv_path: str = "students.csv", json_path: str = "students.json"):
        self.csv_path = csv_path
        self.json_path = json_path
        # ensure files exist
        if not os.path.exists(self.csv_path):
            with open(self.csv_path, 'w', newline='', encoding='utf-8') as f:
                writer = csv.DictWriter(f, fieldnames=CSV_HEADERS)
                writer.writeheader()
        if not os.path.exists(self.json_path):
            with open(self.json_path, 'w', encoding='utf-8') as f:
                json.dump([], f, indent=2)

    def save_student_csv(self, student: Student):
        try:
            with open(self.csv_path, 'a', newline='', encoding='utf-8') as f:
                writer = csv.DictWriter(f, fieldnames=CSV_HEADERS)
                marks_serialized = ';'.join(str(m) for m in student.marks)
                writer.writerow({
                    'student_id': student.student_id,
                    'name': student.name,
                    'gender': student.gender,
                    'qualification': student.qualification,
                    'marks': marks_serialized
                })
        except Exception as e:
            raise IOError(f"Could not write to CSV: {e}")

    def load_all_students_csv(self) -> List[Student]:
        students = []
        try:
            with open(self.csv_path, 'r', newline='', encoding='utf-8') as f:
                reader = csv.DictReader(f)
                for row in reader:
                    if not row or row.get('student_id') is None:
                        continue
                    students.append(Student.from_dict(row))
        except FileNotFoundError:
            return []
        except Exception as e:
            raise IOError(f"Could not read CSV: {e}")
        return students

    def save_all_json(self, students: List[Student]):
        try:
            with open(self.json_path, 'w', encoding='utf-8') as f:
                json.dump([s.to_dict() for s in students], f, indent=2)
        except Exception as e:
            raise IOError(f"Could not write JSON: {e}")

    def load_all_json(self) -> List[Student]:
        try:
            with open(self.json_path, 'r', encoding='utf-8') as f:
                data = json.load(f)
            return [Student.from_dict(d) for d in data]
        except FileNotFoundError:
            return []
        except json.JSONDecodeError:
            return []
        except Exception as e:
            raise IOError(f"Could not read JSON: {e}")
