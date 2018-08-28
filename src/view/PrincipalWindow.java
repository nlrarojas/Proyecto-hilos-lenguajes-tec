package view;

import controller.FigureProducerThread;
import core.TrackPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import utility.Constants;
import utility.IConstants;
import static utility.IConstants.TRACK_HEIGHT;
import static utility.IConstants.TRACK_WIDTH;

/**
 *
 * @author nelson
 */
public class PrincipalWindow extends JFrame implements IConstants {

    private JDesktopPane desktopPane;
    private TracksField tracksField;
    private JPanel actionsPanel;
    private JPanel panelBarrier;
    
    public PrincipalWindow() {
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        this.add(desktopPane).setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        tracksField = new TracksField();
        desktopPane.add(tracksField).setBounds((WINDOW_WIDTH - TRACK_PANEL_WIDTH) / 2, 0, TRACK_PANEL_WIDTH, TRACK_HEIGHT);

        actionsPanel = new JPanel();
        addActions();
        desktopPane.add(actionsPanel).setBounds(0, TRACK_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT - (TRACK_HEIGHT + 10));

        panelBarrier = new JPanel();
        panelBarrier.setLayout(null);
        
        FigureProducerThread fpt = new FigureProducerThread(panelBarrier);
        fpt.start();
        for (int i = 0; i < NUMBER_OF_TRACKS; i++) {
            JToggleButton barrier = new JToggleButton();
            TrackPanel tf = Constants.getInstance().getTracks()[i];
            barrier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean selected = barrier.isSelected();
                    barrier.setSelected(selected);
                    //panel contstants
                    tf.activeBarrier(selected);
                    tf.repaint();
                }
            });
            panelBarrier.add(barrier).setBounds((i * TRACK_WIDTH), 0, TRACK_WIDTH, 30);
        }        
        desktopPane.add(panelBarrier).setBounds((WINDOW_WIDTH - TRACK_PANEL_WIDTH) / 2, TRACK_HEIGHT / 2, TRACK_WIDTH*11, 30);
    }
    
    private void addActions() {
        actionsPanel.setLayout(null);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }
}
