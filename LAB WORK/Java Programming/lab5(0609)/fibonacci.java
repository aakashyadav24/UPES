import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();

        // --- Using for loop ---
        System.out.println("\nFibonacci using for loop:");
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }

        // --- Using while loop ---
        System.out.println("\n\nFibonacci using while loop:");
        a = 0; b = 1;
        int i = 1;
        while (i <= n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
            i++;
        }

        // --- Using do-while loop ---
        System.out.println("\n\nFibonacci using do-while loop:");
        a = 0; b = 1;
        i = 1;
        if (n > 0) {
            do {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
                i++;
            } while (i <= n);
        }

        // --- Using for-each loop ---
        System.out.println("\n\nFibonacci using for-each loop:");
        int[] fibArray = new int[n];
        if (n > 0) fibArray[0] = 0;
        if (n > 1) fibArray[1] = 1;
        for (int j = 2; j < n; j++) {
            fibArray[j] = fibArray[j - 1] + fibArray[j - 2];
        }
        for (int term : fibArray) {
            System.out.print(term + " ");
        }

        sc.close();
    }
}
