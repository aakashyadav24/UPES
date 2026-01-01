# main.py
import tkinter as tk
from gui import StudentApp

def main():
    root = tk.Tk()
    root.geometry("900x600")
    app = StudentApp(root)
    root.mainloop()

if __name__ == "__main__":
    main()
