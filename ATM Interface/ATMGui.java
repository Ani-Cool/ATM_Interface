import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGui extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;

    public ATMGui(BankAccount account) {
        this.account = account;

        setTitle("ATM");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        buttonPanel.add(checkBalanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        mainPanel.add(buttonPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        amountField = new JTextField(10);
        rightPanel.add(balanceLabel);
        rightPanel.add(amountField);

        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceLabel.setText("Balance: $" + account.getBalance());
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0) {
                        account.deposit(amount);
                        balanceLabel.setText("Balance: $" + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0) {
                        if (account.withdraw(amount)) {
                            balanceLabel.setText("Balance: $" + account.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        setVisible(true);
    }
}
