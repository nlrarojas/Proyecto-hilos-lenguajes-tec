package view;

import core.Fig;
import core.TrackPanel;
import java.awt.Color;
import javax.swing.JPanel;
import utility.Constants;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class TracksField extends JPanel implements IConstants {

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
            this.add(panel).setBounds(i*TRACK_WIDTH, 0, TRACK_PANEL_WIDTH, TRACK_HEIGHT);            
            /*for (int j = 0; j < 10; j++) {
                panel.addFigure(new Fig(50*j, 10, Color.ORANGE, null));
            }*/
        }                
    }
}
