import java.util.*;
public class unary
 {    
    public static void main(String[] args) {
	int num;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter number 1");
	num=sc.nextInt();
	}
        System.out.println("Results:");
	System.out.println("Pre-Increment:"+ ++num);
	System.out.println("Post-Increment:"+ num++);
	System.out.println("Post-Decrement:"+ num-- );
	System.out.println("Pre-Decrement:"+ --num);
	
	
    }

}