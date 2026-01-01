// Base class
class Employee {
    protected String name;
    protected double salary;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method overloading: calculateBonus
    public double calculateBonus(double percentage) {
        double bonus = (salary * percentage) / 100;
        System.out.println(name + " bonus (" + percentage + "%): " + bonus);
        return bonus;
    }

    public double calculateBonus(int fixedAmount) {
        System.out.println(name + " fixed bonus: " + fixedAmount);
        return fixedAmount;
    }

    // Method to override in subclasses
    public double calculateBonus() {
        System.out.println("Generic employee bonus calculation.");
        return 0.0;
    }

    public void display() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        double bonus = salary * 0.20; // Managers get 20% bonus
        System.out.println("Manager " + name + " bonus: " + bonus);
        return bonus;
    }
}

// Developer subclass
class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        double bonus = salary * 0.15; // Developers get 15% bonus
        System.out.println("Developer " + name + " bonus: " + bonus);
        return bonus;
    }
}

// Intern subclass
class Intern extends Employee {
    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        double bonus = 1000; // Interns get a fixed stipend bonus
        System.out.println("Intern " + name + " bonus: " + bonus);
        return bonus;
    }
}

// Main class
public class MainEmployee {
    public static void main(String[] args) {
        // Manager
        Manager m1 = new Manager("Alice", 80000);
        m1.display();
        m1.calculateBonus();
        m1.calculateBonus(10.0);  // Overloaded
        m1.calculateBonus(5000);  // Overloaded

        System.out.println("--------------------------");

        // Developer
        Developer d1 = new Developer("Bob", 60000);
        d1.display();
        d1.calculateBonus();
        d1.calculateBonus(12.5);
        d1.calculateBonus(3000);

        System.out.println("--------------------------");

        // Intern
        Intern i1 = new Intern("Charlie", 20000);
        i1.display();
        i1.calculateBonus();
        i1.calculateBonus(5.0);
        i1.calculateBonus(1000);
    }
}

