public class Account {
    private String accountNumber;
    private double balance;

        public Account(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public Account(){
            this(accountNumber: "000000", initialBalance: 0.0)
        }
    public Account(String accountNumber) {
        this(accountNumber, initialBalance: 0.0)
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
        Scanner scanner = new Scanner(System.in);
        double validAmount = amount;
        if (!(amount > 0)){
            validAmount = getValidAmount(scanner, promot: "請輸入金額:", Double: x -> x >0, errorMsg: "存款金額須為正數");
        }
        balance += validAmount;
    }
    public void deposit(double amounts, String currency){
        double exchangeRate = 1.0;
        switch (currency.toUpperCase()){
            case "USD":
                exchangeRate = 38.0;
                break;
            case "EUR":
                exchangeRate = 35.0;
                break;
            case "JPY":
                exchangeRate = 0.25;
                break;
            default:
                System.out.println("不支援的貨幣，請採用TWD，USD，EUR 或 JPY")
        }
        double amountInTWD = amounts * exchangeRate;
        this.deposit(amountInTWD);
    }

    public void deposit(double ... amounts){
        double total = 0
        for (double amount : amounts){
            total += amount;
        }
        this.deposit(total);
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款餘額不合法");
        }
    }


}