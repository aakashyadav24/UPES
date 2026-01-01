interface Discountable {
    void applyDiscount(double percent);
    void applyDiscount(int amount);
}

abstract class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    abstract double getFinalPrice();
}

class EBook extends Book implements Discountable {
    double downloadFee = 50;

    EBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void applyDiscount(double percent) {
        price -= price * (percent / 100);
    }

    @Override
    public void applyDiscount(int amount) {
        price -= amount;
    }

    @Override
    double getFinalPrice() {
        return price + downloadFee;
    }
}

class PrintedBook extends Book implements Discountable {
    double shippingCost = 100;

    PrintedBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void applyDiscount(double percent) {
        price -= price * (percent / 100);
    }

    @Override
    public void applyDiscount(int amount) {
        price -= amount;
    }

    @Override
    double getFinalPrice() {
        return price + shippingCost;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("Digital Java", "Alice", 500);
        PrintedBook printed = new PrintedBook("Java Basics", "Bob", 800);

        System.out.println("EBook: " + ebook.title + " by " + ebook.author);
        ebook.applyDiscount(10.0);
        System.out.println("Final Price after discount: " + ebook.getFinalPrice());

        System.out.println("--------------------------");

        System.out.println("PrintedBook: " + printed.title + " by " + printed.author);
        printed.applyDiscount(200);
        System.out.println("Final Price after discount: " + printed.getFinalPrice());
    }
}
