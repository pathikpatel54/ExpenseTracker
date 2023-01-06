import java.util.Date;

public class RecurringExpense extends Expense implements Recurring {
    public String frequency;
    public Date startDate;
    public Date endDate;

    public RecurringExpense(String description, String category, Double amount, String type, String frequency, Date startDate, Date endDate) {
        super(description, category, startDate, amount, type);
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
}
