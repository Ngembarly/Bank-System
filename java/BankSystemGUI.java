import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankSystemGUI extends JFrame implements ActionListener {

    // Private attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // GUI Components
    private JTextField accNumField, accHolderField, balanceField, amountField;
    private JTextArea outputArea;
    private JButton createButton, depositButton, withdrawButton, displayButton, exitButton;

    // Constructor for Bank Account
    public BankSystemGUI(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Empty constructor for GUI setup
    public BankSystemGUI() {
        setTitle("Javawockeez Bank System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Labels and text fields
        add(new JLabel("Account Number:"));
        accNumField = new JTextField(20);
        add(accNumField);

        add(new JLabel("Account Holder:"));
        accHolderField = new JTextField(20);
        add(accHolderField);

        add(new JLabel("Starting Balance:"));
        balanceField = new JTextField(20);
        add(balanceField);

        add(new JLabel("Transaction Amount:"));
        amountField = new JTextField(20);
        add(amountField);

        // Buttons
        createButton = new JButton("Create Account");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        displayButton = new JButton("Display Details");
        exitButton = new JButton("Exit");

        add(createButton);
        add(depositButton);
        add(withdrawButton);
        add(displayButton);
        add(exitButton);

        // Text area for output
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Button actions
        createButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        displayButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            outputArea.append("\nDeposit successful: ₱" + amount);
            outputArea.append("\nUpdated Balance: ₱" + balance + "\n");
        } else {
            outputArea.append("\nInvalid deposit amount.\n");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            outputArea.append("\nInvalid withdrawal amount.\n");
        } else if (amount > balance) {
            outputArea.append("\nTransaction failed: Insufficient balance.\n");
        } else {
            balance -= amount;
            outputArea.append("\nWithdrawal successful: ₱" + amount);
            outputArea.append("\nUpdated Balance: ₱" + balance + "\n");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        outputArea.append("\n================================");
        outputArea.append("\n        BANK ACCOUNT INFO");
        outputArea.append("\n================================");
        outputArea.append("\nAccount Number    : " + accountNumber);
        outputArea.append("\nAccount Holder    : " + accountHolder);
        outputArea.append("\nRemaining Balance : ₱" + balance);
        outputArea.append("\n================================\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == createButton) {
                String accNum = accNumField.getText();
                String accHolder = accHolderField.getText();
                double startingBalance = Double.parseDouble(balanceField.getText());

                accountNumber = accNum;
                accountHolder = accHolder;
                balance = startingBalance;

                outputArea.append("Account created successfully!\n");
            }

            else if (e.getSource() == depositButton) {
                double amount = Double.parseDouble(amountField.getText());
                deposit(amount);
            }

            else if (e.getSource() == withdrawButton) {
                double amount = Double.parseDouble(amountField.getText());
                withdraw(amount);
            }

            else if (e.getSource() == displayButton) {
                displayAccountDetails();
            }

            else if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(this, "Thank you for banking with us!");
                System.exit(0);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric input.");
        }
    }

    public static void main(String[] args) {
        new BankSystemGUI();
    }
}