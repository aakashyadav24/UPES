// 1. Write a Java program to check if a number is positive or negative using an if statement

import java.util.*;
public class positive
 {    
    public static void main(String[] args) {
	int num;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter a number");
	num=sc.nextInt();
	}
        if(num>=0){
		System.out.println("The number is positive");
	}
	else
		System.out.println("The number is negative");
	
    }
}