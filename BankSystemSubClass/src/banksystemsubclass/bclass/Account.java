package banksystemsubclass.bclass;

public class Account {

    private String accountNumber;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " Deposit Successfully.");
        }
        else{
            System.out.println("Invalid Deposit");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount+ " Withdrawn Successful.");
        }
        else{
            System.out.println("invalid Withdrawn Request.");
        }
    }

    public void accountDetails() {

        System.out.println("Account No: " + accountNumber );
        System.out.println("Balance : " + balance);
    }

}
