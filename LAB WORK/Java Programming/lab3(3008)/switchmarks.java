/* 3. Using Switch statement, write a Java program to grade students based on their
marks:
Marks >= 90: Grade A
Marks >= 80: Grade B
Marks >= 70: Grade C
Marks < 70: Fail  */

import java.util.*;
public class switchmarks
 {    
    public static void main(String[] args) {
	int marks;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the marks");
	marks=sc.nextInt();
	}
        char grade;
	if(marks>=90){
		grade='A';
	}
	else if(marks>=80)
		grade='B';
	else if(marks>=70)
		grade='C';
	else 
		grade='F';

	switch(grade){
		case 'A': 
			System.out.println("Grade A");
			break;
		case 'B': 
			System.out.println("Grade B");
			break;
		case 'C': 
			System.out.println("Grade C");
			break;
		default: 
			System.out.println("Fail");
			break;
	}
	
    }
}