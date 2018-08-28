package main;

import javax.swing.SwingUtilities;

import main.InitInterfaceAndThreads;

/**
 *
 * @author root
 */

public class SimulationMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new InitInterfaceAndThreads());
    }    
}
