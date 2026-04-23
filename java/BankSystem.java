import java.util.Scanner;

public class BankSystem {

    // Private attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankSystem(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // ================= METHODS =================

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposit successful: ₱" + amount);
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
            System.out.println("\nWithdrawal successful: ₱" + amount);
            System.out.println("Updated Balance: ₱" + balance);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n================================");
        System.out.println("        BANK ACCOUNT INFO");
        System.out.println("================================");
        System.out.println("Account Number     : " + accountNumber);
        System.out.println("Account Holder     : " + accountHolder);
        System.out.println("Remaining Balance  : ₱" + balance);
        System.out.println("================================");
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     WELCOME TO JAVAWOCKEEZ BANK");
        System.out.println("================================");

        // User input
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Starting Balance: ₱");
        double startingBalance = scanner.nextDouble();

        // Create object
        BankSystem myAccount = new BankSystem(accNum, accHolder, startingBalance);

        boolean continueTransaction = true;

        // Loop for continuous transactions
        while (continueTransaction) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ₱");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₱");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    myAccount.displayAccountDetails();
                    break;

                case 4:
                    continueTransaction = false;
                    System.out.println("\nThank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Final display before exit
        myAccount.displayAccountDetails();

        scanner.close();
    }
}