package monopoly;

import java.util.Timer;
import java.util.Scanner;

public class Clock {
    
    public void pause(int seconds){
        seconds = seconds * 1000;
        try{
            Thread.sleep(seconds);     //time is measured in milliseconds
        }
        catch(Exception e){
        }
    }
}
