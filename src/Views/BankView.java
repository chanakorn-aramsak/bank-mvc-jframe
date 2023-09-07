package Views;

import javax.swing.*;
import java.awt.*;

public class BankView extends JFrame {
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton checkBalanceButton;

    public BankView() {
        setTitle("Bank App");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");
        checkBalanceButton = new JButton("Check Balance");

        add(depositButton);
        add(withdrawButton);
        add(transferButton);
        add(checkBalanceButton);
    }

    public JButton getDepositButton() {
        return depositButton;
    }

    public JButton getWithdrawButton() {
        return withdrawButton;
    }

    public JButton getTransferButton() {
        return transferButton;
    }

    public JButton getCheckBalanceButton() {
        return checkBalanceButton;
    }
}
