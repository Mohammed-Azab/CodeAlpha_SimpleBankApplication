package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import Internal.Account;

public class BankApplicationGUI extends javax.swing.JFrame {

    private JLabel balanceLabel;
    private JLabel balanceValueLabel;
    private JButton withdrawButton, addButton, transferButton;
    private JTable transactionTable;
    private DefaultTableModel transactionTableModel;
    private Account account;

    public BankApplicationGUI() {
        initComponents();
        account = new Account("John Doe", 1000.00, "debit", "USD");
        updateBalance();
        setLocationRelativeTo(null); // Open the application in the center
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        balanceLabel = new javax.swing.JLabel();
        balanceValueLabel = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        transactionTable = new javax.swing.JTable();
        JScrollPane scrollPane = new JScrollPane(transactionTable);

        balanceLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // Bold and larger font for balance label
        balanceLabel.setText("Balance:");

        balanceValueLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // Bold and larger font for balance value

        withdrawButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("Deposit");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        transferButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        transferButton.setText("Transfer");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        transactionTableModel = new DefaultTableModel();
        transactionTableModel.addColumn("Date");
        transactionTableModel.addColumn("Transaction");
        transactionTableModel.addColumn("Amount");
        transactionTable.setModel(transactionTableModel);

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 20, 0); // Add a bottom inset to create space
        panel.add(balanceLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(balanceValueLabel, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0); // Add a top inset to create space
        panel.add(withdrawButton, gbc);
        gbc.gridy = 2;
        panel.add(addButton, gbc);
        gbc.gridy = 3;
        panel.add(transferButton, gbc);
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel("Last transactions"), gbc);
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        panel.add(scrollPane, gbc);

        getContentPane().add(panel);

        pack();
    }




    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            if (!account.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Transaction is not allowed due to low balance");
            } else {
                updateBalance();
                updateTransactionTable();
            }
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            account.deposit(amount);
            updateBalance();
            updateTransactionTable();
        }
    }

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String inputAmount = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
        if (inputAmount != null && !inputAmount.isEmpty()) {
            double amount = Double.parseDouble(inputAmount);
            String destinationAccountNumber = JOptionPane.showInputDialog(this, "Enter destination account number:");
            if (destinationAccountNumber != null && !destinationAccountNumber.isEmpty()) {
                long destinationIban = Long.parseLong(destinationAccountNumber);
                Account destination = findAccountByIban(destinationIban); // Implement this method to find the account by IBAN
                if (account.transfer(amount, destination)) {
                    updateBalance();
                    updateTransactionTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Transaction is not allowed due to low balance or invalid destination account");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid destination account number");
            }
        }
    }

    private Account findAccountByIban(long destinationIban) {
        return new Account("Destinatiomn",1000,"credit","dollar");
    }

    private void updateBalance() {
        balanceValueLabel.setText(account.getBalance() + " " + account.getCurrencySymbol()); // Use getCurrencySymbol()
    }


    private void updateTransactionTable() {
        transactionTableModel.setRowCount(0); // Clear table
        LinkedList<String> transactionHistory = account.getTransactionHistory();
        for (int i = transactionHistory.size() - 1; i >= 0; i--) {
            String transaction = transactionHistory.get(i);
            String[] parts = transaction.split(" on ");
            String transactionDate = parts[1];
            String transactionDetails = parts[0];
            double amount = Double.parseDouble(transactionDetails.split(" ")[0]);
            transactionTableModel.addRow(new Object[]{transactionDate, transactionDetails, amount});
        }
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankApplicationGUI().setVisible(true);
            }
        });
    }

}
