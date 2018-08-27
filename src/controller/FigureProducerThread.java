package controller;

import core.Buffer;
import core.Fig;
import java.awt.Color;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class FigureProducerThread extends Thread implements IConstants{

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
            }
        }
    }
    
}
