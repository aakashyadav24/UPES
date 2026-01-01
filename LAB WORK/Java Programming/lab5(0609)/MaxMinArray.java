import java.util.Scanner;

public class MaxMinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ---------- Using FOR loop ----------
        int maxFor = arr[0], minFor = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxFor) maxFor = arr[i];
            if (arr[i] < minFor) minFor = arr[i];
        }
        System.out.println("FOR loop -> Max: " + maxFor + ", Min: " + minFor);

        // ---------- Using WHILE loop ----------
        int maxWhile = arr[0], minWhile = arr[0];
        int i = 1;
        while (i < n) {
            if (arr[i] > maxWhile) maxWhile = arr[i];
            if (arr[i] < minWhile) minWhile = arr[i];
            i++;
        }
        System.out.println("WHILE loop -> Max: " + maxWhile + ", Min: " + minWhile);

        // ---------- Using DO-WHILE loop ----------
        int maxDo = arr[0], minDo = arr[0];
        int j = 1;
        do {
            if (arr[j] > maxDo) maxDo = arr[j];
            if (arr[j] < minDo) minDo = arr[j];
            j++;
        } while (j < n);
        System.out.println("DO-WHILE loop -> Max: " + maxDo + ", Min: " + minDo);

        // ---------- Using FOR-EACH loop ----------
        int maxFE = arr[0], minFE = arr[0];
        for (int val : arr) {
            if (val > maxFE) maxFE = val;
            if (val < minFE) minFE = val;
        }
        System.out.println("FOR-EACH loop -> Max: " + maxFE + ", Min: " + minFE);

        sc.close();
    }
}
