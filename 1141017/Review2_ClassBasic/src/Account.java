public class Account {
    private String accountNumber;
    private double balance;

        public Account(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance){
            if (balance >0) {
                this.balance = balance;
            } else{
                throw new IllegalArgumentException("帳戶餘額必須為正數");
            }
        }

        public void setAccountNumber(String accountNumber){this.accountNumber = accountNumber;}

    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款餘額必須為正數");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款餘額不合法");
        }
    }


}