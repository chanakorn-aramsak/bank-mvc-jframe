package Controller;
import Model.AccountModel;
import Views.BankView;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.event.*;

public class BankController {
	private AccountModel account;
    private BankView view;

    public BankController(AccountModel account, BankView view) {
        this.account = account;
        this.view = view;

        this.view.getDepositButton().addActionListener(new DepositListener());
        this.view.getWithdrawButton().addActionListener(new WithdrawListener());
        this.view.getTransferButton().addActionListener(new TransferListener());
        this.view.getCheckBalanceButton().addActionListener(new CheckBalanceListener());
    }

    class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog("Enter amount to deposit:");
            double amount = Double.parseDouble(input);

            int result = account.deposit(amount);
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Deposited: " + amount + " New balance: " + account.getBalance());
            } else if (result == 1) {
                JOptionPane.showMessageDialog(null, "Minimum deposit amount is 100 Baht.");
            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Invalid deposit amount. Only 1,000, 500, and 100 Baht notes are allowed.");
            }
        }
    }

    class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog("Enter amount to withdraw:");
            double amount = Double.parseDouble(input);

            int result = account.withdraw(amount);
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Withdrew: " + amount + " New balance: " + account.getBalance());
            } else if (result == 1) {
                JOptionPane.showMessageDialog(null, "Withdraw amount exceeds your current balance.");
            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Maximum withdraw limit is 20,000 Baht.");
            } else if (result == 3) {
                JOptionPane.showMessageDialog(null, "Invalid withdraw amount. Only 1,000, 500, and 100 Baht notes are allowed.");
            }
        }
    }


    class TransferListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amountStr = JOptionPane.showInputDialog("Enter amount to transfer:");
            double amount = Double.parseDouble(amountStr);
            String toAccountNumber = JOptionPane.showInputDialog("Enter account number to transfer to:");

            if (account.transfer(amount, toAccountNumber)) {
                JOptionPane.showMessageDialog(null, "Transferred: " + amount + " New balance: " + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Transfer failed. Insufficient balance, or invalid account number, or amount greater than 1,000,000.");
            }
        }
    }

    class CheckBalanceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Current balance: " + account.getBalance());
        }
    }
}
