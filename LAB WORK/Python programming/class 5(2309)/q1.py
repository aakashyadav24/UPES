# Function to add natural numbers up to n
def sum_natural(n):
    return n * (n + 1) // 2   # formula-based sum

# Function to print Fibonacci series up to n terms
def fibonacci(n):
    a, b = 0, 1
    series = []
    for _ in range(n):
        series.append(a)
        a, b = b, a + b
    return series


# --- Main Program ---
n = int(input("Enter a number: "))

# 1. Sum of natural numbers
print(f"Sum of natural numbers up to {n}: {sum_natural(n)}")

# 2. Fibonacci series
print(f"Fibonacci series up to {n} terms: {fibonacci(n)}")
