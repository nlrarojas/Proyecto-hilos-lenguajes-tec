package controller;

import core.Fig;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import utility.Constants;
import utility.RegularConstants;

/**
 *
 * @author nelson
 */
public class FigureProducerThread extends Thread {

    public FigureProducerThread() {
        super("Producer");        
    }

    @Override
    public void run() {
        while (RegularConstants.START_EXECUTION) {
            if (RegularConstants.EXECUTE) {
                trackWithLessFigures();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FigureProducerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        Random r = new Random();
        int result = r.nextInt(3)+1;
        Fig fig = new Fig(result*10, 5, Color.ORANGE, null, Constants.getInstance().getTracks()[position]);
        Constants.getInstance().getTracks()[position].addFigure(fig);
        fig.start();
    }
}
