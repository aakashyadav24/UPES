import java.util.Scanner;

public class multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("\n--- Using for loop ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        System.out.println("\n--- Using while loop ---");
        int i = 1;
        while (i <= 10) {
            System.out.println(n + " x " + i + " = " + (n * i));
            i++;
        }

        System.out.println("\n--- Using do-while loop ---");
        i = 1;
        do {
            System.out.println(n + " x " + i + " = " + (n * i));
            i++;
        } while (i <= 10);

        System.out.println("\n--- Using for-each loop ---");
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int num : nums) {
            System.out.println(n + " x " + num + " = " + (n * num));
        }

        sc.close();
    }
}
