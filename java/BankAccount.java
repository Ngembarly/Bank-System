import java.util.Scanner;

public class BankAccount {

  // Attributes
  String accountNumber;
  String accountName;
  double balance;

  // Deposit Method
  void deposit(double amount) {
    balance = balance + amount;
    System.out.println(">> Deposited: ₱" + amount);
  }

  // Withdraw Method
  void withdraw(double amount) {
    if (amount <= balance) {
      balance = balance - amount;
      System.out.println(">> Withdrawn: ₱" + amount);
    } else {
      System.out.println(">> Insufficient Balance!");
    }
  }

  // Display Balance Method
  void displayBalance() {
    System.out.println("\n==============================");
    System.out.println("      ACCOUNT SUMMARY");
    System.out.println("==============================");
    System.out.println("Account Number : " + accountNumber);
    System.out.println("Account Name   : " + accountName);
    System.out.println("Final Balance  : ₱" + balance);
    System.out.println("==============================");
  }

  // Main Method
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    BankAccount acct = new BankAccount();

    System.out.println("=================================");
    System.out.println("      SIMPLE BANK SYSTEM");
    System.out.println("=================================");

    // Input Account Details
    System.out.print("Enter Account Number: ");
    acct.accountNumber = input.nextLine();

    System.out.print("Enter Account Name: ");
    acct.accountName = input.nextLine();

    System.out.print("Enter Initial Balance: ₱");
    acct.balance = input.nextDouble();

    // First Deposit
    System.out.print("\nEnter First Deposit Amount: ₱");
    double dep1 = input.nextDouble();
    acct.deposit(dep1);

    // Second Deposit
    System.out.print("Enter Second Deposit Amount: ₱");
    double dep2 = input.nextDouble();
    acct.deposit(dep2);

    // Withdrawal
    System.out.print("Enter Withdrawal Amount: ₱");
    double wd = input.nextDouble();
    acct.withdraw(wd);

    // Display Final Balance
    acct.displayBalance();

    input.close();
  }
}
//testing mictest
//please continue here and add suggestions