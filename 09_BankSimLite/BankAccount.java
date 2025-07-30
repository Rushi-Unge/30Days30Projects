package 09_BankSimLite/src;
public class BankAccount {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountHolder,
    String accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber=accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited ₹ "+amount);
        }else{
            System.out.println("Deposit amount must be positive.");
        }
        
    }

    public void withdraw(double amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
            System.out.println("Withdraw ₹ "+amount);
        }else{
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance(){
        System.out.println("Current balance: ₹"+balance);
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
