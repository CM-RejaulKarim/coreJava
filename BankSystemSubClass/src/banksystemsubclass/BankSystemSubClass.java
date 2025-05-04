package banksystemsubclass;

import banksystemsubclass.bclass.CurrentAccount;
import banksystemsubclass.bclass.SavingsAccount;

public class BankSystemSubClass {

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount();
        
        savings.setAccountNumber("2760");
        savings.setBalance(5000);
        savings.setInterestRate(15);
        
        savings.deposit(6500);
        
        System.out.println("\n");
        savings.accountDetails();
        System.out.println("\n");
        
        CurrentAccount current = new CurrentAccount(500, "2760", 5500);
        
        
        current.withdraw(6000);
        
        current.accountDetails();
    }

}
