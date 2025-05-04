package banksystemsubclass.bclass;

public class Account {

    private int accountNumber;
    private int balance;

    public Account() {
    }

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
    
    public void deposit(){
    System.out.println("Account No: "+ accountNumber +"Previous Balance : "+ balance);
    }
    
    public void withdraw(){
    System.out.println("Account No: "+ accountNumber +"Previous Balance : "+ balance);
    }
    
    public void accountDetails(){
        
        System.out.println("Account No: "+ accountNumber +"Balance : "+ balance);
    }
    
    
}
