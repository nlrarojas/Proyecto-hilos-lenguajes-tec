package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InitInterfaceAndThreads implements Runnable {
    private JTextField txtSpeed;
    private JTextField txtValue;
    private JTextField txtCarriles;
    private JPanel menuPanel;
    
    private static final int DRAWING_WIDTH = 600;
    private static final int DRAWING_HEIGTH = 600;
    private static final int NUMGAMEOBJECTS = 30;
    private boolean runningThread;
    
    private Figure[] gameObjectsArray = new Figure[NUMGAMEOBJECTS];
    private MoveFigureThread[] moveObjectArray = new MoveFigureThread[NUMGAMEOBJECTS];

    private JFrame frame;
    private FiguresPanel movingPanel;
    private PanelRepaint panelRepaint;
    private int sleepThreadTime;
    private int sleepTimePaint;

    //constructor
    public InitInterfaceAndThreads() {
        this.sleepThreadTime = 10;
        this.sleepTimePaint = 20;
        this.runningThread = true;
        
        for (int i = 0; i < gameObjectsArray.length; i++) {
            gameObjectsArray[i] = new Figure(DRAWING_WIDTH, DRAWING_HEIGTH);
            moveObjectArray[i] = new MoveFigureThread(gameObjectsArray[i], 
                                                    sleepThreadTime, 
                                                    "Thread " + i,
                                                    this.runningThread);
        }//end for
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void run() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Moving Figures with different threads!");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(new Dimension(1200, 800));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        
        movingPanel = new FiguresPanel(gameObjectsArray, DRAWING_WIDTH, DRAWING_HEIGTH);
        frame.getContentPane().add(movingPanel).setBounds(0, 0, DRAWING_WIDTH * 2, DRAWING_HEIGTH + 20);

        txtSpeed = new JTextField();
        txtSpeed.setText("Speed");
        txtSpeed.setBounds(293, 11, 86, 20);
        menuPanel.add(txtSpeed);
        txtSpeed.setColumns(10);

        txtValue = new JTextField();
        txtValue.setText("Value");
        txtValue.setBounds(197, 11, 86, 20);
        menuPanel.add(txtValue);
        txtValue.setColumns(10);

        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnCreate.setBounds(197, 41, 182, 23);
        menuPanel.add(btnCreate);

        txtCarriles = new JTextField();
        txtCarriles.setText("Carriles");
        txtCarriles.setBounds(464, 42, 67, 20);
        menuPanel.add(txtCarriles);
        txtCarriles.setColumns(10);

        JButton btnBarrier = new JButton("Barrier");
        btnBarrier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBarrier.setBounds(464, 10, 89, 23);
        menuPanel.add(btnBarrier);

        JButton btnRevert = new JButton("Revert");
        btnRevert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRevert.setBounds(628, 10, 120, 23);
        menuPanel.add(btnRevert);

        JButton btnSimulation = new JButton("Simulation");
        btnSimulation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSimulation.setBounds(628, 41, 120, 23);
        menuPanel.add(btnSimulation);

        JButton btnInterrupt = new JButton("Interrupt");
        btnInterrupt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInterrupt.setBounds(819, 10, 100, 54);
        menuPanel.add(btnInterrupt);
        
        
        frame.getContentPane().add(menuPanel).setBounds(50, DRAWING_HEIGTH + 75, 1000, 150);
        //frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        //START THREADS
        for (MoveFigureThread myCurrentThread : moveObjectArray) {
            new Thread(myCurrentThread).start();
        } //end for
        panelRepaint = new PanelRepaint(this, this.sleepTimePaint, this.runningThread);
        new Thread(panelRepaint).start();
    }

    private void exitProcedure() {
        this.runningThread = false;
        panelRepaint.setRunning(false);
        frame.dispose();
        System.exit(0);
    }

    public void repaintMovingPanel() {
        movingPanel.repaint();
    }

}
