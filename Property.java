package monopoly;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Property {
    String owner;
    String name;
    String color;
    Integer location;
    Integer price;    
    Integer num_houses;
    
    public Property(Integer location,String name,Integer price, String color){
        this.location = location;
        this.name = name;     
        this.price = price;
        this.color = color;
        this.num_houses = 0;
    }
  
    public void incrementNumHouses(){
        if (num_houses <= 4){
            num_houses ++;
        }
        else{
            System.out.println("Maximum number of buildings reached for this property");
        }
    }
    
    public void details(){
        System.out.println(name);
        System.out.println("Owner: " + owner);
        System.out.println("Location: " + location);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
        System.out.println("Buildings: " + num_houses);
        System.out.println();
    }
    
    
}

