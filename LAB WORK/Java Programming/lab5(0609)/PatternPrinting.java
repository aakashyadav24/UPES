import java.util.Scanner;

public class PatternPrinting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of rows
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        // ---------- FOR loop ----------
        System.out.println("FOR loop:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ---------- WHILE loop ----------
        System.out.println("WHILE loop:");
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

        // ---------- DO-WHILE loop ----------
        System.out.println("DO-WHILE loop:");
        int r = 1;
        do {
            int c = 1;
            do {
                System.out.print("*");
                c++;
            } while (c <= r);
            System.out.println();
            r++;
        } while (r <= n);

        // ---------- FOR-EACH loop (Trick: simulate with array of row numbers) ----------
        System.out.println("FOR-EACH loop:");
        int[] rows = new int[n];
        for (int k = 0; k < n; k++) {
            rows[k] = k + 1;
        }
        for (int row : rows) {
            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
