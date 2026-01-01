
interface Depositable
{
    void deposit(int amount);
    void deposit(double amount);
}
abstract class Account
{
    int accountNumber;
    double balance;
    Account(int accountNumber, double balance)
    {
       this.accountNumber= accountNumber;
       this.balance= balance;
    }
    abstract void withdraw(double amount);
    void showBalance()
    {
        System.out.println("Account No.:"+accountNumber+",Balance:"+balance);
    }
}
class SavingsAccount extends Account implements Depositable
{
  private static final double MIN_BALANCE=500.0; 
  SavingsAccount(int accountNumber, double balance)
  {
     super(accountNumber, balance);
  }
    void withdraw(double amount)
    {
        if(balance-amount>=MIN_BALANCE)
        {
            balance-=amount;
            System.out.println("SavingsAccount:withdrawn"+ amount);
        }
        else
        {
           System.out.println("SavingsAccount:withdrawl denied! Minimum balance must be mantained");  
        }
        }
    public void deposit(int amount)
    {
        balance+=amount;
         System.out.println("SavingsAccount: DEposited"+ amount);
    }
    public void deposit(double amount)
    {
        balance+=amount;
         System.out.println("SavingsAccount: DEposited"+ amount);
    }
}
 
class CurrentAccount extends Account implements Depositable
{
  private static final double OVERDRAFT_LIMIT=1000.0; 
  CurrentAccount(int accountNumber, double balance)
  {
     super(accountNumber, balance);
  }
    void withdraw(double amount)
    {
        if(balance-amount>=OVERDRAFT_LIMIT)
        {
            balance-=amount;
            System.out.println("CurrentAccount:withdrawn"+ amount);
        }
        else
        {
           System.out.println("CurrentAccount:withdrawl denied! Minimum balance must be mantained");  
        }
        }
    public void deposit(int amount)
    {
        balance+=amount;
         System.out.println("CurrentAccount: DEposited"+ amount);
    }
    public void deposit(double amount)
    {
        balance+=amount;
         System.out.println("CurrentAccount: DEposited"+ amount);
    }
}
class bank
{
    public static void main(String[] ar)
    {
        SavingsAccount sa=new SavingsAccount(1234, 3000.0);
        CurrentAccount ca =new CurrentAccount(5678, 2000.0);
        sa.showBalance();
        sa.deposit(600);
        sa.withdraw(3200);
        sa.showBalance();
        System.out.println("------------------------");
         ca.showBalance();
        ca.deposit(600);
        ca.withdraw(1200);
        ca.showBalance();
    }
}