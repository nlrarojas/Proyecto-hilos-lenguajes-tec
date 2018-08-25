package main;

import core.Figure;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveFigureThread implements Runnable{
    private boolean running;
    
    private Figure myObject;
    private int sleepTime;
    private String name;
    
    public MoveFigureThread(Figure obj, int sleepTime, String name, boolean running){
        this.myObject = obj;
        this.sleepTime = sleepTime;
        this.running = running;
        this.name = name;
    }

    @Override
    public void run() {
        while(running){
            myObject.move();
            
            try {
                //System.out.println("Thread name: " + this.name);
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoveFigureThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }//end while
    }
    
    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
}
