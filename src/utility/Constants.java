package utility;

import core.TrackPanel;
/**
 *
 * @author nelson
 */
public class Constants {
    public static Constants constants;    
    public TrackPanel[] tracks;
    public static int TRACK_WIDTH = 600/RegularConstants.NUMBER_OF_TRACKS;
    public static int HEIGHT = 600;
    
    public Constants () {
        initializeTracks();
    }
    
    public static Constants getInstance() {
        if (constants == null) {            
            constants =  new Constants();            
            return constants;
        }
        return constants;
    }

    public TrackPanel[] getTracks() {
        return tracks;
    }

    public void setTracks(TrackPanel[] tracks) {
        this.tracks = tracks;
    }      

    public void initializeTracks() {
        tracks = new TrackPanel[RegularConstants.NUMBER_OF_TRACKS];
        for (int i = 0; i < RegularConstants.NUMBER_OF_TRACKS; i++) {
            tracks[i] = new TrackPanel();            
        }
    }
}
