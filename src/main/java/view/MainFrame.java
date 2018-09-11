package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
    private JTextArea planeStatements;
    private JPanel planeControlsPanel;
    private JSlider xAxisControlSlider;
    private JSlider speedControlSlider;

    public MainFrame() {
        super("Simple Airplane Simulator");

        initialiseFrame();
    }

    public void initialiseFrame() {
        // Set layout of application
        setLayout(new GridLayout(2, 1));
        planeControlsPanel = new JPanel(new BorderLayout());

        // Create swing components
        planeStatements = new JTextArea();
        xAxisControlSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        speedControlSlider = new JSlider(JSlider.VERTICAL, 0, 10, 0);

        // Adding the components
        add(planeStatements);
        add(planeControlsPanel);
        planeControlsPanel.add(xAxisControlSlider, BorderLayout.NORTH);
        planeControlsPanel.add(speedControlSlider, BorderLayout.CENTER);

        // Set settings of application
        setVisible(true);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}