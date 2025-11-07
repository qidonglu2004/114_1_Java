public class Account {
    private String accountNumber;
    private String ownerName;
    private String ownerID;
    private double balance;

    public Account(String accountNumber, String ownerName, String ownerID, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.ownerID = ownerID;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須大於 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額不合法或餘額不足");
        }
    }

    @Override
    public String toString() {
        return String.format("帳號: %s, 戶名: %s, ID: %s, 餘額: %.2f",
                accountNumber, ownerName, ownerID, balance);
    }
}
