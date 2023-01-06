import java.util.Date;

public class TransactionTester {
    public static void main(String[] args) {
        // Test creating a Transaction
        Date date = new Date();
        Transaction t1 = new Transaction("Grocery shopping", "Food", date, 50.00, "Expense");
        System.out.println("Created transaction: " + t1.toString());

        // Test accessing and changing data
        System.out.println("Description: " + t1.getDescription());
        System.out.println("Category: " + t1.getCategory());
        System.out.println("Date: " + t1.getDate());
        System.out.println("Amount: " + t1.getAmount());
        System.out.println("Type: " + t1.getType());
        
        t1.setType("Income");
        System.out.println("Type changed to: " + t1.getType());
    }
}