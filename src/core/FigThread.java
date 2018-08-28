package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class FigThread implements Runnable, IConstants {

    private Fig figure;
    private int movingTime;

    public FigThread(Fig figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        while (EXECUTE) {
            try {
                figure.setyPosition(figure.getyPosition() + figure.getMovement());
                Thread.sleep(movingTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(FigThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
