interface Payable {
    double calculateSalary();
}

abstract class Employee {
    String name;
    double basicSalary;
    String post;

    Employee(String name, double basicSalary, String post) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.post = post;
    }

    abstract double calculateBonus(double percent);
    abstract double calculateBonus(int fixedAmount);
}

class Manager extends Employee implements Payable {
    Manager(String name, double basicSalary) {
        super(name, basicSalary, "Manager");
    }

    @Override
    double calculateBonus(double percent) {
        double bonus = basicSalary * (percent / 100);
        System.out.println(post + " " + name + " Bonus (" + percent + "%): " + bonus);
        return bonus;
    }

    @Override
    double calculateBonus(int fixedAmount) {
        System.out.println(post + " " + name + " Bonus (fixed): " + fixedAmount);
        return fixedAmount;
    }

    @Override
    public double calculateSalary() {
        return basicSalary;
    }
}

class Developer extends Employee implements Payable {
    Developer(String name, double basicSalary) {
        super(name, basicSalary, "Developer");
    }

    @Override
    double calculateBonus(double percent) {
        double bonus = basicSalary * (percent / 100);
        System.out.println(post + " " + name + " Bonus (" + percent + "%): " + bonus);
        return bonus;
    }

    @Override
    double calculateBonus(int fixedAmount) {
        System.out.println(post + " " + name + " Bonus (fixed): " + fixedAmount);
        return fixedAmount;
    }

    @Override
    public double calculateSalary() {
        return basicSalary;
    }
}

class Intern extends Employee implements Payable {
    Intern(String name, double basicSalary) {
        super(name, basicSalary, "Intern");
    }

    @Override
    double calculateBonus(double percent) {
        double bonus = basicSalary * (percent / 100);
        System.out.println(post + " " + name + " Bonus (" + percent + "%): " + bonus);
        return bonus;
    }

    @Override
    double calculateBonus(int fixedAmount) {
        System.out.println(post + " " + name + " Bonus (fixed): " + fixedAmount);
        return fixedAmount;
    }

    @Override
    public double calculateSalary() {
        return basicSalary;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 80000);
        Developer d = new Developer("Bob", 50000);
        Intern i = new Intern("Charlie", 20000);

        System.out.println(m.post + " " + m.name + " Base Salary: " + m.calculateSalary());
        m.calculateBonus(20.0);
        m.calculateBonus(10000);

        System.out.println("--------------------------");

        System.out.println(d.post + " " + d.name + " Base Salary: " + d.calculateSalary());
        d.calculateBonus(10.0);
        d.calculateBonus(5000);

        System.out.println("--------------------------");

        System.out.println(i.post + " " + i.name + " Base Salary: " + i.calculateSalary());
        i.calculateBonus(5.0);
        i.calculateBonus(2000);
    }
}
