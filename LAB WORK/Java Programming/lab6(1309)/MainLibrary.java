// Base class
class Book {
    protected String title;
    protected String author;
    protected double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method overloading: applyDiscount
    public void applyDiscount(double percentage) {
        double discount = (price * percentage) / 100;
        price -= discount;
        System.out.println("Applied " + percentage + "% discount. New price: " + price);
    }

    public void applyDiscount(int amount) {
        price -= amount;
        if (price < 0) price = 0; // Prevent negative price
        System.out.println("Applied fixed discount of " + amount + ". New price: " + price);
    }

    // Method to override
    public double getFinalPrice() {
        System.out.println("Generic book final price calculation.");
        return price;
    }

    public void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: " + price);
    }
}

// EBook subclass
class EBook extends Book {
    private double downloadFee = 50.0; // Extra cost for download

    public EBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getFinalPrice() {
        double finalPrice = price + downloadFee;
        System.out.println("EBook Final Price (including download fee): " + finalPrice);
        return finalPrice;
    }
}

// PrintedBook subclass
class PrintedBook extends Book {
    private double shippingCost = 100.0; // Extra cost for shipping/printing

    public PrintedBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getFinalPrice() {
        double finalPrice = price + shippingCost;
        System.out.println("Printed Book Final Price (including shipping): " + finalPrice);
        return finalPrice;
    }
}

// Main class
public class MainLibrary {
    public static void main(String[] args) {
        // EBook
        EBook ebook = new EBook("Digital Java", "Alice", 500);
        ebook.display();
        ebook.applyDiscount(10);   // 10% discount
        ebook.applyDiscount(50);   // Fixed discount
        ebook.getFinalPrice();

        System.out.println("--------------------------");

        // PrintedBook
        PrintedBook pbook = new PrintedBook("Learn OOP", "Bob", 800);
        pbook.display();
        pbook.applyDiscount(20);   // 2
    }
}