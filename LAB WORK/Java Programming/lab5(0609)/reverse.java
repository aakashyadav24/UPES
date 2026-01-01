import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            // --- Using while loop ---
            int num = n;
            int revWhile = 0;
            while (num > 0) {
                int digit = num % 10;
                revWhile = revWhile * 10 + digit;
                num /= 10;
            }
            System.out.println("Reverse using while loop: " + revWhile);

            // --- Using do-while loop ---
            num = n;
            int revDoWhile = 0;
            if (num == 0) {
                revDoWhile = 0;
            } else {
                do {
                    int digit = num % 10;
                    revDoWhile = revDoWhile * 10 + digit;
                    num /= 10;
                } while (num > 0);
            }
            System.out.println("Reverse using do-while loop: " + revDoWhile);

            // --- Using for loop ---
            num = n;
            int revFor = 0;
            for (; num > 0; num /= 10) {
                int digit = num % 10;
                revFor = revFor * 10 + digit;
            }
            System.out.println("Reverse using for loop: " + revFor);

            // --- Using for-each loop ---
            String strNum = Integer.toString(n);
            char[] digits = strNum.toCharArray();
            String revForEach = "";
            for (char d : digits) {
                revForEach = d + revForEach; // prepend digit
            }
            System.out.println("Reverse using for-each loop: " + revForEach);

            sc.close();
        }
    }
}
