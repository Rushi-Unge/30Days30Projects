package 09_BankSimLite/src;
import java.util.Scanner;


public class BankSimLite {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String storedUsername = "rushikesh";
        String storedPassword = "12345";

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!username.equals(storedUsername) || !password.equals(storedPassword)) {
            System.out.println("Login failed! Invalid credentials.");
            return;
        }

        System.out.println("\n Login Successful");
        BankAccount account = new BankAccount("Rushikesh Unge","110026572717",3000.0);
        
        while (true) { 
            System.out.println("\n ===== Bank Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");

            System.out.println("Choose an option: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter deposit amount : ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                    case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

