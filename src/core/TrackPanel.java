package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private URL resource1 = TrackPanel.class.getResource("/utility/8bit.png");
    private URL resource2 = TrackPanel.class.getResource("/utility/bocho.png");
    private URL resource3 = TrackPanel.class.getResource("/utility/negro.png");

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

        g.setColor(Color.white);
        g.fillRect(0, 521, RegularConstants.TRACK_WIDTH, RegularConstants.SIZE_FIGURE - 7);
        g.setColor(Color.red);
        g.fillRect(0, RegularConstants.TRACK_HEIGHT / 2, RegularConstants.TRACK_WIDTH, 30);        
        for (int i = 0, j = figures.size() - 1; i < figures.size(); i++, j--) {
            /*if (RegularConstants.REVERT_THREAD) {                
                /*if (j - 1 > 0) {
                    if (figures.get(j).getyPosition() - RegularConstants.SIZE_FIGURE <= figures.get(j - 1).getyPosition()) {
                        figures.get(j).setyPosition(figures.get(j).getyPosition() + figures.get(j - 1).getMovement());
                    }
                }
            } else {*/
                if (i + 1 < figures.size()) {               
                    if (figures.get(i + 1).getyPosition() + RegularConstants.SIZE_FIGURE >= figures.get(i).getyPosition()) {
                        figures.get(i + 1).setyPosition(figures.get(i + 1).getyPosition() - figures.get(i).getMovement());
                    }
                }                  
            //}            
            if (barrierActivated) {
                if (figures.get(i).getyPosition() + figures.get(i).getMovement() > (RegularConstants.TRACK_HEIGHT / 2)
                        && figures.get(i).getyPosition() + figures.get(i).getMovement() < (RegularConstants.TRACK_HEIGHT / 2) + 30) {
                    figures.get(i).setBarrierActivated(true);
                } else {
                    //Aqui se necesitan pintar las imagenes*************************************************************************************************
                    if (RegularConstants.IMAGE_FIG) {
                        if (figures.get(i).getSpeed() == 10) {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/bocho.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 10) {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/bocho.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if (figures.get(i).getSpeed() == 20) {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/negro.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 20) {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/negro.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if ((figures.get(i).getSpeed() / 100) * 10 == 30) {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/8bit.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/8bit.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                            } catch (IOException ex) {
                                Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
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
                            int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 15, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 15};
                            int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 15, figures.get(i).getyPosition() + 15};
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
                if (RegularConstants.IMAGE_FIG) {
                    if (figures.get(i).getSpeed() == 10) {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/bocho.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if ((figures.get(i).getSpeed() / 100) * 10 == 10) {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/bocho.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (figures.get(i).getSpeed() == 20) {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/negro.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if ((figures.get(i).getSpeed() / 100) * 10 == 20) {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/negro.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if ((figures.get(i).getSpeed() / 100) * 10 == 30) {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/8bit.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            g.drawImage(ImageIO.read(new File("/home/nelson/NetBeansProjects/Proyecto-hilos-lenguajes-tec/src/utility/8bit.jpg")), (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, figures.get(i).getyPosition(), RegularConstants.SIZE_FIGURE, RegularConstants.SIZE_FIGURE, null);
                        } catch (IOException ex) {
                            Logger.getLogger(TrackPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if ((figures.get(i).getyPosition() + figures.get(i).getMovement()) > (RegularConstants.TRACK_HEIGHT - 30)
                            || (figures.get(i).getyPosition() + figures.get(i).getMovement()) < 0) {
                        figures.get(i).endExecutionThread();
                        figures.remove(figures.get(i));
                        repaint();
                    }
                } else {
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
                        int[] xp = {(RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 + 15, (RegularConstants.TRACK_WIDTH - RegularConstants.SIZE_FIGURE) / 2 - 15};
                        int[] yp = {figures.get(i).getyPosition(), figures.get(i).getyPosition() + 15, figures.get(i).getyPosition() + 15};
                        Polygon p = new Polygon(xp, yp, yp.length);
                        g.drawPolygon(p);
                        g.setColor(figures.get(i).getColor());
                        g.fillPolygon(p);
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
