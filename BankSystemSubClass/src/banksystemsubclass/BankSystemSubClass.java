package banksystemsubclass;

import banksystemsubclass.bclass.SavingsAccount;

public class BankSystemSubClass {

    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount(0.15, 2760, 5000);
        
        sa.deposit();
        System.out.println("\n");
        sa.accountDetails();
    }

}
