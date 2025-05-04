package banksystemsubclass.bclass;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(double interestRate, String accountNumber, double balance) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    
    

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void accountDetails() {
        super.accountDetails(); 
        System.out.println("Interest rate"+ interestRate+"%");
    }

    

    
}
