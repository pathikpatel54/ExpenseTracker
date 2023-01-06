import java.util.ArrayList;
import java.util.Date;

public class ReportTester {
    public static void main(String[] args) {
        Report report = new Report("USD");
        Date date = new Date();
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new OneTime("Shopping","Clothes",date,100.00,"One Time Expense"));
        transactions.add(new RecurringExpense("test", "test", 10.0, "Recurring Expense", "monthly", new Date(), new Date()));
        transactions.add(new Income("Paycheck", "Salary", date, 4000.00, "Income", "Monthly", date, date));

        ArrayList<Budget> budgets = new ArrayList<Budget>();
        budgets.add(new Budget(new Currency("USD", 2000.00), "Monthly" ));

        System.out.println(report.generateDailyReport(transactions, budgets));
        System.out.println(report.generateMonthlyReport(transactions, budgets));
    }
}