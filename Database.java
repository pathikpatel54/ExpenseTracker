import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private ArrayList<Budget> budget = new ArrayList<Budget>();

    Database() {
        this.budget = ReadBudget();
    }

    public ArrayList<Transaction> ReadTransactions() {
        try{
            FileInputStream readData = new FileInputStream("transactionsdata.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            transactions = (ArrayList<Transaction>) readStream.readObject();
            readStream.close();
            return transactions;
        }catch (Exception e) {
            e.printStackTrace();
            return transactions;
        }
    }

    public void WriteTransactions(ArrayList<Transaction> transactions) {
        try{
            FileOutputStream writeData = new FileOutputStream("transactionsdata.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        
            writeStream.writeObject(transactions);
            writeStream.flush();
            writeStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Budget> ReadBudget() {
        try{
            FileInputStream readData = new FileInputStream("budgetdata.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            budget = (ArrayList<Budget>) readStream.readObject();
            readStream.close();
            return budget;
        }catch (Exception e) {
            e.printStackTrace();
            return budget;
        }
    }

    public void WriteBudget(Budget b) {
        budget.removeIf(o -> o.getType().equals(b.getType()));
        budget.add(b);
        try{
            FileOutputStream writeData = new FileOutputStream("budgetdata.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        
            writeStream.writeObject(budget);
            writeStream.flush();
            writeStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}