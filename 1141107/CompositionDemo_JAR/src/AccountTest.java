import java.util.ArrayList;   // ← 一定要加
import java.util.List;        // ← 一定要加

public class AccountTest {

    private static int customerCount;

    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>(); // 儲存客戶帳戶的清單

        Account acc1 = new Account("A001", "Alice", "A12345678", 5000);
        addCustomer(customers, acc1);

        Account acc2 = new Account("A002", "Bob", "A33334444", 3000);
        addCustomer(customers, acc2);

        Account acc3 = new Account("A003", "Charlie", "B44448888", -100);
        addCustomer(customers, acc3);

        operation(customers);
    }

    private static void addCustomer(List<Account> customers, Account account) {
        if (account != null) {
            customers.add(account);
            customerCount++;
        }
    }

    private static void operation(List<Account> customers) {
        for (Account a : customers) {
            System.out.println(a);
        }
        System.out.println("客戶總數: " + customerCount);
    }
}
