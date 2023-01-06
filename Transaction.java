import java.io.Serializable;
import java.util.Date;

class Transaction implements Serializable {
    private String description;
    private String category;
    private Date date;
    private Currency amount;
    private String type;

    public Transaction() {};

    public Transaction(String description, String category, Date expDate, double amount, String type) {
        this.description = description;
        this.category = category;
        this.date = expDate;
        this.amount = new Currency("USD", amount);
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    public Currency getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}