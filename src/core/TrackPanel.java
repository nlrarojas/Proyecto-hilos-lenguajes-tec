package core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import utility.RegularConstants;

/**
 *
 * @author nelson
 */
public class TrackPanel extends JPanel {

    private List<Fig> figures;
    private JPanel barrier;
    private boolean barrierActivated;

    public TrackPanel() {
        this.figures = new ArrayList<>();
        this.barrierActivated = false;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, RegularConstants.TRACK_PANEL_WIDTH / RegularConstants.NUMBER_OF_TRACKS, RegularConstants.TRACK_HEIGHT - 14);
        g.setColor(Color.GREEN);
        g.fillRect(1, 2, RegularConstants.TRACK_PANEL_WIDTH / RegularConstants.NUMBER_OF_TRACKS - 2, RegularConstants.TRACK_HEIGHT - 17);

        g.setColor(Color.red);
        g.fillRect(0, RegularConstants.TRACK_HEIGHT / 2, RegularConstants.TRACK_WIDTH, 30);
        
        for (int i = 0; i < figures.size(); i++) {
            /*if (i + 1 < figures.size()) {                
                    if ((figures.get(i).getyPosition() + figures.get(i).getSpeed()) 
                            > figures.get(i + 1).getyPosition()) {
                        figures.get(i).setyPosition(figures.get(i).getyPosition() - figures.get(i).getSpeed());
                        continue;
                    }
                } */
            if (barrierActivated) {
                if (figures.get(i).getyPosition() + figures.get(i).getMovement() > (RegularConstants.TRACK_HEIGHT / 2) && 
                        figures.get(i).getyPosition() + figures.get(i).getMovement() < (RegularConstants.TRACK_HEIGHT / 2) + 30) {
                    figures.get(i).setBarrierActivated(true);
                } else {
                    g.setColor(figures.get(i).getColor());
                    g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
                }
            } else {
                figures.get(i).setBarrierActivated(false);
                g.setColor(figures.get(i).getColor());
                g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
                if ((figures.get(i).getyPosition() + figures.get(i).getMovement()) > (RegularConstants.TRACK_HEIGHT - 30)) {
                    figures.get(i).endExecutionThread();
                    figures.remove(figures.get(i));
                }
            }
        }       
    }

    public int getNumberOfFigures() {
        return figures.size();
    }

    public void addFigure(Fig figure) {
        figures.add(figure);
    }

    public void setBarrier(JPanel panel) {
        barrier = panel;
    }

    public void activeBarrier(boolean selected) {
        barrierActivated = selected;
    }
    
    public boolean getBarrierStatus() {
        return barrierActivated;
    }
}
