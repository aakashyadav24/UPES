n=int(input("Enter a positive integer:"))
if n%2==0:
    if(2<=n<=6):
        print("Not weird")
    if(6<=n<=20):
        print("Weird")
    if(n>20):
        print("Not Weird")
else:
    print("Not Weird")
