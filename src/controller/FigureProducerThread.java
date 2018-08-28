package controller;

import core.Fig;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import utility.Constants;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class FigureProducerThread extends Thread implements IConstants {        
    
    public FigureProducerThread(JPanel panel) {
        super("Producer");
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            Constants.getInstance().getTracks()[i].setBarrier(panel);
        }        
    }

    @Override
    public void run() {        
        while (START_EXECUTION) {
            if (EXECUTE) {                
                trackWithLessFigures();                                                
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FigureProducerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void trackWithLessFigures() {
        int temp = Constants.getInstance().getTracks()[0].getNumberOfFigures();
        int position = 0;
        for (int i = 1; i < Constants.getInstance().getTracks().length; i++) {
            if (Constants.getInstance().getTracks()[i].getNumberOfFigures() < temp) {
                temp = Constants.getInstance().getTracks()[i].getNumberOfFigures();                
                position = i;
            }
        }
        Fig fig = new Fig(250, 5, Color.ORANGE, null, Constants.getInstance().getTracks()[position]);
        Constants.getInstance().getTracks()[position].addFigure(fig); 
        fig.start();        
    }
}
