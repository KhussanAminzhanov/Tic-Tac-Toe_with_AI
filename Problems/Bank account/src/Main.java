class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }
}

class CheckingAccount extends BankAccount {

    protected double fee;

    public CheckingAccount(String number, Long balance, double fee) {
        super(number, balance);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }
}

class SavingAccount extends BankAccount {

    protected double interestRate;

    public SavingAccount(String number, Long balance, double interestRate) {
        super(number, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("01", 1000L);
        CheckingAccount checkingAccount = new CheckingAccount("02", 2000L, 0.08);
        SavingAccount savingAccount = new SavingAccount("03", 3000L, 0.13);
        System.out.println("BankAccount balance: " + bankAccount.getBalance());
        System.out.println("CheckingAccount balance: " + checkingAccount.getBalance());
        System.out.println("SavingAccount balance: " + savingAccount.getBalance());
    }
}
