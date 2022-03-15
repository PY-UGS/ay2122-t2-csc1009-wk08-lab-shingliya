public class CheckingAccount {
    private double balance;
    private int accountNo;

    CheckingAccount(int accountNo) {
        balance = 0.;
        this.accountNo = accountNo;
    }

    public void deposit(double amt) {
        if(amt <= 0)
            throw new IllegalArgumentException();
        balance += amt;
    }

    public void withdraw(double amt) throws InsufficientFundsException {
        if(amt <= 0)
            throw new IllegalArgumentException();
        else if(amt > balance)
            throw new InsufficientFundsException(amt - balance);
        balance -= amt;
    }

    public double getBalance() {
        return balance;
    }
    public int getNumber() {
        return accountNo;
    }
}
