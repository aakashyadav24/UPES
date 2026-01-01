import numpy as np

print("a) Help on np.add function:\n")
help(np.add)

arr1 = np.array(list(map(int, input("\nEnter elements for first array (space-separated): ").split())))
none_zero = True
for x in arr1:
    if x == 0:
        none_zero = False
        break
print("b) None of the elements is zero:", none_zero)

arr2 = np.array(list(map(int, input("\nEnter elements for second array (space-separated): ").split())))
any_nonzero = False
for x in arr2:
    if x != 0:
        any_nonzero = True
        break
print("c) Any of the elements is non-zero:", any_nonzero)

rand_normal = np.random.randn(15)
print("\nd) 15 random numbers from a standard normal distribution:\n", rand_normal)
