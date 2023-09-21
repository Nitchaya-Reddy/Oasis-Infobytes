import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

public class ATMInterfaceGUI extends JFrame {
    private JPasswordField pinPasswordField;
    private JLabel statusLabel;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton transferButton;
    private JButton quitButton;
    private List<String> transactionHistory;

    public ATMInterfaceGUI() {
        setTitle("ATM Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        pinPasswordField = new JPasswordField(10);
        add(pinPasswordField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawButtonListener());
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositButtonListener());
        add(depositButton);

        transferButton = new JButton("Transfer");
        transferButton.addActionListener(new TransferButtonListener());
        add(transferButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(new QuitButtonListener());
        add(quitButton);

        statusLabel = new JLabel("Enter PIN");
        add(statusLabel);

        transactionHistory = new ArrayList<>();

        setVisible(true);
    }

    private class WithdrawButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] pinChars = pinPasswordField.getPassword();
            String pin = new String(pinChars);
            // Perform withdrawal logic here based on the entered PIN
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
            // Perform withdrawal logic here based on the entered PIN and amount
            transactionHistory.add("Withdrawal: $" + amount);
            statusLabel.setText("Withdrawal successful!");
            clearPasswordField();
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] pinChars = pinPasswordField.getPassword();
            String pin = new String(pinChars);
            // Perform deposit logic here based on the entered PIN
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
            // Perform deposit logic here based on the entered PIN and amount
            transactionHistory.add("Deposit: $" + amount);
            statusLabel.setText("Deposit successful!");
            clearPasswordField();
        }
    }

    private class TransferButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] pinChars = pinPasswordField.getPassword();
            String pin = new String(pinChars);
            // Perform transfer logic here based on the entered PIN
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter transfer amount:"));
            String recipient = JOptionPane.showInputDialog("Enter recipient's account number:");
            // Perform transfer logic here based on the entered PIN, amount, and recipient
            transactionHistory.add("Transfer: $" + amount + " to " + recipient);
            statusLabel.setText("Transfer successful!");
            clearPasswordField();
        }
    }

    private class QuitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display transaction history
            StringBuilder history = new StringBuilder("Transaction History:\n");
            for (String transaction : transactionHistory) {
                history.append(transaction).append("\n");
            }
            JOptionPane.showMessageDialog(null, history.toString());

            // Quit the application
            System.exit(0);
        }
    }

    private void clearPasswordField() {
        pinPasswordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMInterfaceGUI::new);
    }
}
