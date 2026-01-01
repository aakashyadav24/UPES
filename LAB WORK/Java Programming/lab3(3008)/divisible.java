// 4. Write a Java program to check if a number is divisible by both 3 and 5

import java.util.*;
public class divisible
 {    
    public static void main(String[] args) {
	int num;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter a number");
	num=sc.nextInt();
	}
        if(num%3==0){
		if(num%5==0){
			System.out.println("The number is divisible by both 3 and 5");
		}
		else
			System.out.println("The number is divisible by 3 but not by 5");
	}
	else if(num%5==0){
		if(num%3==0){
			System.out.println("The number is divisible by both 3 and 5");
		}
		else
			System.out.println("The number is divisible by 5 but not by 3");
	}		

	
    }
}

