public class CurrencyTester {
    public static void main(String[] args) {
        Currency currency = new Currency("USD", 10);
        String curr = currency.getCurrency();
        double amt = currency.getAmount();
        Currency convertedCurrency = currency.convertCurrency("INR");
        String convertedCurr = convertedCurrency.getCurrency();
        double convertedAmt = convertedCurrency.getAmount();

        //test getCurrency
        if (curr.equals("USD")) {
            System.out.println("getCurrency() test passed");
        } else {
            System.out.println("getCurrency() test failed");
        }

        //test getAmount
        if (amt == 10) {
            System.out.println("getAmount() test passed");
        } else {
            System.out.println("getAmount() test failed");
        }

        //test convertCurrency
        if (convertedCurr.equals("INR") && convertedAmt == 814.21254) {
            System.out.println("convertCurrency() test passed");
        } else {
            System.out.println("convertCurrency() test failed");
        }
    }
}