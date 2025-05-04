package banksystemsubclass.bclass;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount() {
    }

    public CurrentAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(double overdraftLimit, String accountNumber, double balance) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount > 0 && balance + overdraftLimit >= amount) {
            
            System.out.println("Withdrawn Successful.");
        }
        else{
            System.out.println("invalid Withdrawn Request.");
        }
    }

    @Override
    public void accountDetails() {
        super.accountDetails(); 
        System.out.println("OverdraftLimit "+overdraftLimit);
    }
    
    

    
}
