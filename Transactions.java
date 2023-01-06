import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Transactions {
    private SimpleDateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
    private ArrayList<Transaction> transactions;
    Database database = new Database();
    
    public Transactions() {
        this.transactions = database.ReadTransactions();
    }
    
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
    
    public ArrayList<Transaction> addTransaction(Transaction t) {
        this.transactions.add(t);
        database.WriteTransactions(transactions);
        return this.transactions;
    }
    
    public Transaction removeTransaction(String transactionName) {
        for (Transaction t : this.transactions) {
            if (t.getDescription().equals(transactionName)) {
                this.transactions.remove(t);
                database.WriteTransactions(transactions);
                return t;
            }
        }
        return new Transaction();
    }
    
    public ArrayList<Transaction> filterTransaction(String category) {
        ArrayList<Transaction> filtered = new ArrayList<Transaction>();
        for (Transaction t : this.transactions) {
            if (t.getCategory().equals(category)) {
                filtered.add(t);
            }
        }
        return filtered;
    }
    
    @Override
    public String toString() {
        String returnString = new String();
        returnString = returnString + String.format("\n%1s %-40s %3s %-15s %5s %15s %3s %-15s %1s", "|", "Description", "|", "Category", "|", "Amount($)", "|", "Date", "|");
        returnString = returnString + "\n----------------------------------------------------------------------------------------------------------\n";
        
        for(Transaction transaction: this.transactions) {
                String dateString = outputFormatter.format(transaction.getDate());
                returnString = returnString + String.format("%1s %-40s %3s %-15s %5s %15.2f %3s %-15s %1s\n", "|", transaction.getDescription(), "|", transaction.getCategory(), "|", transaction.getAmount().getAmount(), "|", dateString, "|");
        }
        return returnString;
    }
    
}