class Account {
    String accNo;
    double balance;

    // Constructor
    Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    // Deposit with no amount (just showing account details)
    void deposit() {
        System.out.println("Deposit operation:");
        System.out.println("Account No: " + accNo + ", Balance: " + balance);
    }

    // Overloaded deposit methods
    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + 
                           " | Account No: " + accNo + 
                           " | Balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + 
                           " | Account No: " + accNo + 
                           " | Balance: " + balance);
    }

    // Withdraw (base version)
    void withdraw(double amount) {
        System.out.println("Withdraw request: " + amount);
    }
}

// Savings Account
class SavingsAccount extends Account {
    public static final double MIN_BALANCE = 5000.00;

    SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Updated Balance: " + balance);
        } else {
            System.out.println("Withdrawal denied! Minimum balance of " + MIN_BALANCE + " must be maintained.");
        }
    }
}

// Current Account
class CurrentAccount extends Account {
    public static final double LOCK_AMOUNT = 1000.00;

    CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount >= LOCK_AMOUNT) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Updated Balance: " + balance);
        } else {
            System.out.println("Withdrawal denied! Lock amount of " + LOCK_AMOUNT + " must remain in account.");
        }
    }
}

// Main Class
public class MainBank {
    public static void main(String[] args) {
        
        // Base Account
        Account a1 = new Account("40004007", 2000.50);
        a1.deposit();
        a1.deposit(1000);
        a1.deposit(275.50);
        a1.withdraw(10000);

        System.out.println("--------------------------");

        // Savings Account
        SavingsAccount s1 = new SavingsAccount("40004008", 7000.00);
        s1.deposit();
        s1.deposit(10000);
        s1.deposit(2755.50);
        s1.withdraw(1200);
        s1.withdraw(6000);

        System.out.println("--------------------------");

        // Current Account
        CurrentAccount c1 = new CurrentAccount("40004009", 5000.00);
        c1.deposit();
        c1.deposit(1000);
        c1.deposit(275.50);
        c1.withdraw(1500);
        c1.withdraw(4500);
    }
}
