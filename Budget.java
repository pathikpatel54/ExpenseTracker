import java.io.Serializable;

public class Budget implements Serializable {
	private Currency amount;
	private String type;

	public Budget(Currency amount, String type) {
		this.amount = amount;
		this.type = type;
	}

	public Currency getAmount() {
		return amount;
	}
	
	public void setAmount(Currency amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}