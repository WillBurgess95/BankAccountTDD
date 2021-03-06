public class Account {

    private static final double DIVISION_AMOUNT = 100.0;
    private String name;
    private String secondName;
    private AccountType accountType;
    private double balance;

    public Account(String name, AccountType accountType, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account(String name, String secondName, AccountType accountType, double balance) {
        this.name = name;
        this.secondName = secondName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += depositWithInterest(amount) + amount;
    }

    private static double depositWithInterest(double amount) {
        return amount / DIVISION_AMOUNT * 1.0;
    }

    public void withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
        }
    }

    public void transfer(Account account, double amount) {
        withdraw(amount);
        account.deposit(amount);
    }

    public void addInterest() {
        double balanceDivide100 = balance / DIVISION_AMOUNT;
        if (accountType == AccountType.SAVING) {
            balance += balanceDivide100 * 5.0;
        } else if (accountType == AccountType.CASUAL) {
            balance += balanceDivide100 * 2.5;
        }
    }

    public void changeAccountType(AccountType changingAccountType) {
        accountType = changingAccountType;
    }

    public String checkNames() {
        return name + " + " + secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getSecondName() {
        return secondName;
    }


}
