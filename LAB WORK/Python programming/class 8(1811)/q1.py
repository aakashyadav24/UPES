with open("TestFile1.txt", "r") as file1:
    content = file1.read()

modified_content = content.replace('"', '\\"')

with open("TestFile2.txt", "w") as file2:
    file2.write(modified_content)

print("Contents of TestFile1.txt:")
print(content)

print("Contents of TestFile2.txt:")
print(modified_content)
