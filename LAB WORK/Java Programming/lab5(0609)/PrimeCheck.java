import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // ---------- Using FOR loop ----------
        boolean isPrimeFor = true;
        if (n <= 1) {
            isPrimeFor = false;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    isPrimeFor = false;
                    break;
                }
            }
        }
        System.out.println("FOR loop -> " + (isPrimeFor ? "Prime" : "Not Prime"));

        // ---------- Using WHILE loop ----------
        boolean isPrimeWhile = true;
        if (n <= 1) {
            isPrimeWhile = false;
        } else {
            int i = 2;
            while (i <= n / 2) {
                if (n % i == 0) {
                    isPrimeWhile = false;
                    break;
                }
                i++;
            }
        }
        System.out.println("WHILE loop -> " + (isPrimeWhile ? "Prime" : "Not Prime"));

        // ---------- Using DO-WHILE loop ----------
        boolean isPrimeDo = true;
        if (n <= 1) {
            isPrimeDo = false;
        } else {
            int i = 2;
            do {
                if (n % i == 0) {
                    isPrimeDo = false;
                    break;
                }
                i++;
            } while (i <= n / 2);
        }
        System.out.println("DO-WHILE loop -> " + (isPrimeDo ? "Prime" : "Not Prime"));

        // ---------- Using FOR-EACH loop ----------
        // Trick: create an array of possible divisors
        boolean isPrimeFE = true;
        if (n <= 1) {
            isPrimeFE = false;
        } else {
            int[] divisors = new int[n / 2 - 1];
            for (int i = 0; i < divisors.length; i++) {
                divisors[i] = i + 2;
            }

            for (int d : divisors) {
                if (n % d == 0) {
                    isPrimeFE = false;
                    break;
                }
            }
        }
        System.out.println("FOR-EACH loop -> " + (isPrimeFE ? "Prime" : "Not Prime"));

        sc.close();
    }
}
