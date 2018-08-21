
package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;


public class InitInterfaceAndThreads implements Runnable {
    private static final int DRAWING_WIDTH = 600;
    private static final int NUMGAMEOBJECTS = 30;
    private boolean runningThread;
    
    private Figure[] gameObjectsArray = new Figure[NUMGAMEOBJECTS];
    private MoveFigureThread[] moveObjectArray = new MoveFigureThread[NUMGAMEOBJECTS];

    private JFrame frame;
    private FiguresPanel movingPanel;
    private PanelRepaint panelRepaint;
    private int sleepThreadTime;
    private int sleepTimePaint;

    //constructor
    public InitInterfaceAndThreads() {
        this.sleepThreadTime = 10;
        this.sleepTimePaint = 20;
        this.runningThread = true;
        
        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i] = new Figure(DRAWING_WIDTH);
            moveObjectArray[i] = new MoveFigureThread(gameObjectsArray[i], 
                                                    sleepThreadTime, 
                                                    "Thread " + i,
                                                    this.runningThread);
        }//end for
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("Moving Figures with different threads!");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        movingPanel = new FiguresPanel(gameObjectsArray, DRAWING_WIDTH);
        frame.getContentPane().add(movingPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        //START THREADS
        for (MoveFigureThread myCurrentThread : moveObjectArray) {
            new Thread(myCurrentThread).start();
        } //end for
        panelRepaint = new PanelRepaint(this, this.sleepTimePaint, this.runningThread);
        new Thread(panelRepaint).start();
    }

    private void exitProcedure() {
        this.runningThread = false;
        panelRepaint.setRunning(false);
        frame.dispose();
        System.exit(0);
    }

    public void repaintMovingPanel() {
        movingPanel.repaint();
    }

}
