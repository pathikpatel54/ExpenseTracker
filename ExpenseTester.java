import java.util.Date;

public class ExpenseTester {
    public static void main(String[] args) {
        
        //Testing the constructor
        Date date = new Date();
        Expense expense = new Expense("Groceries","Food",date,100.00,"Debit");
        
        //Testing the getDescription method
        String description = expense.getDescription();
        if(description.equals("Groceries")) {
           System.out.println("getDescription test passed!");
        } else {
           System.out.println("getDescription test failed!");
        }
        
        //Testing the getCategory method
        String category = expense.getCategory();
        if(category.equals("Food")) {
           System.out.println("getCategory test passed!");
        } else {
           System.out.println("getCategory test failed!");
        }
        
        //Testing the getDate method
        Date dateResult = expense.getDate();
        if(dateResult.equals(date)) {
           System.out.println("getDate test passed!");
        } else {
           System.out.println("getDate test failed!");
        }
        
        //Testing the getExpense method
        double expenseResult = expense.getAmount().getAmount();
        if(expenseResult == 100.00) {
           System.out.println("getExpense test passed!");
        } else {
           System.out.println("getExpense test failed!");
        }
        
        //Testing the getType method
        String type = expense.getType();
        if(type.equals("Debit")) {
           System.out.println("getType test passed!");
        } else {
           System.out.println("getType test failed!");
        }
    }
}