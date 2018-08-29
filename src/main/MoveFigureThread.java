package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import util.IConst;

public class MoveFigureThread implements Runnable {
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
    	
        while(IConst.START_EXECUTION) {
        	if (IConst.EXECUTE) {
        		//While thread is running, call move function in figure
        		myObject.move();
        		try {
        			Thread.sleep(this.sleepTime);
        			} catch (InterruptedException ex1) {
        				Logger.getLogger(MoveFigureThread.class.getName()).log(Level.SEVERE, null, ex1);
        			}            
        		}
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        }
         
        
    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
}
