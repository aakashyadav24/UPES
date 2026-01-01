import java.util.*;
public class logical
 {    
    public static void main(String[] args) {
	int a, b;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter number 1");
	a=sc.nextInt();
	System.out.println("Enter number 2");
	b=sc.nextInt();
	}
        boolean and= (a>0) && (b>0);
	boolean or= (a>0) || (b>0);
	boolean not=!(a>b);
	
	System.out.println("Results:");
	System.out.println("(a>0) && (b>0):"+ and);
	System.out.println("(a>0) || (b>0):"+ or);
	System.out.println("!(a>b):"+ not);
	
    }
}