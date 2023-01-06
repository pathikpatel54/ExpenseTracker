import java.io.Serializable;

class Currency implements Serializable {
	private String currency;
	private double amount;
	
	public Currency(String currency, double amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Currency convertCurrency(String currency) {
		if(this.currency.equals("USD")) {
			switch(currency) {
				case "INR":
					return new Currency("INR", this.amount * 81.421254);
	
				case "GBP":
					return new Currency("GBP", this.amount * 0.814353);
	
				case "EUR":
					return new Currency("EUR", this.amount * 0.949047);
	
				case "AUD":
					return new Currency("AUD", this.amount * 1.471493);
	
				case "CAD":
					return new Currency("CAD", this.amount * 1.349368);
	
				case "SGD":
					return new Currency("SGD", this.amount * 1.352252);
	
				case "CHF":
					return new Currency("CHF", this.amount * 0.935940);
	
				case "MYR":
					return new Currency("MYR", this.amount * 4.386993);
	
				case "JNY":
					return new Currency("JNY", this.amount * 134.311152);
				default:
					return this;
			}
		}
		return this;
   }
}