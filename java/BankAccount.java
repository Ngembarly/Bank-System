import java.util.Scanner;

public class BankAccount {

    // Private attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful: ₱" + amount);
            System.out.println("Updated Balance: ₱" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Transaction failed: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: ₱" + amount);
            System.out.println("Updated Balance: ₱" + balance);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n================================");
        System.out.println("        BANK ACCOUNT INFO");
        System.out.println("================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Remaining Balance : ₱" + balance);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     WELCOME TO JAVAWOCKEEZ BANK");
        System.out.println("================================");

        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Starting Balance: ₱");
        double startingBalance = scanner.nextDouble();

        BankAccount myAccount = new BankAccount(accNum, accHolder, startingBalance);

        System.out.print("\nEnter amount to deposit: ₱");
        double depositAmount = scanner.nextDouble();
        myAccount.deposit(depositAmount);

        System.out.print("\nEnter amount to withdraw: ₱");
        double withdrawAmount = scanner.nextDouble();
        myAccount.withdraw(withdrawAmount);

        myAccount.displayAccountDetails();

        scanner.close();
    }
}