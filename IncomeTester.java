import java.util.Date;

class IncomeTester {

    public static void main(String[] args) {
        Date date = new Date();
        Income income = new Income("Paycheck", "Salary", date, 4000.00, "Income", "Monthly", date, date);
        String expectedFrequency = "Monthly";
        Date expectedStartDate = date;
        Date expectedEndDate = date;

        String actualFrequency = income.getFrequency();
        Date actualStartDate = income.getStartDate();
        Date actualEndDate = income.getEndDate();

        if (expectedFrequency.equals(actualFrequency) && expectedStartDate.equals(actualStartDate) && expectedEndDate.equals(actualEndDate)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
    }

}