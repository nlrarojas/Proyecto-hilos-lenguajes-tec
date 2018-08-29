package view;

import controller.CreateFigures;
import controller.FigureProducerThread;
import core.TrackPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import utility.Constants;
import utility.RegularConstants;
import static utility.RegularConstants.TRACK_HEIGHT;
import static utility.RegularConstants.TRACK_WIDTH;

/**
 *
 * @author nelson
 */
public class PrincipalWindow extends JFrame {

    private JDesktopPane desktopPane;
    private TracksField tracksField;
    private JPanel actionsPanel;
    private JPanel panelBarrier;
    
    private JComboBox<String> comboSpeed;
    private JTextField txtValue;
    private JCheckBox chckBoxFigureType;
    
    public PrincipalWindow() {
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(new Dimension(RegularConstants.WINDOW_WIDTH, RegularConstants.WINDOW_HEIGHT));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        this.add(desktopPane).setBounds(0, 0, RegularConstants.WINDOW_WIDTH, RegularConstants.WINDOW_HEIGHT);

        tracksField = new TracksField();
        desktopPane.add(tracksField).setBounds((RegularConstants.WINDOW_WIDTH - RegularConstants.TRACK_PANEL_WIDTH) / 2, 0, RegularConstants.TRACK_PANEL_WIDTH, TRACK_HEIGHT);

        actionsPanel = new JPanel();
        addActions();
        desktopPane.add(actionsPanel).setBounds(0, TRACK_HEIGHT + 35, RegularConstants.WINDOW_WIDTH, RegularConstants.WINDOW_HEIGHT - (TRACK_HEIGHT + 10));

        panelBarrier = new JPanel();
        panelBarrier.setLayout(null);
                
        for (int i = 0; i < RegularConstants.NUMBER_OF_TRACKS; i++) {
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
        desktopPane.add(panelBarrier).setBounds((RegularConstants.WINDOW_WIDTH - RegularConstants.TRACK_PANEL_WIDTH) / 2, TRACK_HEIGHT, TRACK_WIDTH*11, 30);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
    }
    
    private void addActions() {
        actionsPanel.setLayout(null);
        String[] items = {"Velocidades", "Velocidad 1", "Velocidad 2", "Velocidad 3"};
        comboSpeed = new JComboBox<>(items);        
        comboSpeed.setBounds(293, 11, 130, 20);        
        actionsPanel.add(comboSpeed);       

        txtValue = new JTextField();
        txtValue.setText("Value");
        txtValue.setBounds(197, 11, 86, 20);
        txtValue.setColumns(10);
        txtValue.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtValue.getText().equals("Value")) {
                    txtValue.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtValue.getText().equals("")) {                    
                    txtValue.setText("Value");
                }                
            }
        });
        actionsPanel.add(txtValue);        
        
        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int value = 0;
                int speed = 0;
                if (!txtValue.getText().isEmpty()) {
                    if (comboSpeed.getSelectedIndex() != 0) {
                        speed = comboSpeed.getSelectedIndex();
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione la velocidad");
                    }
                    try {                        
                        value = Integer.parseInt(txtValue.getText());
                        createFigures(speed, value);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese valores numéricos");
                    }
                }                                
            }            
        });
        btnCreate.setBounds(200, 41, 220, 23);
        actionsPanel.add(btnCreate);  
        
        JToggleButton btnRevert = new JToggleButton("Revert");
        btnRevert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revertOrientation(btnRevert.isSelected());
            }            
        });
        btnRevert.setBounds(448, 10, 120, 23);
        actionsPanel.add(btnRevert);

        JButton btnSimulation = new JButton("Simulation");
        btnSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }            
        });
        btnSimulation.setBounds(448, 41, 120, 23);
        actionsPanel.add(btnSimulation);

        JToggleButton btnInterrupt = new JToggleButton("Interrupt");
        btnInterrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterruptExecution(btnInterrupt.isSelected());
            }
        });

        btnInterrupt.setBounds(620, 10, 100, 54);
        actionsPanel.add(btnInterrupt);
        
        chckBoxFigureType = new JCheckBox("Show figures");
        actionsPanel.add(chckBoxFigureType).setBounds(740, 0, 150, 30);
    }
    
    private void exitProcedure() {
        RegularConstants.START_EXECUTION = false;
        this.dispose();
        System.exit(0);
    }
    
    private void createFigures(int speed, int value) {
        Constants.getInstance().initializeTracks();
        CreateFigures createFigures = new CreateFigures(speed, value);
        createFigures.create();        
    }
    
    private void revertOrientation(boolean selected) {
        
    }
    
    private void startSimulation() {
        FigureProducerThread fpt = new FigureProducerThread();
        fpt.start();
    }
    
    private void iterruptExecution(boolean selected) {        
        RegularConstants.EXECUTE = !selected;                
    }
}
