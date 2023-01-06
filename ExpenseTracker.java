/*******************************************************
 * ExpenseTracker.java
 * Calculate and Tracke user's daily and monthly expenses 
 * @author Pathik Patel
 * @version 1.1
 *******************************************************/
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ExpenseTracker{
    static Scanner keyboard = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    static Transactions transactions = new Transactions();
    static Database database = new Database();
    static Report report = new Report("USD");
    public static void main(String[] args) {
        boolean exit = false;
        int selection = 0;
        seperator(140, "-");
        print("\n                                          Welcome to the Expense Tracker!\n\nThis program is designed to keep track of your expenses, helping you manage your finances more efficiently.\nYou will be able to enter your expenses and categorize them into different categories.\nYou'll also be able to view your past expenses and create reports to get a better understanding of your spending habits.\nLet's get started!\n");
        seperator(140, "-");
        while (!exit) {
            selection = 0;
            print("\n\nSelect the option you would like to choose (e.g. Enter 1 to add Expense or Income)\n");
            print("\n1. Add Expense or Income\n2. Remove Expense or Income\n3. Add/Change Budget\n4. View Monthly/Daily Report\n5. Exit\n");
            print("\nYour Selection: ");
            try {
                selection = keyboard.nextInt();
                keyboard.nextLine();
                seperator(140, "-");
                switch(selection) {
                    case 1: addTransaction();
                        break;
                    case 2: removeTransaction();
                        break;
                    case 3: addBudgetConsole();
                        break;   
                    case 4: getReportsConsole();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Goodbye!");
                        return;
                }
                seperator(140, "-");
            } catch(Exception e) {
                System.out.println("\nInvalid input. Enter appropriate values please.");
                keyboard.nextLine();
                continue;
            }
        }
        keyboard.close();
    }
    
    static void addTransaction() {
        String startDate = new String(), endDate = new String(), date = new String();
        String frequency = new String(), description = new String(), category = new String();
        double amount = 0.0;
        Date sDate = new Date(), eDate = new Date(), expDate = new Date();
        int type = 0;
        print("\nSelect the Type of the Transaction\n");
        print("\n1. One Time Expense\n2. Recurring Expense\n3. Monthly Income\n");
        print("\nYour Selection: ");
        type = keyboard.nextInt();
        keyboard.nextLine();
        print("\nEnter the Description of the Transaction: ");
        description = keyboard.nextLine();
        print("Enter Category of Transaction (E.g. Shopping, Loan, Insurance, Food, Subscription, Salary etc.): ");
        category = keyboard.nextLine();
        print("Enter Transaction Amount: ");
        amount = keyboard.nextDouble();
        keyboard.nextLine();
        switch(type) {
            case 1:
                print("Enter the Date of the Transaction in MM/DD/YYYY format: ");
                date = keyboard.nextLine();
                try {
                    expDate = dateFormat.parse(date);
                } catch (ParseException e1) {
                    print("\nInvalid Date Input. Please try again.");
                    seperator(140, "-");
                    addTransaction();
                }
                transactions.addTransaction(new OneTime(description, category, expDate, amount, "One Time Expense"));
                break;
            case 2:
            case 3:
                print("Enter the Start date of Transaction in MM/DD/YYYY format: ");
                startDate = keyboard.next();
                print("Enter the End date of Transaction in MM/DD/YYYY format: ");
                endDate = keyboard.next();
                print("Enter the Frequency of the Transaction (E.g. Daily, Weekly, Monthly, Annualy): ");
                frequency = keyboard.next();
                try {
                    sDate = dateFormat.parse(startDate);
                    eDate = dateFormat.parse(endDate);
                } catch (ParseException e1) {
                    print("\nInvalid Date Input. Please try again.");
                    seperator(140, "-");
                    addTransaction();
                }
                if(type == 2) {
                    transactions.addTransaction(new RecurringExpense(description, category, amount, "Recurring Expense", frequency, sDate, eDate));
                } else if(type == 3) {
                    transactions.addTransaction(new Income(description, category, expDate, amount, category, frequency, sDate, eDate));
                }
                break;
            default:
                break;
        }
        print("\nTransaction has been added!!\n");
    }

    static void removeTransaction() {
        print(transactions.toString());
        print("\nEnter the description of a transaction that you would like to remove (N to Cancel): ");
        String transaction = keyboard.nextLine();
        if(transaction.equalsIgnoreCase("N")) {return;}
        Transaction removed = transactions.removeTransaction(transaction);
        if(removed.getDescription() != null) {
            print("\nTransaction has been removed!!\n");
            return;
        }
        print("\nSomething went wrong. Please try again.");
        return;
    }

    static void addBudgetConsole() {
        print("\nEnter your monthly Budget: ");
        double budget = keyboard.nextDouble();
        Budget budgetObj = new Budget(new Currency("USD", budget), "Monthly");
        print("\nEnter your daily Budget: ");
        double dailyBudget = keyboard.nextDouble();
        Budget dailyBudgetObj = new Budget(new Currency("USD", dailyBudget), "Daily");
        database.WriteBudget(budgetObj);
        database.WriteBudget(dailyBudgetObj);
        keyboard.nextLine();
        print("\nBudget has been added!!\n");
    }

    static void getReportsConsole() {
        print("\nSelect the report that you would like to Generate\n");
        print("\n1. Generate Monthly report\n2. Generate Daily report\n");
        print("\nYour Selection: ");
        int type = keyboard.nextInt();
        keyboard.nextLine();
        seperator(140, "-");
        print("\nEnter the currency code for the report\n\nYour Selection: ");
        String currency = keyboard.next();
        report = new Report(currency);
        switch(type) {
            case 1:
                print(report.generateMonthlyReport(transactions.getTransactions(), database.ReadBudget()));
                print("\nPress enter to continue...");
                try{System.in.read();}catch(Exception e){e.printStackTrace();}
                break;
            case 2:
                print(report.generateDailyReport(transactions.getTransactions(), database.ReadBudget()));
                print("\nPress enter to continue...");
                try{System.in.read();}catch(Exception e){e.printStackTrace();}
                break;
            default:
                break;
        }
    }

    static void print(String text) {
        System.out.print(text);
    }
    static void seperator(int num, String str) {
        print("\n");
        for(int i = 0; i < num; i++) {
            print(str);
        }
        print("\n");
    }
}