package utility;

import javax.swing.JPanel;

/**
 *
 * @author nelson
 */
public class Constants implements IConstants{
    public static Constants constants;    
    public static JPanel[] TRACKS;
    
    public Constants () {
        TRACKS = new JPanel[NUMBER_OF_TRACKS];
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            TRACKS[i] = new JPanel();            
        }
    }
    
    public Constants getInstance() {
        if (constants == null) {
            return new Constants();
        }
        return constants;
    }
}
