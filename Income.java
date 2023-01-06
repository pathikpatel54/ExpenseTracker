import java.util.Date;

public class Income extends Transaction implements Recurring {

    private String frequency;
    private Date startDate;
    private Date endDate;

    public Income(String description, String category, Date date, Double amount, String type, String frequency, Date startDate, Date endDate) {
        super(description, category, date, amount, type);
        this.frequency = frequency;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    @Override
    public String getFrequency() {
        return frequency;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }
    
}
