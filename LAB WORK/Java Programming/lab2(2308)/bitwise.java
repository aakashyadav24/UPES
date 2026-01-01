import java.util.*;
public class bitwise
 {    
    public static void main(String[] args) {
	int a, b;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter number 1");
	a=sc.nextInt();
	System.out.println("Enter number 2");
	b=sc.nextInt();
	}
        int and= a&b;
	int or= a|b;
	int not= ~a;
	int ls=a<<1;
	int rs=a>>1;
		
	System.out.println("Results:");
	System.out.println("a&b:"+ and);
	System.out.println("a|b:"+ or);
	System.out.println("~a:"+ not);
	System.out.println("a<<1:"+ ls);
	System.out.println("a>>1:"+ rs);
	
    }
}