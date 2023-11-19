package OOP.Enacaqsulation;

public class BankApplication {
    public static void main(String[] args){
        Bank bank = new Bank("ABA", new BankAccount[0]);

        bank.openAccount("John Doe", 1000.0);
        bank.openAccount("John Thai", 1000.0);
        bank.display();
        bank.transfer("0001","0002",500);
        bank.display();
    }
}
