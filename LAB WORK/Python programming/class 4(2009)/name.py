# Program to print initials and last name properly formatted

# Input full name
full_name = input("Enter full name (first middle last): ").strip()

# Split into parts
parts = full_name.split()

# Extract names
first = parts[0]
middle = parts[1]
last = parts[2]

# Build output
result = first[0].upper() + "." + middle[0].upper() + ". " + last.capitalize()

print(result)
