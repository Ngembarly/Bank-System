import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame implements ActionListener {

    // Private attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Components
    JTextField txtAccNum, txtAccHolder, txtAmount, txtStartBalance;
    JTextArea area;

    JButton btnCreate, btnDeposit, btnWithdraw, btnDetails, btnClear;

    // Constructor for GUI
    public BankAccountGUI() {

        setTitle("JAVAWOCKEEZ BANK SYSTEM");
        setSize(550, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("WELCOME TO JAVAWOCKEEZ BANK");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(70, 10, 420, 30);
        add(title);

        // Account Number
        JLabel lbl1 = new JLabel("Account Number:");
        lbl1.setBounds(30, 60, 130, 25);
        add(lbl1);

        txtAccNum = new JTextField();
        txtAccNum.setBounds(180, 60, 250, 25);
        add(txtAccNum);

        // Account Holder
        JLabel lbl2 = new JLabel("Account Holder:");
        lbl2.setBounds(30, 95, 130, 25);
        add(lbl2);

        txtAccHolder = new JTextField();
        txtAccHolder.setBounds(180, 95, 250, 25);
        add(txtAccHolder);

        // Starting Balance
        JLabel lbl3 = new JLabel("Starting Balance:");
        lbl3.setBounds(30, 130, 130, 25);
        add(lbl3);

        txtStartBalance = new JTextField();
        txtStartBalance.setBounds(180, 130, 250, 25);
        add(txtStartBalance);

        // Amount
        JLabel lbl4 = new JLabel("Transaction Amount:");
        lbl4.setBounds(30, 165, 140, 25);
        add(lbl4);

        txtAmount = new JTextField();
        txtAmount.setBounds(180, 165, 250, 25);
        add(txtAmount);

        // Buttons
        btnCreate = new JButton("Create Account");
        btnCreate.setBounds(170, 210, 160, 30);
        add(btnCreate);

        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(30, 260, 110, 30);
        add(btnDeposit);

        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(150, 260, 110, 30);
        add(btnWithdraw);

        btnDetails = new JButton("Account Info");
        btnDetails.setBounds(270, 260, 130, 30);
        add(btnDetails);

        btnClear = new JButton("Clear");
        btnClear.setBounds(410, 260, 80, 30);
        add(btnClear);

        // Text Area
        area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 320, 460, 220);
        add(scroll);

        // Actions
        btnCreate.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnDetails.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    // Constructor for Bank Account Object
    public BankAccountGUI(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            area.append("Deposit successful: ₱" + amount + "\n");
            area.append("Updated Balance: ₱" + balance + "\n\n");
        } else {
            area.append("Invalid deposit amount.\n\n");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= 0) {
            area.append("Invalid withdrawal amount.\n\n");
        } else if (amount > balance) {
            area.append("Transaction failed: Insufficient balance.\n\n");
        } else {
            balance -= amount;
            area.append("Withdrawal successful: ₱" + amount + "\n");
            area.append("Updated Balance: ₱" + balance + "\n\n");
        }
    }

    // Display Details Method
    public void displayAccountDetails() {
        area.append("================================\n");
        area.append("       BANK ACCOUNT INFO\n");
        area.append("================================\n");
        area.append("Account Number : " + accountNumber + "\n");
        area.append("Account Holder : " + accountHolder + "\n");
        area.append("Remaining Balance : ₱" + balance + "\n");
        area.append("================================\n\n");
    }

    // Button Actions
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCreate) {
            try {
                accountNumber = txtAccNum.getText();
                accountHolder = txtAccHolder.getText();
                balance = Double.parseDouble(txtStartBalance.getText());

                area.setText("");
                area.append("Account created successfully!\n");
                area.append("Welcome, " + accountHolder + "\n\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid inputs.");
            }
        }

        if (e.getSource() == btnDeposit) {
            try {
                double amount = Double.parseDouble(txtAmount.getText());
                deposit(amount);
                txtAmount.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid amount.");
            }
        }

        if (e.getSource() == btnWithdraw) {
            try {
                double amount = Double.parseDouble(txtAmount.getText());
                withdraw(amount);
                txtAmount.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid amount.");
            }
        }

        if (e.getSource() == btnDetails) {
            displayAccountDetails();
        }

        if (e.getSource() == btnClear) {
            txtAccNum.setText("");
            txtAccHolder.setText("");
            txtStartBalance.setText("");
            txtAmount.setText("");
            area.setText("");
        }
    }

    public static void main(String[] args) {
        new BankAccountGUI();
    }
}