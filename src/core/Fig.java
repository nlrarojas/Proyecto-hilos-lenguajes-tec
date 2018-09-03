package core;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import utility.RegularConstants;

/**
 *
 * @author nelson
 */
public class Fig extends Thread {

    private int yPosition;
    private int movement;
    private int speed;
    private Color color;
    private BufferedImage image;
    private boolean endExecution;
    private TrackPanel trackPanel;
    private boolean barrierActivated;

    public Fig(int speed, int movement, Color color, BufferedImage image, TrackPanel trackPanel) {
        this.yPosition = RegularConstants.STARTING_TRACK_FIGURE_POSITION;
        this.movement = 1;
        this.speed = speed;
        this.color = color;
        this.image = image;
        this.endExecution = false;
        this.trackPanel = trackPanel;
        this.barrierActivated = false;
    }

    @Override
    public void run() {
        while (RegularConstants.START_EXECUTION) {
            if (RegularConstants.EXECUTE) {
                if (!barrierActivated) {
                    if (RegularConstants.REVERT_THREAD) {
                        yPosition -= movement;
                        trackPanel.repaint();
                        RegularConstants.STARTING_TRACK_FIGURE_POSITION = RegularConstants.TRACK_HEIGHT-50;
                    } else {                        
                        yPosition += movement;
                        trackPanel.repaint();
                        RegularConstants.STARTING_TRACK_FIGURE_POSITION = 0;
                    }
                }
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fig.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (endExecution) {
                break;
            }
        }
    }

    public void endExecutionThread() {
        endExecution = true;
    }

    public Fig(int speed) {
        this.yPosition = RegularConstants.STARTING_TRACK_FIGURE_POSITION;
        this.movement = speed;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    void setBarrierActivated(boolean barrier) {
        this.barrierActivated = barrier;
    }
}
