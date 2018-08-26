package core;

import utility.Constants;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class SynchronizedBuffer implements Buffer, IConstants {

    public int emptyTrack;
    public TrackPanel[] tracks = Constants.getInstance().getTracks();
    private int occupiedBufferCount = 0;
    
    @Override
    public synchronized void set(int value) {
        int temp = 0;
        while (occupiedBufferCount == 0) {
            for (TrackPanel track : tracks) {
                if (track.getNumberOfFigures() <= temp) {
                    
                }
            }
        }
        --occupiedBufferCount;
        notify();
    }

    @Override
    public synchronized int get() {
        return emptyTrack;
    }
}
