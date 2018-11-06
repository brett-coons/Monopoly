package monopoly;
import java.util.Random;
import java.util.Arrays;

public class Player {
    String name;
    int balance;        //cash on hand
    int boardPosition;
    int jailPass;
    int attempts;     //keeps track of players jail break attempts
    boolean inJail;
    int[] pastPlays;       //keeps track of players last 3 dice rolls.
    int[] store;        // for storing rolls not to be committed to pastPlays
    
    
    public Player(String name){
        this.name = name;
        this.balance = 1500;
        this.boardPosition = 0;
        this.jailPass = 0;
        this.attempts = 0;
        this.inJail = false;
        this.pastPlays = new int[6];
        this.store = new int[2];
    }
    
    public int roll(){
        int min = 1;
        int max = 6;
        Random random = new Random();
        int dice0 = random.nextInt((max-min)+1) + min;      // generates random integer from 1-6
        int dice1 = random.nextInt((max-min)+1) + min;
        store[0] = dice0;
        store[1] = dice1;
        return (dice0 + dice1);
    }   //end of roll
    
    public void takeTurn(){
        if (inJail == true){
            jailBreak();        // attempts to get out of jail
        }
        else{
            roll();
            updatePlays();
            if (checkPlays(pastPlays)){      //check if last 3 rolls are doubles
                imprison();
            }          
            else{
                move(pastPlays[0] + pastPlays[1]);
            }                               
        }

        
        
    }   // end of setPlays
    

        


    

    
    /**************************************************************************/
    
    public void imprison(){
        inJail = true;
        //boardPosition = int     //jail location
    }   //end of imprison
    
    public void emancipate(){
        inJail = false;
        pastPlays = new int[6];     // reset pastPlays array
        attempts = 0;               // reset attempts
    }       //end of emancipate
    
    public void move(int spaces){
        if (boardPosition + spaces > 39){
            collect(200);       //collect $200 for passing GO
        }
        boardPosition = (boardPosition + spaces)%40;        
    }   //end of move
    

    
    public void drawChanceCard(){
        
    }
    
    public void drawCommunityCard(){
        
    }
    
    public void collect(int sum){
        balance = balance + sum;        //sum may be negative or positive
    }

    public boolean jailBreak(){
        if (jailPass > 0){
            jailPass--;
            emancipate();
            move(roll());
            updatePlays();
            return (true);
        }
        else{
            roll();
            attempts++;
            if (checkDoubles(store)){      // player must roll doubles to get out of jail
                emancipate();
                move(store[0] + store[1]);
                updatePlays();
                return (true);
            }
            if (attempts == 3){     // player pays $50 to get out of jail after 3 failed attempts
                emancipate();
                move(store[0] + store[1]);
                updatePlays();
                collect(-50);
                return (true);
            }        
        }
        return (false);
    }   //end of jailBreak

    /**************************************************************************/  
    public void printPlays(){
        System.out.println(Arrays.toString(pastPlays));
    }   //end of printPlays
    
    public void details(){
        System.out.println("balance: " + balance);
        System.out.println("position: " + boardPosition);
        System.out.println("inJail: " + inJail);
        printPlays();
        System.out.println();
    }       //end of details

    public boolean checkPlays(int[] array){      // checks players past rolls for 3 consecutive doubles
        for (int i = array.length - 1; i >= 0; i=i-2){
            if (array[i] == 0){
                return (false);
            }
            else if (array[i] != array[i-1]){
                return (false);
            }
        }
        return (true);
    }   //end of checkArray
    
    public boolean checkDoubles(int[] array){
        if (array[0] == array[1]){
            return (true);
        }
        return (false);
    }

    public void checkRuleSet(int location){
        
    }
    
    public void updatePlays(){
        for (int i = 5; i > 1; i--){
            pastPlays[i] = pastPlays[i-2];
        }
        pastPlays[0] = store[0];
        pastPlays[1] = store[1];
    }       //end of updatePlays
    
    /**************************************************************************/
    
}   // end of Player class