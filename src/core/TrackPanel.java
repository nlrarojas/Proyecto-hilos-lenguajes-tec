package core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class TrackPanel extends JPanel implements IConstants {

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
        g.fillRect(0, 0, TRACK_PANEL_WIDTH / NUMBER_OF_TRACKS, TRACK_HEIGHT - 14);
        g.setColor(Color.GREEN);
        g.fillRect(1, 2, TRACK_PANEL_WIDTH / NUMBER_OF_TRACKS - 2, TRACK_HEIGHT - 17);

        g.setColor(Color.red);
        g.fillRect(0, TRACK_HEIGHT / 2, TRACK_WIDTH, 30);
        
        for (int i = 0; i < figures.size(); i++) {
            /*if (i + 1 < figures.size()) {                
                    if ((figures.get(i).getyPosition() + figures.get(i).getSpeed()) 
                            > figures.get(i + 1).getyPosition()) {
                        figures.get(i).setyPosition(figures.get(i).getyPosition() - figures.get(i).getSpeed());
                        continue;
                    }
                } */
            if (barrierActivated) {
                if (figures.get(i).getyPosition() + figures.get(i).getMovement() > (TRACK_HEIGHT / 2) && 
                        figures.get(i).getyPosition() + figures.get(i).getMovement() < (TRACK_HEIGHT / 2) + 30) {
                    figures.get(i).setBarrierActivated(true);
                } else {
                    g.setColor(figures.get(i).getColor());
                    g.fillRect((TRACK_WIDTH - SIZE_FIGURE) / 2, figures.get(i).getyPosition(), SIZE_FIGURE, SIZE_FIGURE);
                }
            } else {
                figures.get(i).setBarrierActivated(false);
                g.setColor(figures.get(i).getColor());
                g.fillRect((TRACK_WIDTH - SIZE_FIGURE) / 2, figures.get(i).getyPosition(), SIZE_FIGURE, SIZE_FIGURE);
                if ((figures.get(i).getyPosition() + figures.get(i).getMovement()) > (TRACK_HEIGHT - 30)) {
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
