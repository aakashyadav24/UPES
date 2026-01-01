import numpy as np

# 1. Create an array and find max & min
arr = np.array([10, 5, 7, 20, 15, -9, 33])
print("Array:", arr)
print("Maximum value:", np.max(arr))
print("Minimum value:", np.min(arr))

# 2. Find max without using max()
arr2 = np.array(list(map(int, input("Enter array elements separated by space: ").split())))
max_val = arr2[0]
for num in arr2:
    if num > max_val:
        max_val = num
print("Maximum value (without max()):", max_val)

# 3. Matrix addition & subtraction
mat1 = np.array([[1, 2], [3, 4]])
mat2 = np.array([[2, 4], [6, 8]])
print("Matrix 1:\n", mat1)
print("Matrix 2:\n", mat2)
print("Sum:\n", mat1 + mat2)
print("Subtraction:\n", mat1 - mat2)

# 4. Random 5x6 matrix, add new row & sum rows
rand_matrix = np.random.rand(5, 6)
print("Original Matrix:\n", rand_matrix)
new_row = np.random.rand(1, 6)
updated_matrix = np.vstack([rand_matrix, new_row])
print("Updated Matrix:\n", updated_matrix)
row_sums = np.sum(updated_matrix, axis=1)
print("Sum of each row:", row_sums)

# 5. Random integer 5x6 matrix, add new column & compute sine
rand_int_matrix = np.random.randint(1, 10, size=(5, 6))
print("Original Integer Matrix:\n", rand_int_matrix)
new_col = np.random.randint(1, 10, size=(5, 1))
updated_matrix_int = np.hstack([rand_int_matrix, new_col])
print("Updated Matrix with new column:\n", updated_matrix_int)
sine_matrix = np.sin(updated_matrix_int)
print("Sine of each element:\n", sine_matrix)
