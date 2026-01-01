import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            // --- Using while loop ---
            int num = n;
            int sumWhile = 0;
            while (num > 0) {
                int digit = num % 10;
                sumWhile += digit;
                num /= 10;
            }
            System.out.println("Sum using while loop: " + sumWhile);

            // --- Using do-while loop ---
            num = n;
            int sumDoWhile = 0;
            if (num == 0) {
                sumDoWhile = 0;
            } else {
                do {
                    int digit = num % 10;
                    sumDoWhile += digit;
                    num /= 10;
                } while (num > 0);
            }
            System.out.println("Sum using do-while loop: " + sumDoWhile);

            // --- Using for loop ---
            num = n;
            int sumFor = 0;
            for (; num > 0; num /= 10) {
                int digit = num % 10;
                sumFor += digit;
            }
            System.out.println("Sum using for loop: " + sumFor);

            // --- Using for-each loop ---
            String strNum = Integer.toString(n);  
            char[] digits = strNum.toCharArray(); 
            int sumForEach = 0;
            for (char d : digits) {
                sumForEach += Character.getNumericValue(d); 
            }
            System.out.println("Sum using for-each loop: " + sumForEach);

            sc.close();
        }
    }
}
