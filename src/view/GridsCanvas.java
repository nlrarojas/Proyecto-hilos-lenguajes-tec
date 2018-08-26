package view;

import java.awt.Canvas;
import java.awt.Graphics;
import utility.IConstants;

public class GridsCanvas extends Canvas implements IConstants{  
    public GridsCanvas(int w, int h) {
        this.setSize(w, h);        
    }

    @Override
    public void paint(Graphics g) {
        int rowWid = getWidth() / (NUMBER_OF_TRACKS);
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, getHeight());
        }
    }
}
