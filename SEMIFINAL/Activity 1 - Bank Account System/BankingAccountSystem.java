import java.util.Scanner;

public class BankingAccountSystem {
    private int accountNumber;
    private String accountName;
    private double balance = 1500; // Initial balance

    // Getters
    public String getAccountName () {
        return accountName;
    }
    public int getAccountNumber () {
        return accountNumber;
    }
    public double getBalance () {
        return balance;
    }

    // Setters
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit  method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid input of amount to deposit."); // Inputing a negative number is invalid
        }
    }

    //Withdrew  method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw of: $" + amount + " successful");
        } else {
            System.out.println("Insufficient amount for withdrawal");
        }
    }
  
    // Display balance method
    public void display() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    public static void main (String[] args) {
        BankingAccountSystem account = new BankingAccountSystem();
        Scanner scan = new Scanner (System.in);

        System.out.print("Enter Account Name: ");
        account.setAccountName(scan.nextLine());

        System.out.print("Enter Account Number: ");
        account.setAccountNumber(scan.nextInt());

        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.print("Enter [1] to deposit [2] to withdraw [3] to display [0] to exit: ");
            int operation = scan.nextInt();
            System.out.println("------------------------------------------------------------------");
            if(operation == 1) {
                System.out.print("Enter Amount to Deposit: $");
                double amount = scan.nextDouble();
                account.deposit(amount);
            }
            else if (operation == 2) {
                System.out.print("Enter  Amount to Withdraw: $");
                double withdrewAmount = scan.nextDouble();
                account.withdraw(withdrewAmount);
            }
            else if (operation == 3) {
                account.display();
            } 
            else if (operation == 0) {
                System.out.print("The program exit successfully");
                break;
            } else {
                System.out.println("Invalid input of operation");
            }
        }
    }
}

