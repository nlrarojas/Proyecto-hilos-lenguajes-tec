package view;

import java.awt.Canvas;
import java.awt.Graphics;

public class GridsCanvas extends Canvas {

    private int width;
    private int height;
    private int rows;
    private int cols;

    public GridsCanvas(int w, int h, int c) {
        this.setSize(width = w, height = h);
        cols = c;
    }

    @Override
    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        int rowWid = width / (cols);
        for (i = 0; i < cols; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
    }
}
