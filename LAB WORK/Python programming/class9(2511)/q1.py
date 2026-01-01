def perform_division():
    try:
        num_testcases = int(input())
    except ValueError as e:
        print(f"Error Code: {e}")
        return

    for _ in range(num_testcases):
        try:
            a_str, b_str = input().split()
            a = int(a_str)
            b = int(b_str)
            print(a // b)
        except ZeroDivisionError as e:
            print(f"Error Code: {e}")
        except ValueError as e:
            print(f"Error Code: {e}")

perform_division()