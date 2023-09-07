package mvc;
import javax.swing.*;

import Controller.BankController;
import Model.AccountModel;
import Views.BankView;

public class Main {
	public static void main(String[] args) {
	    AccountModel.initializeAccounts();
	    String accountNumber = JOptionPane.showInputDialog("Enter account number:");
	    String password = JOptionPane.showInputDialog("Enter password:");

	    accountNumber = accountNumber.replaceAll("-", "");  // Remove '-' if present

	    AccountModel account = AccountModel.authenticate(accountNumber, password);
	    if (account != null) {
	        // proceed to main application
	        BankView theView = new BankView();
	        BankController theController = new BankController(account, theView);
	        theView.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(null, "Incorrect account number or password.");
	    }
	}

}
