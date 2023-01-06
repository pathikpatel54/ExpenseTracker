import java.util.Date;

public class Expense extends Transaction{
    public Expense(String description, String category, Date expDate, double expense, String type) {
        super(description, category, expDate, expense, type);
    }
}
