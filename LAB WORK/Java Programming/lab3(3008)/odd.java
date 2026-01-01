// 2. Write a Java program to check if a number is even or odd using an if-else statement.

import java.util.*;
public class odd
 {    
    public static void main(String[] args) {
	int num;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter a number");
	num=sc.nextInt();
	}
        if(num%2==0){
		System.out.println("The number is Even");
	}
	else
		System.out.println("The number is Odd");
	
    }

}