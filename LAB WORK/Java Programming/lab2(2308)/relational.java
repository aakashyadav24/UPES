import java.util.*;
public class relational
 {    
    public static void main(String[] args) {
	int num1, num2;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter number 1");
	num1=sc.nextInt();
	System.out.println("Enter number 2");
	num2=sc.nextInt();
	}
        System.out.println("Results:");
	if(num1>num2){
	System.out.println("Number 1 is greater than Number 2");}
	else if(num2>num1){
	System.out.println("Number 2 is greater than Number 1");}
	else{
	System.out.println("Number 1 and Number 2 are equal");}
	
    }
}