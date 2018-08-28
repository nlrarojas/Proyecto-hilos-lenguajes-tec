package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveCarThread implements Runnable{
    private boolean running;
    
    private Car myObject;
    private int sleepTime;
    private String name;
    
    public MoveCarThread(Car obj, int sleepTime, String name, boolean running){
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
