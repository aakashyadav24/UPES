# Program to count occurrences of a substring in a string (left to right)

# Input
main_string = input("Enter the main string: ").strip()
sub_string = input("Enter the substring: ").strip()

count = 0
i = 0

while i <= (len(main_string) - len(sub_string)+1):
    if main_string[i:i+len(sub_string)] == sub_string:
        count += 1
    i += 1   # move one step (to allow overlapping matches)

print("Number of occurrences:", count)
