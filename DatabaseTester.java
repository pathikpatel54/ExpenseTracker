import java.util.ArrayList;
import java.util.Date;

public class DatabaseTester {
    public static void main(String[] args) {
        Database db = new Database();
        ArrayList<Transaction> transactions = db.ReadTransactions();
        ArrayList<Budget> budget = db.ReadBudget();
        //Check if the ReadTransactions method is working correctly
        if (transactions.size() > 0)
            System.out.println("ReadTransactions method is working correctly.");
        else
            System.out.println("ReadTransactions method is not working correctly.");
        //Check if the ReadBudget method is working correctly
        if (budget.size() > 0)
            System.out.println("ReadBudget method is working correctly.");
        else
            System.out.println("ReadBudget method is not working correctly.");
        //Check if the WriteTransactions method is working correctly
        transactions.add(new Transaction("Bought a car", "Transportation", new Date(), 10000.00, "expense"));
        db.WriteTransactions(transactions);
        transactions = db.ReadTransactions();
        boolean isTransactionAdded = false;
        for (Transaction t : transactions) {
            if (t.getDescription().equals("Bought a car") && t.getAmount().getAmount() == 10000.00)
                isTransactionAdded = true;
        }
        if (isTransactionAdded)
            System.out.println("WriteTransactions method is working correctly.");
        else
            System.out.println("WriteTransactions method is not working correctly.");
        //Check if the WriteBudget method is working correctly
        Budget b = new Budget(new Currency("USD", 100.00), "Monthly");
        db.WriteBudget(b);
        budget = db.ReadBudget();
        boolean isBudgetAdded = false;
        for (Budget bu : budget) {
            if (bu.getType().equals("Monthly") && bu.getAmount().getAmount() == 100.00)
                isBudgetAdded = true;
        }
        if (isBudgetAdded)
            System.out.println("WriteBudget method is working correctly.");
        else
            System.out.println("WriteBudget method is not working correctly.");
    }
}