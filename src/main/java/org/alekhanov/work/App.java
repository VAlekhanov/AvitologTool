package org.alekhanov.work;

import com.formdev.flatlaf.FlatLightLaf;
import org.alekhanov.panel.WorkPanel;

import javax.swing.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        System.out.println("Hello World!");
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        WorkPanel workPanel = new WorkPanel();
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
}
