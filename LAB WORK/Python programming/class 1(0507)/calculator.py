a=int(input("Value 1"))
b=int(input("Value 2"))

op=input("Enter the operation you want you perform(+,-,*,/)")

match op:
      case '+':
          print(f"Sum={a+b}")
      case '-':
          print(f"Subtraction={a-b}")
      case '*':
          print(f"Multiplication={a*b}")
      case '/':
          print(f"Division={a/b}")
      case _:
          print("Invalid command")
      

      
