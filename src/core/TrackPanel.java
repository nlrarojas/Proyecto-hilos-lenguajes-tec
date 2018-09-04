package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
        g.fillRect(0, 0, RegularConstants.TRACK_PANEL_WIDTH / RegularConstants.NUMBER_OF_TRACKS, RegularConstants.TRACK_HEIGHT - 11);
        g.setColor(Color.GREEN);
        g.fillRect(1, 2, RegularConstants.TRACK_PANEL_WIDTH / RegularConstants.NUMBER_OF_TRACKS - 2, RegularConstants.TRACK_HEIGHT - 14);

        g.setColor(Color.red);
        g.fillRect(0, RegularConstants.TRACK_HEIGHT / 2, RegularConstants.TRACK_WIDTH, 30);        
        for (int i = 0; i < figures.size(); i++) {
            if (i + 1 < figures.size()) {
                if (figures.get(i+1).getyPosition() + RegularConstants.SIZE_FIGURE >= figures.get(i).getyPosition()) {
                    figures.get(i+1).setyPosition(figures.get(i+1).getyPosition() - figures.get(i).getMovement());
                }
            }
            if (barrierActivated) {
                if (figures.get(i).getyPosition() + figures.get(i).getMovement() > (RegularConstants.TRACK_HEIGHT / 2)
                        && figures.get(i).getyPosition() + figures.get(i).getMovement() < (RegularConstants.TRACK_HEIGHT / 2) + 30) {
                    figures.get(i).setBarrierActivated(true);
                } else {
                	//Aqui se necesitan pintar las imagenes*************************************************************************************************
                	if(RegularConstants.imageFig == true) 
                	{
                		if (figures.get(i).getSpeed() == 10) 
                		{
                			//g.drawImage(figures.get(, x, y, width, height, bgcolor, observer);
                		}
                		
/*                		try {
							figures.get(i).setImage(ImageIO.read(new File("C:/Universidad/workspace/Hilos/src/utility/8bit.jpg")));
							g.drawImage(img, x, y, width, height, bgcolor, observer);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
                	}else 
                	{
                        if (figures.get(i).getSpeed() == 10) {
                            g.setColor(figures.get(i).getColor());
                            g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 10) {
                            g.setColor(Color.MAGENTA);
                            g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
                        } else if (figures.get(i).getSpeed() == 20) {
                            g.drawOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);
                            g.setColor(figures.get(i).getColor());
                            g.fillOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE + 1, RegularConstants.SIZE_FIGURE + 1);
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 20) {
                            g.setColor(Color.BLACK);
                            g.drawOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);                    
                            g.fillOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE + 1, RegularConstants.SIZE_FIGURE + 1);
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 30) {
                            int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 15, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 15};
                            int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 15, figures.get(i).getyPosition() + 15};
                            Polygon p = new Polygon(xp, yp, yp.length);
                            g.drawPolygon(p);
                            g.setColor(Color.BLUE);
                            g.fillPolygon(p);
                        } else {
                            int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 5, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 5};
                            int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 5, figures.get(i).getyPosition() + 5};
                            Polygon p = new Polygon(xp, yp, yp.length);
                            g.drawPolygon(p);
                            g.setColor(figures.get(i).getColor());
                            g.fillPolygon(p);
                        }
                		
                	}

                }
            } else {
                figures.get(i).setBarrierActivated(false);
                //Aqui se necesitan pintar las imagenes*************************************************************************************************
                if(RegularConstants.imageFig == true) 
                {
                	//Borrar este codigo y cambiar por el que pinta imagenes**********************************************************************************
                    if (figures.get(i).getSpeed() == 10 || (figures.get(i).getSpeed() / 100) * 10 == 10) {
                        g.setColor(Color.MAGENTA);
                        g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);

                    } else if (figures.get(i).getSpeed() == 20 || (figures.get(i).getSpeed() / 100) * 10 == 20) {
                        g.setColor(Color.BLACK);
                        g.drawOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);                    
                        g.fillOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE + 1, RegularConstants.SIZE_FIGURE + 1);

                    } else {
                        int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 15, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 15};
                        int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 15, figures.get(i).getyPosition() + 15};
                        Polygon p = new Polygon(xp, yp, yp.length);
                        g.drawPolygon(p);
                        g.setColor(Color.BLUE);
                        g.fillPolygon(p);
                    }
                    if ((figures.get(i).getyPosition() + figures.get(i).getMovement()) > (RegularConstants.TRACK_HEIGHT - 30) 
                            || (figures.get(i).getyPosition() + figures.get(i).getMovement()) < 0 ) {
                        figures.get(i).endExecutionThread();
                        figures.remove(figures.get(i));
                        repaint();
                    }
                	
                }
                else 
                {
                	if (figures.get(i).getSpeed() == 10 || (figures.get(i).getSpeed() / 100) * 10 == 10) {
                        g.setColor(Color.MAGENTA);
                        g.fillRect((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);

                    } else if (figures.get(i).getSpeed() == 20 || (figures.get(i).getSpeed() / 100) * 10 == 20) {
                        g.setColor(Color.BLACK);
                        g.drawOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE);                    
                        g.fillOval((RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE + 1, RegularConstants.SIZE_FIGURE + 1);

                    } else {
                        int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 15, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 15};
                        int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 15, figures.get(i).getyPosition() + 15};
                        Polygon p = new Polygon(xp, yp, yp.length);
                        g.drawPolygon(p);
                        g.setColor(Color.BLUE);
                        g.fillPolygon(p);
                    }
                    if ((figures.get(i).getyPosition() + figures.get(i).getMovement()) > (RegularConstants.TRACK_HEIGHT - 30) 
                            || (figures.get(i).getyPosition() + figures.get(i).getMovement()) < 0 ) {
                        figures.get(i).endExecutionThread();
                        figures.remove(figures.get(i));
                        repaint();
                    }              	
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
