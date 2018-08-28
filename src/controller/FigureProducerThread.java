package controller;

import core.Buffer;
import core.Fig;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Constants;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class FigureProducerThread extends Thread implements IConstants {

    private Buffer sharedTracks;

    public FigureProducerThread(Buffer sharedTracks) {
        super("Producer");
        this.sharedTracks = sharedTracks;
    }

    @Override
    public void run() {        
        while (START_EXECUTION) {
            if (EXECUTE) {
                Fig fig = new Fig(10, Color.yellow, null);
                trackWithLessFigures(fig);
                System.out.println("new figure");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FigureProducerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void trackWithLessFigures(Fig fig) {
        int temp = Constants.getInstance().getTracks()[0].getNumberOfFigures();
        int position = 0;
        for (int i = 1; i < Constants.getInstance().getTracks().length; i++) {
            if (Constants.getInstance().getTracks()[i].getNumberOfFigures() < temp) {
                temp = Constants.getInstance().getTracks()[i].getNumberOfFigures();                
                position = i;
            }
        }
        System.out.println(position);
        Constants.getInstance().getTracks()[position].addFigure(fig);
        Constants.getInstance().getTracks()[position].addFigure(fig);
        Constants.getInstance().getTracks()[position].repaint();
    }
}
