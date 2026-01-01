/* 3. Using if-else-if Ladder ,write a Java program to grade students based on their
marks:
Marks >= 90: Grade A
Marks >= 80: Grade B
Marks >= 70: Grade C
Marks < 70: Fail  */

import java.util.*;
public class ifelsemarks
 {    
    public static void main(String[] args) {
	int marks;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter the marks");
	marks=sc.nextInt();
	}
        if(marks>=90){
		System.out.println("Grade A");
	}
	else if(marks>=80)
		System.out.println("Grade B");
	else if(marks>=70)
		System.out.println("Grade C");
	else 
		System.out.println("Fail");
	
    }
}