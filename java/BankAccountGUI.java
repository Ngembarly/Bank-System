import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame implements ActionListener {

    String accountNumber = "";
    String accountName = "";
    double balance = 0;

    JTextField txtAccNum, txtAccName, txtAmount;
    JTextArea area;

    JButton btnCreate, btnDeposit, btnWithdraw, btnBalance, btnClear;

    public BankAccountGUI() {

        setTitle("Simple Bank System");
        setSize(520, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("SIMPLE BANKING SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(90, 10, 350, 30);
        add(title);

        // Account Number
        JLabel lblAccNum = new JLabel("Account Number:");
        lblAccNum.setBounds(30, 60, 120, 25);
        add(lblAccNum);

        txtAccNum = new JTextField();
        txtAccNum.setBounds(160, 60, 250, 25);
        add(txtAccNum);

        // Account Name
        JLabel lblAccName = new JLabel("Account Name:");
        lblAccName.setBounds(30, 95, 120, 25);
        add(lblAccName);

        txtAccName = new JTextField();
        txtAccName.setBounds(160, 95, 250, 25);
        add(txtAccName);

        // Amount
        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(30, 130, 120, 25);
        add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(160, 130, 250, 25);
        add(txtAmount);

        // Create Button (separate row)
        btnCreate = new JButton("Create Account");
        btnCreate.setBounds(160, 170, 160, 30);
        add(btnCreate);

        // Transaction Buttons
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(30, 220, 110, 30);
        add(btnDeposit);

        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(150, 220, 110, 30);
        add(btnWithdraw);

        btnBalance = new JButton("Check Balance");
        btnBalance.setBounds(270, 220, 130, 30);
        add(btnBalance);

        btnClear = new JButton("Clear");
        btnClear.setBounds(410, 220, 80, 30);
        add(btnClear);

        // Output Area
        area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 270, 460, 250);
        add(scroll);

        // Actions
        btnCreate.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnBalance.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    public void deposit(double amount) {
        balance += amount;
        area.append("Deposited: ₱" + amount + "\n");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            area.append("Withdrawn: ₱" + amount + "\n");
        } else {
            area.append("Insufficient Balance!\n");
        }
    }

    public void displayBalance() {
        area.append("\n===== ACCOUNT SUMMARY =====\n");
        area.append("Account Number: " + accountNumber + "\n");
        area.append("Account Name: " + accountName + "\n");
        area.append("Current Balance: ₱" + balance + "\n\n");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCreate) {

            accountNumber = txtAccNum.getText();
            accountName = txtAccName.getText();
            balance = 0;

            area.setText("");
            area.append("Account Created Successfully!\n");
            area.append("Account Number: " + accountNumber + "\n");
            area.append("Account Name: " + accountName + "\n");
            area.append("Balance: ₱0.0\n\n");
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

        if (e.getSource() == btnBalance) {
            displayBalance();
        }

        if (e.getSource() == btnClear) {
            txtAmount.setText("");
            area.setText("");
        }
    }

    public static void main(String[] args) {
        new BankAccountGUI();
    }
}