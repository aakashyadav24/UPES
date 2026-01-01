# Read number of students
n = int(input("Enter number of students: "))

# Read the scores as a list of integers
scores = list(map(int, input("Enter the scores: ").split()))

# Remove duplicates so only unique scores remain
unique_scores = list(set(scores))

# Sort in descending order
unique_scores.sort(reverse=True)

# Runner-up is the second element
if len(unique_scores) > 1:
    print(unique_scores[1])
else:
    print("No runner-up (all scores are the same)")
