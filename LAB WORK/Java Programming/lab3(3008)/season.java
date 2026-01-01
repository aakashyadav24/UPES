/* 5. Write a Java program to print the season based on the month number:
12, 1, 2: Winter
3, 4, 5: Spring
6, 7, 8: Summer
9, 10, 11: Autumn  */

import java.util.Scanner;

public class season {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the month number (1-12): ");
            int month = input.nextInt();

            String season;

            switch (month) {
                case 12:
                case 1:
                case 2:
                    season = "Winter";
                    break;
                case 3:
                case 4:
                case 5:
                    season = "Spring";
                    break;
                case 6:
                case 7:
                case 8:
                    season = "Summer";
                    break;
                case 9:
                case 10:
                case 11:
                    season = "Autumn";
                    break;
                default:
                    season = "Invalid month number";
                    break;
            }

            System.out.println("The season for month " + month + " is: " + season);
        }
    }
}