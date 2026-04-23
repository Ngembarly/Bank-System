import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankSystemGUI extends JFrame implements ActionListener {

    // Bank Data
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Components
    private JTextField accNumField, accHolderField, balanceField, amountField;
    private JTextArea outputArea;
    private JButton createButton, depositButton, withdrawButton, displayButton, exitButton;

    public BankSystemGUI() {

        // Window Setup
        setTitle("Javawockeez Bank System");
        setSize(700, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Fonts
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 15);
        Font btnFont = new Font("Arial", Font.BOLD, 14);

        // Title
        JLabel titleLabel = new JLabel("Javawockeez Bank System");
        titleLabel.setBounds(170, 20, 400, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 51, 102));
        add(titleLabel);

        // ===== ACCOUNT CREATION SECTION =====

        JLabel accNumLabel = new JLabel("Account Number:");
        accNumLabel.setBounds(40, 90, 160, 30);
        accNumLabel.setFont(labelFont);
        add(accNumLabel);

        accNumField = new JTextField();
        accNumField.setBounds(220, 90, 220, 30);
        accNumField.setFont(fieldFont);
        add(accNumField);

        JLabel accHolderLabel = new JLabel("Account Holder:");
        accHolderLabel.setBounds(40, 140, 160, 30);
        accHolderLabel.setFont(labelFont);
        add(accHolderLabel);

        accHolderField = new JTextField();
        accHolderField.setBounds(220, 140, 220, 30);
        accHolderField.setFont(fieldFont);
        add(accHolderField);

        JLabel balanceLabel = new JLabel("Starting Balance:");
        balanceLabel.setBounds(40, 190, 160, 30);
        balanceLabel.setFont(labelFont);
        add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(220, 190, 220, 30);
        balanceField.setFont(fieldFont);
        add(balanceField);

        // Create Account Button BELOW Starting Balance
        createButton = new JButton("Create Account");
        createButton.setBounds(250, 240, 180, 35);
        createButton.setFont(btnFont);
        add(createButton);

        // Separator Line
        JSeparator separator = new JSeparator();
        separator.setBounds(40, 300, 620, 10);
        add(separator);

        // ===== TRANSACTION SECTION =====

        JLabel amountLabel = new JLabel("Transaction Amount:");
        amountLabel.setBounds(40, 330, 180, 30);
        amountLabel.setFont(labelFont);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(220, 330, 220, 30);
        amountField.setFont(fieldFont);
        add(amountField);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(80, 390, 140, 35);
        depositButton.setFont(btnFont);
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(260, 390, 140, 35);
        withdrawButton.setFont(btnFont);
        add(withdrawButton);

        displayButton = new JButton("Display Details");
        displayButton.setBounds(440, 390, 160, 35);
        displayButton.setFont(btnFont);
        add(displayButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(40, 450, 620, 130);
        add(scrollPane);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(290, 600, 120, 35);
        exitButton.setFont(btnFont);
        add(exitButton);

        // Events
        createButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        displayButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            outputArea.append("Deposit Successful: ₱" + amount + "\n");
        } else {
            outputArea.append("Invalid Deposit Amount.\n");
        }
    }
    public void withdraw(double amount) {

    if (amount <= 0) {
        outputArea.append("Invalid Withdrawal Amount.\n\n");
    }

    else if (balance <= 0) {
        outputArea.append("Transaction Failed: No Balance Available.\n\n");
    }

    else if (amount > balance) {
        outputArea.append("Transaction Failed: Insufficient Balance.\n");
        outputArea.append("Current Balance: ₱" + balance + "\n\n");
    }

    else {
        balance -= amount;

        outputArea.append("Withdrawal Successful: ₱" + amount + "\n");
        outputArea.append("Remaining Balance: ₱" + balance + "\n\n");
    }
    }

    public void displayDetails() {
        outputArea.append("\n===============================\n");
        outputArea.append("BANK ACCOUNT INFO\n");
        outputArea.append("===============================\n");
        outputArea.append("Account Number    : " + accountNumber + "\n");
        outputArea.append("Account Holder    : " + accountHolder + "\n");
        outputArea.append("Remaining Balance : ₱" + balance + "\n");
        outputArea.append("===============================\n\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == createButton) {
                accountNumber = accNumField.getText();
                accountHolder = accHolderField.getText();
                balance = Double.parseDouble(balanceField.getText());
                outputArea.append("Account Created Successfully!\n");
            }

            if (e.getSource() == depositButton) {
                deposit(Double.parseDouble(amountField.getText()));
            }

            if (e.getSource() == withdrawButton) {
                withdraw(Double.parseDouble(amountField.getText()));
            }

            if (e.getSource() == displayButton) {
                displayDetails();
            }

            if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(this, "Thank you for banking with us!");
                System.exit(0);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid input.");
        }
    }

    public static void main(String[] args) {
        new BankSystemGUI();
    }
}