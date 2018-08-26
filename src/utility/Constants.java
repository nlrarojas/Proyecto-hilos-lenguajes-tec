package utility;

import core.Figure;

/**
 *
 * @author nelson
 */
public class Constants implements IConstants{
    public static Constants constants;    
    public static Figure[] TRACKS;
    public static int TRACK_WIDTH = 600/NUMBER_OF_TRACKS;
    public static int HEIGHT = 600;
    
    public Constants () {
        TRACKS = new Figure[NUMBER_OF_TRACKS];
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            TRACKS[i] = new Figure(TRACK_WIDTH, HEIGHT, i);            
        }
    }
    
    public static Constants getInstance() {
        if (constants == null) {
            return new Constants();
        }
        return constants;
    }
}
