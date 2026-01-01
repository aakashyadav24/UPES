import numpy as np

numbers = [1, 2.0, 3]
arr_str = np.array(numbers, dtype=str)
print("a) Array with string type:", arr_str)
print("   Data type:", arr_str.dtype)

arr_2d = np.array([[1, 2, 3], [4, 5, 6]], dtype=np.int32)
print("\nb) 2D Array:\n", arr_2d)
print("   Data type:", arr_2d.dtype)

rows, cols = arr_2d.shape
print("\nc) Rows:", rows)
print("   Columns:", cols)

random_nums = np.random.randint(1, 101, size=10)
print("\nd) 10 Random numbers between 1 and 100:\n", random_nums)
