import java.util.Date;

public class OneTimeTester{
    
    public static void main(String args[]){
        
        Date date = new Date();
        
        OneTime o1 = new OneTime("Shopping","Clothes",date,100.00,"OneTime");
        OneTime o2 = new OneTime("Grocery","Food",date,200.00,"OneTime");
        
        if(o1.getDescription().equals("Shopping") && o1.getCategory().equals("Clothes") && o1.getAmount().getAmount() == 100.00 && o1.getType().equals("OneTime")){
            System.out.println("Constructor Test OneTime - Passed");
        }else{
            System.out.println("Constructor Test OneTime - Failed");
        }
        
        if(o2.getDescription().equals("Grocery") && o2.getCategory().equals("Food") & o2.getAmount().getAmount()== 200.00 && o2.getType().equals("OneTime")){
            System.out.println("Constructor Test OneTime - Passed");
        }else{
            System.out.println("Constructor Test OneTime - Failed");
        }
    }
}