import java.util.Scanner;

public class FactorialUsingLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // --- Using for loop ---
        long factFor = 1;
        for (int i = 1; i <= n; i++) {
            factFor *= i;
        }
        System.out.println("Factorial using for loop: " + factFor);

        // --- Using while loop ---
        long factWhile = 1;
        int i = 1;
        while (i <= n) {
            factWhile *= i;
            i++;
        }
        System.out.println("Factorial using while loop: " + factWhile);

        // --- Using do-while loop ---
        long factDoWhile = 1;
        i = 1;
        if (n == 0) {   // special case for 0!
            factDoWhile = 1;
        } else {
            do {
                factDoWhile *= i;
                i++;
            } while (i <= n);
        }
        System.out.println("Factorial using do-while loop: " + factDoWhile);

        // --- Using for-each loop ---
        long factForEach = 1;
        int[] numbers = new int[n];
        for (int j = 0; j < n; j++) {
            numbers[j] = j + 1;
        }
        for (int num : numbers) {
            factForEach *= num;
        }
        System.out.println("Factorial using for-each loop: " + factForEach);

        sc.close();
    }
}
