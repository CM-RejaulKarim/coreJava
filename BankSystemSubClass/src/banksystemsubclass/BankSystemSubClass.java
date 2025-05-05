package banksystemsubclass;

import banksystemsubclass.bclass.CurrentAccount;
import banksystemsubclass.bclass.SavingsAccount;

public class BankSystemSubClass {

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(.05, "2760", 5000);

        System.out.println("Saving Account Details");
        savings.accountDetails();
        savings.deposit(5000);
        savings.withdraw(2000);
        savings.accountDetails();
        
        System.out.println("==========================================");
        System.out.println("\n"
                + "Current Account Details...");
        CurrentAccount current = new CurrentAccount(500, "2760", 5000);

        current.accountDetails();
        current.deposit(500);
        current.withdraw(6000);
        current.accountDetails();
    }

}
