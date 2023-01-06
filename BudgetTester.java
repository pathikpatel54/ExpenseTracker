public class BudgetTester {

	public static void main(String[] args) {
		
		// Testing the constructor
		Currency amount = new Currency("USD", 100);
		String type = "Personal";
		Budget budget = new Budget(amount, type);
		
		if (budget.getAmount() == amount && budget.getType() == type) {
			System.out.println("Constructor test passed");
		} else {
			System.out.println("Constructor test failed");
		}
		
		// Testing the setters
		Currency newAmount = new Currency("USD", 200);
		String newType = "Business";
		budget.setAmount(newAmount);
		budget.setType(newType);
		
		if (budget.getAmount() == newAmount && budget.getType() == newType) {
			System.out.println("Setter test passed");
		} else {
			System.out.println("Setter test failed");
		}
	}
}