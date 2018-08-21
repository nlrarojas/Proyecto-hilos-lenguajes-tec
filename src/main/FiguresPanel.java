

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguresPanel extends JPanel {

    private static final long serialVersionUID = -6291233936414618049L;

    private Figure[] gameObjectsArray;

    public FiguresPanel(Figure[] gameObjectsArray, int width) {
        this.gameObjectsArray = gameObjectsArray;
        setPreferredSize(new Dimension(width, width));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i].draw(g);
        }
    }

}
