# Program to count frequency of alphabets (case-insensitive)

s = input("Enter a string: ").strip()

# Convert to uppercase for case-insensitivity
s = s.upper()

# Dictionary to store frequency
freq = {}

for ch in s:
    if ch.isalpha():   # count only alphabets
        freq[ch] = freq.get(ch, 0) + 1

# Print results
for letter, count in freq.items():
    print(f"{count}{letter}")
