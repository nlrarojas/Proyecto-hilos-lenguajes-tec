package view;

import core.Fig;
import core.TrackPanel;
import java.awt.Color;
import javax.swing.JPanel;
import utility.Constants;
import utility.RegularConstants;

/**
 *
 * @author nelson
 */
public class TracksField extends JPanel {

    boolean black = true;

    public TracksField() {
        //this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));  
        this.setLayout(null);
        this.setOpaque(false);
        init();        
    }
    
    private void init() {        
        for (int i = 0; i < Constants.getInstance().getTracks().length; i++) {
            TrackPanel panel = Constants.getInstance().getTracks()[i];
            this.add(panel).setBounds(i*RegularConstants.TRACK_WIDTH, 0, RegularConstants.TRACK_PANEL_WIDTH, RegularConstants.TRACK_HEIGHT);                        
        }                
    }
}
