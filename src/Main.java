class BankAccount {
  // Attributes
  String accountNumber;
  String accountName;
  double balance;

  // Method to deposit money
  void deposit(double amount) {
    balance += amount;
    System.out.println("Deposited: " + amount);
  }

  // Method to withdraw money
  void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      System.out.println("Withdrawn: " + amount);
    } else {
      System.out.println("Insufficient balance.");
    }
  }

  // Method to display balance
  void displayBalance() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Name: " + accountName);
    System.out.println("Current Balance: " + balance);
  }
}

// Main class to test
public class Main {
  public static void main(String[] args) {
    BankAccount acct = new BankAccount();

    acct.accountNumber = "001";
    acct.accountName = "Juan Dela Cruz";
    acct.balance = 1000.0;

    acct.deposit(500.0);
    acct.deposit(250.0);
    acct.withdraw(300.0);

    acct.displayBalance();
  }
}
//testing mictest
//please continue here and add suggestions
