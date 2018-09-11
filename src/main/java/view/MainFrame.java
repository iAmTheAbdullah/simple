package view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Simple Airplane Simulator");

        initialiseFrame();
    }

    public void initialiseFrame() {
        // Set layout of application
        setLayout(new GridLayout(2, 1));

        // Create swing components

        // Adding the components

        // Set settings of application
        setVisible(true);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}