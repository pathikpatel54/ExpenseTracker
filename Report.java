import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Report {
    private String currency;
    private double total;
    private SimpleDateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");

    public Report(String currency) {
        this.currency = currency;
        this.total = 0;
    }

    public String generateDailyReport(ArrayList<Transaction> transactions, ArrayList<Budget> budgets) {
        String returnString = new String();
        double dailyBudget = 0;
        for(Budget budget: budgets) { if(budget.getType().equals("Daily")) dailyBudget = budget.getAmount().convertCurrency(currency).getAmount();}     
        returnString = returnString + String.format("\n%1s %-40s %5s %10s %3s %-10s %1s", "|", "Description", "|", "Amount("+currency+")", "|", "Date", "|");
        returnString = returnString + "\n----------------------------------------------------------------------------\n";
        
        for(Transaction transaction: transactions) {
            String dateString1 = outputFormatter.format(transaction.getDate());
            String dateString2 = outputFormatter.format(new Date());
            if((dateString1.equals(dateString2)) && transaction.getType().equals("One Time Expense")) {
                returnString = returnString + String.format("%1s %-40s %5s %10.2f %3s %-10s %1s\n", "|", transaction.getDescription(), "|", transaction.getAmount().convertCurrency(currency).getAmount(), "|", dateString1, "|");
                total += transaction.getAmount().convertCurrency(currency).getAmount();
            }
        }
        returnString = returnString + String.format("\n\nTotal Expense for Today: %.2f", total);
        returnString = returnString + String.format("\nBudget for Today: %.2f\n", dailyBudget);
        return returnString;
    }

    public String generateMonthlyReport(ArrayList<Transaction> transactions, ArrayList<Budget> budgets) {
        double total = 0;
        double income = 0;
        double monthlyBudget = 0;
        String returnString = new String();

        for(Budget budget: budgets) { if(budget.getType().equals("Monthly")) monthlyBudget = budget.getAmount().convertCurrency(currency).getAmount();}     
        
        returnString = returnString + (String.format("\n%1s %-40s %5s %-36s %5s %10s %3s %-10s %1s", "|", "Description", "|", "Frequency", "|", "Amount("+currency+")", "|", "Date", "|"));
        returnString = returnString + ("\n-----------------------------------------------------------------------------------------------------------------------\n");
        
        for(Transaction transaction: transactions) {
            String dateString = outputFormatter.format(transaction.getDate());
            String month1 = dateString.split("/")[0];
            String month2 = outputFormatter.format(new Date()).split("/")[0];
            boolean dateCompare;
            Date startDate, endDate, currentDate;
            if(transaction.getClass().getName().equals("RecurringExpense") || transaction.getClass().getName().equals("Income")) {    
                    startDate = ((Recurring)transaction).getStartDate();
                    endDate = ((Recurring)transaction).getEndDate();
                    currentDate = new Date();
                    dateCompare = currentDate.after(startDate) && currentDate.before(endDate);
                if(dateCompare) {
                    returnString = returnString + (String.format("%1s %-40s %5s %-10s %-25s %5s %10.2f %3s %-10s %1s\n", "|", transaction.getDescription(), "|", ((Recurring)transaction).getFrequency(), "(" + outputFormatter.format(startDate) + " - " + outputFormatter.format(endDate) + ")" ,  "|", transaction.getAmount().convertCurrency(currency).getAmount(), "|", dateString, "|"));
                    if(transaction.getClass().getName().equals("Income")) {
                        income += transaction.getAmount().convertCurrency(currency).getAmount();
                    } else {
                        switch(((Recurring)transaction).getFrequency()) {
                            case "Monthly":
                                total += transaction.getAmount().convertCurrency(currency).getAmount();
                                break;
                            case "Weekly":
                                double amountWeekly = (transaction.getAmount().convertCurrency(currency).getAmount() * 4);
                                total += amountWeekly;
                                break;
                            case "Daily":
                                double amountDaily = (transaction.getAmount().convertCurrency(currency).getAmount() * 30);
                                total += amountDaily;
                                break;
                            case "Annualy":
                                double amountAnnualy = (transaction.getAmount().convertCurrency(currency).getAmount() / 12);
                                total += amountAnnualy;
                                break;
                            default:
                                total += transaction.getAmount().convertCurrency(currency).getAmount();
                                break;
                        }
                    }
                }
            } else {
                if(month1.equals(month2)) {
                    returnString = returnString + (String.format("%1s %-40s %5s %-36s %5s %10.2f %3s %-10s %1s\n", "|", transaction.getDescription(), "|", "One Time",  "|", transaction.getAmount().convertCurrency(currency).getAmount(), "|", dateString, "|"));
                    total += transaction.getAmount().convertCurrency(currency).getAmount();
                }
            }
        }
        returnString = returnString + String.format("\n\nTotal Expense for this Month: %.2f", total);
        returnString = returnString + String.format("\nTotal Income for this Month: %.2f", income);
        returnString = returnString + String.format("\nBudget for this month: %.2f\n", monthlyBudget);
        if(total > monthlyBudget) {
            returnString = returnString + String.format("\nTry to limit your expenses..., You are over budget by %.2f\n\n", total-monthlyBudget);
        } else if (total < monthlyBudget) {
            returnString = returnString + String.format("\nYou haven't crossed your budget yet, You still have %.2f left to reach your budget.\n\n", monthlyBudget-total);
        }
        return returnString;
    }
}