/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class TrackPanel extends JPanel implements IConstants{
    private int numberOfFigures;    

    public TrackPanel() {        
        this.numberOfFigures = 0;                       
    }         
    
    
    @Override
    public void paint(Graphics g) {                
        g.setColor(Color.black);
        g.fillRect(0, 2, TRACK_PANEL_WIDTH/NUMBER_OF_TRACKS, TRACK_HEIGHT-14);
        g.setColor(Color.GREEN);
        g.fillRect(1, 4, TRACK_PANEL_WIDTH/NUMBER_OF_TRACKS-2, TRACK_HEIGHT-17);
            
    }
       
    public int getNumberOfFigures() {
        return numberOfFigures;
    }

    public void setNumberOfFigures(int numberOfFigures) {
        this.numberOfFigures = numberOfFigures;
    }        
}
