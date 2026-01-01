# models.py
from dataclasses import dataclass, field, asdict
from typing import List, Dict

@dataclass
class Student:
    student_id: str
    name: str
    gender: str
    qualification: str
    marks: List[float] = field(default_factory=list)

    def percentage(self) -> float:
        if not self.marks:
            return 0.0
        # if marks are out of 100 per subject, calculate percentage; otherwise fallback to average
        if max(self.marks) <= 100:
            return round(sum(self.marks) / (len(self.marks) * 100) * 100, 2)
        return round(sum(self.marks) / len(self.marks), 2)

    def average(self) -> float:
        return round(sum(self.marks) / len(self.marks), 2) if self.marks else 0.0

    def grade(self) -> str:
        avg = self.average()
        if avg >= 90: return "A+"
        if avg >= 80: return "A"
        if avg >= 70: return "B"
        if avg >= 60: return "C"
        if avg >= 50: return "D"
        return "F"

    def to_dict(self) -> Dict:
        d = asdict(self)
        d['percentage'] = self.percentage()
        d['average'] = self.average()
        d['grade'] = self.grade()
        return d

    @staticmethod
    def from_dict(d: Dict) -> "Student":
        marks = d.get("marks", [])
        if isinstance(marks, str):
            # accept semicolon, comma or space separated marks
            marks = [float(x) for x in marks.replace(',', ';').split(';') if x.strip()!='']
        elif isinstance(marks, list):
            marks = [float(x) for x in marks]
        else:
            marks = []
        return Student(
            student_id=str(d.get("student_id") or ""),
            name=str(d.get("name") or ""),
            gender=str(d.get("gender") or ""),
            qualification=str(d.get("qualification") or ""),
            marks=marks
        )
