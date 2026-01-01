import java.util.*;
 
// Abstract class
abstract class BankUser {
    protected String name;
    protected int accountNumber;
 
    public BankUser(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }
 
    public abstract void showDetails();
}
 
// Interface
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}
 
// Marker interface
interface Auditable { }
 
// Base Account class
class Account extends BankUser implements Transaction, Auditable {
    protected double balance;
    protected static final double MIN_BALANCE = 500.0;
 
    public Account(String name, int accountNumber, double balance) {
        super(name, accountNumber);
        this.balance = balance;
    }
 
    // Overloading deposit()
    public void deposit(int amount) {
        deposit((double) amount);
    }
 
    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited: " + amount);
    }
 
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance! Minimum balance must be maintained.");
        }
    }
 
    @Override
    public void showDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
 
// SavingsAccount inherits from Account
class SavingsAccount extends Account {
    public SavingsAccount(String name, int accountNumber, double balance) {
        super(name, accountNumber, balance);
    }
 
    @Override
    public void withdraw(double amount) {
        System.out.println("Savings Account Withdrawal:");
        super.withdraw(amount);
    }
}
 
// CurrentAccount inherits from Account
class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = -1000.0;
 
    public CurrentAccount(String name, int accountNumber, double balance) {
        super(name, accountNumber, balance);
    }
 
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
 
// Main menu-driven program
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        int choice;
 
        do {
            System.out.println("\n=== Banking System Menu ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Account Details");
            System.out.println("6. Search Account by Name");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String sName = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int sAccNo = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double sBal = sc.nextDouble();
                    accounts.add(new SavingsAccount(sName, sAccNo, sBal));
                    System.out.println("Savings Account Created!");
                    break;
 
                case 2:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String cName = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int cAccNo = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double cBal = sc.nextDouble();
                    accounts.add(new CurrentAccount(cName, cAccNo, cBal));
                    System.out.println("Current Account Created!");
                    break;
 
                case 3:
                    System.out.print("Enter Account Number: ");
                    int dAccNo = sc.nextInt();
                    for (Account acc : accounts) {
                        if (acc.accountNumber == dAccNo) {
                            System.out.print("Enter Deposit Amount: ");
                            double damt = sc.nextDouble();
                            acc.deposit(damt);
                        }
                    }
                    break;
 
                case 4:
                    System.out.print("Enter Account Number: ");
                    int wAccNo = sc.nextInt();
                    for (Account acc : accounts) {
                        if (acc.accountNumber == wAccNo) {
                            System.out.print("Enter Withdraw Amount: ");
                            double wamt = sc.nextDouble();
                            acc.withdraw(wamt);
                        }
                    }
                    break;
 
                case 5:
                    System.out.print("Enter Account Number: ");
                    int sAccDetails = sc.nextInt();
                    for (Account acc : accounts) {
                        if (acc.accountNumber == sAccDetails) {
                            acc.showDetails();
                        }
                    }
                    break;
 
                case 6:
                    System.out.print("Enter Name to Search: ");
                    sc.nextLine();
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Account acc : accounts) {
                        if (acc.name.equalsIgnoreCase(searchName)) {
                            acc.showDetails();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No account found with the name: " + searchName);
                    }
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}