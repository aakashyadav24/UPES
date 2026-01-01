/* 6. Write a Java program to calculate the discount on a product based on its price:
Price > 1000: 20% discount
Price > 500: 10% discount
Otherwise: 5% discount   */

import java.util.Scanner;

public class discount {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the product price: ");
            double price = sc.nextDouble();

            double discountPercentage;

            if (price > 1000) {
                discountPercentage = 0.20; 
            } else if (price > 500) {
                discountPercentage = 0.10; 
            } else {
                discountPercentage = 0.05; 
            }

            double discountAmount = price * discountPercentage;
            double finalPrice = price - discountAmount;

            System.out.println("Original Price: " + String.format("%.2f", price));
            System.out.println("Discount Applied: " + (discountPercentage * 100) + "%");
            System.out.println("Discount Amount: " + String.format("%.2f", discountAmount));
            System.out.println("Final Price after Discount: " + String.format("%.2f", finalPrice));
        }

    }
}
