# Read number of stamps
n = int(input("Enter number of stamps: "))

# Create an empty set to store distinct stamps
stamps = set()

# Read each country name and add to the set
for _ in range(n):
    country = input("Enter country name: ")
    stamps.add(country)

# Print number of distinct stamps
print(len(stamps))
