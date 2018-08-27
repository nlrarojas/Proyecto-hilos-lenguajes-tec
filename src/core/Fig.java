package core;

import java.awt.Color;
import javax.swing.Icon;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class Fig implements IConstants{
    private int yPosition;
    private int speed;
    private Color color;
    private Icon image;

    public Fig(int speed, Color color, Icon image) {
        this.yPosition = STARTING_TRACK_FIGURE_POSITION;
        this.speed = speed;
        this.color = color;
        this.image = image;
    }

    public Fig(int speed) {
        this.yPosition = STARTING_TRACK_FIGURE_POSITION;
        this.speed = speed;
    }        

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }     

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }    
}
