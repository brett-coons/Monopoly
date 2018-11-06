package monopoly;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Monopoly {
    Player[] Player;
    Property[] Property;
    String[] names = new String[]{"Courtney", "Austin", "Joe"};
    
    private Scanner scanner;
    private String file;
    private BufferedReader read;
    
    public Monopoly(){
        Player = new Player[names.length + 1];
        Property = new Property[40];
        Bank bank = new Bank();
    }
    
    public void loadPlayers(){
        for (int i = 0; i < names.length-1; i++){
            Player[i] = new Player(names[i]);
        }
        System.out.println("ENTER NAME");        
        scanner = new Scanner(System.in);
        Player[3] = new Player(scanner.next());
    }
    
    public void loadProperties(){
        try{
            file = "Property_List.txt";
            read = new BufferedReader(new FileReader(file));
            String line = read.readLine();
            while (line != null){
                int j = 0;
                String[] split = line.split(",");
                Property[j] = new Property(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), split[3]);
                j++;
                line = read.readLine();
            }
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        Monopoly game = new Monopoly();
        Clock clock = new Clock();
        
        game.loadProperties();
        game.loadPlayers();
        
       
        for (int i = 1; i <= 5; i++){
            for (Player p: game.Player){
                p.takeTurn();
                System.out.println(p.name + ": TURN " + i);
                p.details();
                if (p.inJail){
                    break;
                }
                clock.pause(1);
            }
        }
       
        

    }
    
}
