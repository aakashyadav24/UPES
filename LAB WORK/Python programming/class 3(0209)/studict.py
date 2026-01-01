n=int(input("Enter the number of students:"))
stu={}

for i in range(n):
    parts = input(f"Enter name and marks for student {i+1}: ").split()
    name = parts[0]
    marks = list(map(int, parts[1:]))
    stu[name]=marks

name1=input("Enter the student you want to calculate average for:")

average = sum(stu[name1]) / len(stu[name1])

print(f"Average for {name1} is :{average:.2f}")