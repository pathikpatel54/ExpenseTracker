import java.util.ArrayList;
import java.util.Date;

public class TransactionsTester {
    public static void main(String[] args) {
        Transactions transactions = new Transactions();
        Transaction t1 = new Transaction("Bought a car", "Transportation", new Date(), 10000, "expense");
        Transaction t2 = new Transaction("Grocery Shopping", "Food", new Date(), 100, "expense");
        Transaction t3 = new Transaction("Paycheck", "Income", new Date(), 5000, "income");
        
        // Test addTransaction()
        transactions.addTransaction(t1);
        transactions.addTransaction(t2);
        transactions.addTransaction(t3);
        System.out.println(transactions.toString());
        
        // Test removeTransaction()
        Transaction removedTransaction = transactions.removeTransaction("Grocery Shopping");
        System.out.println("Removed Transaction: " + removedTransaction.toString());
        System.out.println(transactions.toString());
        
        // Test filterTransaction()
        ArrayList<Transaction> filteredTransactions = transactions.filterTransaction("Transportation");
        System.out.println("Filtered Transactions: " + filteredTransactions.toString());
    }
}