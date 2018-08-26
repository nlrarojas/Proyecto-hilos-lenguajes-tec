package utility;

import core.TrackPanel;
/**
 *
 * @author nelson
 */
public class Constants implements IConstants{
    public static Constants constants;    
    public TrackPanel[] tracks;
    public static int TRACK_WIDTH = 600/NUMBER_OF_TRACKS;
    public static int HEIGHT = 600;
    
    public Constants () {
        tracks = new TrackPanel[NUMBER_OF_TRACKS];
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            tracks[i] = new TrackPanel();            
        }
    }
    
    public static Constants getInstance() {
        if (constants == null) {
            return new Constants();
        }
        return constants;
    }

    public TrackPanel[] getTracks() {
        return tracks;
    }

    public void setTracks(TrackPanel[] tracks) {
        this.tracks = tracks;
    }      
}
