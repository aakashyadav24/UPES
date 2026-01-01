import java.util.*;
public class arithemetic
 {    
    public static void main(String[] args) {
	int num1, num2;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter number 1");
	num1=sc.nextInt();
	System.out.println("Enter number 2");
	num2=sc.nextInt();
	}
        int sum=num1+num2;
	int sub=num1-num2;
	int mul=num1*num2;
	int div=num1/num2;
	
	System.out.println("Results:");
	System.out.println("Addition:"+ sum);
	System.out.println("Subtraction:"+ sub);
	System.out.println("Multiplication:"+ mul);
	System.out.println("Division:"+ div);
    }
}