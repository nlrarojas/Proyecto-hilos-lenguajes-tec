package view;

import core.Figure;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguresPanel extends JPanel {

    private static final long serialVersionUID = -6291233936414618049L;

    private Figure[] gameObjectsArray;

    private int width;
    private int height;
    private int numCols;

    public FiguresPanel(int numCols, Figure[] gameObjectsArray, int width, int heigth) {
        this.gameObjectsArray = gameObjectsArray;
        this.width = width;
        this.height = heigth;
        this.numCols = numCols;
        this.setPreferredSize(new Dimension(width, heigth));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color myColor = new Color(255, 239, 179);
        g.setColor(myColor);
        g.fillRect(width / 2, 0, width, height);

        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i].draw(g);
        }

        for (int i = 0; i < numCols; i++) {
            g.drawLine((i * width / numCols) + width / 2, 0, (i * width / numCols) + width / 2, height);
        }
    }
}