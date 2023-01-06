import java.util.Date;

public class RecurringExpenseTester {

    public static void main(String[] args) {

        // Test 1: Test the getFrequency() method
        RecurringExpense testExpense = new RecurringExpense("test", "test", 10.0, "test", "monthly", new Date(), new Date());
        String expectedFrequency = "monthly";
        String actualFrequency = testExpense.getFrequency();
        if (expectedFrequency.equals(actualFrequency)) {
            System.out.println("Test 1 passed!");
        } else {
            System.out.println("Test 1 failed!");
        }

        // Test 2: Test the getStartDate() method
        Date expectedStartDate = new Date();
        Date actualStartDate = testExpense.getStartDate();
        if (expectedStartDate.equals(actualStartDate)) {
            System.out.println("Test 2 failed!");
        } else {
            System.out.println("Test 2 passed!");
        }

        // Test 3: Test the getEndDate() method
        Date expectedEndDate = new Date();
        Date actualEndDate = testExpense.getEndDate();
        if (expectedEndDate.equals(actualEndDate)) {
            System.out.println("Test 3 failed!");
        } else {
            System.out.println("Test 3 passed!");
        }
    }
}