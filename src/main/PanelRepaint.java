
package main;

import javax.swing.SwingUtilities;

import view.MainView;

public class PanelRepaint implements Runnable {

    private boolean running;
    private InitInterfaceAndThreads movingSquaresMain;
    private MainView mainViewInterfaceThreads;
    private int sleepTimePaint;


    public PanelRepaint(InitInterfaceAndThreads initInterfaceAndThreads, int sleepTimePaint, boolean running) {
        this.movingSquaresMain = initInterfaceAndThreads;
        this.sleepTimePaint = sleepTimePaint;
        this.running = running;
    }
    
    public PanelRepaint(MainView mainViewInterfaceThreads, int sleepTimePaint, boolean running) {

        this.mainViewInterfaceThreads = mainViewInterfaceThreads;
        this.sleepTimePaint = sleepTimePaint;
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            repaintJPanel();
            sleep();
        }
    }

    private void repaintJPanel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (movingSquaresMain == null) {
                    mainViewInterfaceThreads.repaintMovingPanel();
                } else {
                    movingSquaresMain.repaintMovingPanel();
                }                
            }
        });
    }

    private void sleep() {
        try {
            Thread.sleep(this.sleepTimePaint);
        } catch (InterruptedException e) {
        }
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

}