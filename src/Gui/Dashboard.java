package Gui;
import Internal.Account;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Dashboard extends javax.swing.JFrame {
    private final Account account;

    public Dashboard() {
        setTitle("Simple Bank Application");
        account = new Account("John Doe", 1000.00, "debit", "USD");
        setIcon();
        initComponents();
    }

    private void setIcon() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/Materials/icon.ico");
            assert inputStream != null;
            BufferedImage iconImage = ImageIO.read(inputStream);
            setIconImage(iconImage);
        } catch (IOException ex) {
            System.out.println("Error loading icon image: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JPanel jPanel2 = new JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JButton jButton3 = new javax.swing.JButton();
        javax.swing.JButton jButton4 = new javax.swing.JButton();
        javax.swing.JButton jButton5 = new javax.swing.JButton();
        javax.swing.JButton jButton6 = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(698, 367));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to your DashBoard");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Check Balance");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Withdraw Money");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Show Last transactions");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Deposite");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Transfer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jButton4)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addGap(6, 6, 6)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(6, 6, 6)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 158, 86, 63));

        jLabel3.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Materials/photo.png")))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 163, 127));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log out");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel9.setText("Azab's Bank");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        welcome Welcome = new welcome();
        Welcome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Your balance is: " + account.getBalance());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            if (!account.withdraw(amount)) {
                JOptionPane.showMessageDialog(this, "Transaction is not allowed due to low balance");
            } else {
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String inputAmount = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
        if (inputAmount != null && !inputAmount.isEmpty()) {
            double amount = Double.parseDouble(inputAmount);
            String destinationAccountNumber = JOptionPane.showInputDialog(this, "Enter destination account number:");
            if (destinationAccountNumber != null && !destinationAccountNumber.isEmpty()) {
                long destinationIban = Long.parseLong(destinationAccountNumber);
                Account destination = findAccountByIban(destinationIban); // Implement this method to find the account by IBAN
                if (account.transfer(amount, destination)) {
                    JOptionPane.showMessageDialog(this, "Transfer successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Transaction is not allowed due to low balance or invalid destination account");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid destination account number");
            }
        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            account.deposit(amount);
            JOptionPane.showMessageDialog(this, "Deposit successful!");
        }
    }
    private Account findAccountByIban(long destinationIban) {
        return new Account("Destination", 1000, "credit", "dollar");
    }


    private void jButton4ActionPerformed(ActionEvent evt) {
        LinkedList<String> transactionHistory = account.getTransactionHistory();
        StringBuilder sb = new StringBuilder("Transaction History:\n");
        for (String transaction : transactionHistory) {
            sb.append(transaction).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

}
