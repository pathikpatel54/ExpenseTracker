import java.util.Date;

interface Recurring {
    public String getFrequency();
    public Date getStartDate();
    public Date getEndDate();
}