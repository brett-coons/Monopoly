package monopoly;

public class Bank {
    Integer balance;
    String name;
    
    public Bank(){
        balance = 100000;
    }    
    
    public void auction(Property P){
        
    }
    
    public void hasDeed(Property P, Player uno){
        P.owner = uno.name;
    }
    
    public void printMoney(){
        balance = balance + 50000;      //the Bank never goes broke
    }
    
    
}   //end of Bank


