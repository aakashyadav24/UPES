import java.util.Scanner;

public class MatrixTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input matrix elements
        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n--- Row-wise Traversal ---");

        // ---------- FOR loop ----------
        System.out.println("FOR loop:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // ---------- WHILE loop ----------
        System.out.println("WHILE loop:");
        int i = 0;
        while (i < rows) {
            int j = 0;
            while (j < cols) {
                System.out.print(matrix[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }

        // ---------- DO-WHILE loop ----------
        System.out.println("DO-WHILE loop:");
        int r = 0;
        if (rows > 0 && cols > 0) {
            do {
                int c = 0;
                do {
                    System.out.print(matrix[r][c] + " ");
                    c++;
                } while (c < cols);
                System.out.println();
                r++;
            } while (r < rows);
        }

        // ---------- FOR-EACH loop ----------
        System.out.println("FOR-EACH loop:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("\n--- Column-wise Traversal ---");

        // ---------- FOR loop ----------
        System.out.println("FOR loop:");
        for (int j = 0; j < cols; j++) {
            for (int k = 0; k < rows; k++) {
                System.out.print(matrix[k][j] + " ");
            }
            System.out.println();
        }

        // ---------- WHILE loop ----------
        System.out.println("WHILE loop:");
        int c1 = 0;
        while (c1 < cols) {
            int r1 = 0;
            while (r1 < rows) {
                System.out.print(matrix[r1][c1] + " ");
                r1++;
            }
            System.out.println();
            c1++;
        }

        // ---------- DO-WHILE loop ----------
        System.out.println("DO-WHILE loop:");
        int c2 = 0;
        if (rows > 0 && cols > 0) {
            do {
                int r2 = 0;
                do {
                    System.out.print(matrix[r2][c2] + " ");
                    r2++;
                } while (r2 < rows);
                System.out.println();
                c2++;
            } while (c2 < cols);
        }

        // ---------- FOR-EACH loop (Trick: Not direct, so transpose logic) ----------
        System.out.println("FOR-EACH loop:");
        for (int j = 0; j < cols; j++) {
            for (int[] row : matrix) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
