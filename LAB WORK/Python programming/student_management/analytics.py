# analytics.py
import pandas as pd
import matplotlib.pyplot as plt
from typing import List
from models import Student
import os

# Use Agg backend for environments without display
plt.switch_backend('Agg')

class Analytics:
    def __init__(self, students: List[Student]):
        self.students = students
        self.df = self._build_df()

    def _build_df(self):
        if not self.students:
            return pd.DataFrame(columns=['student_id', 'name', 'gender', 'qualification', 'marks', 'average', 'percentage', 'grade'])
        rows = []
        for s in self.students:
            row = s.to_dict()
            row['marks'] = ';'.join(str(m) for m in s.marks)
            rows.append(row)
        df = pd.DataFrame(rows)
        for col in ['average', 'percentage']:
            if col in df.columns:
                df[col] = pd.to_numeric(df[col], errors='coerce').fillna(0.0)
        return df

    def top_performers(self, n=3):
        if self.df.empty:
            return pd.DataFrame()
        return self.df.sort_values('average', ascending=False).head(n)

    def subject_stats(self):
        if self.df.empty:
            return {}
        marks_series = self.df['marks'].dropna().apply(lambda s: [float(x) for x in s.split(';') if x.strip()!=''])
        lens = marks_series.apply(len)
        if lens.nunique() != 1:
            return {'error': 'students have varying number of subjects'}
        k = int(lens.iloc[0])
        subjects = {f"subject_{i+1}": [] for i in range(k)}
        for arr in marks_series:
            for i, val in enumerate(arr):
                subjects[f"subject_{i+1}"].append(val)
        stats = {}
        for subj, vals in subjects.items():
            series = pd.Series(vals)
            stats[subj] = {
                'mean': round(series.mean(), 2),
                'median': round(series.median(), 2),
                'min': float(series.min()),
                'max': float(series.max())
            }
        return stats

    def grade_distribution(self):
        if self.df.empty:
            return {}
        return self.df['grade'].value_counts().to_dict()

    def save_bar_plot_top(self, out_path='top_performers.png', n=5):
        df = self.top_performers(n)
        if df.empty:
            raise ValueError("No data for plotting")
        plt.figure(figsize=(8, 4))
        plt.bar(df['name'], df['average'])
        plt.title('Top Performers')
        plt.xlabel('Student')
        plt.ylabel('Average Marks')
        plt.tight_layout()
        plt.savefig(out_path)
        plt.close()
        return out_path

    def save_grade_pie(self, out_path='grade_distribution.png'):
        dist = self.grade_distribution()
        if not dist:
            raise ValueError("No grade data")
        labels = list(dist.keys())
        sizes = list(dist.values())
        plt.figure(figsize=(6, 6))
        plt.pie(sizes, labels=labels, autopct='%1.1f%%')
        plt.title('Grade Distribution')
        plt.tight_layout()
        plt.savefig(out_path)
        plt.close()
        return out_path
