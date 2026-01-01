# Student Performance Management System

## Overview
A small Python/Tkinter application to add student records, compute averages/grades, save to CSV, export to JSON and perform simple analytics (top performers, subject stats, grade distribution).

## Files
- `main.py` - launches the GUI
- `gui.py`, `models.py`, `data_manager.py`, `analytics.py` - core modules
- `sample_data.csv` - sample dataset you can import
- `requirements.txt` - Python dependencies

## Run (Linux / Windows / Mac)
1. Install Python 3.8+ and pip.
2. (Linux) Ensure tkinter is installed: `sudo apt-get install python3-tk`
3. Create virtual env (optional):
   ```
   python -m venv venv
   source venv/bin/activate   # Linux/Mac
   venv\Scripts\activate    # Windows
   ```
4. Install:
   ```
   pip install -r requirements.txt
   ```
5. Run:
   ```
   python main.py
   ```

## Syllabus reference
The project is aligned with the Python Programming syllabus provided by the user:
`/mnt/data/Syllabus_Python-MCA Computer Science_AY2025.pdf`

## Features
- Add student record (ID, Name, Gender, Qualification, Marks)
- Save to CSV (`students.csv`)
- Import an external CSV (supports multiple formats)
- Export all data to JSON
- Show top performers and subject-wise stats
- Save grade distribution pie chart as `grade_distribution.png`

## Extending
- Add database (SQLite) backend
- Add login/user roles (teacher/admin)
- Add CSV export/download, or charts in GUI panel
