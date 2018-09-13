package view;

import model.MainModel;
import controller.Controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class MainFrame extends JFrame implements Observer {
    private JTextArea planeStatements;
    private JScrollPane planeStatementsPane;
    private JPanel planeControlsPanel;
    private JSlider xAxisControlSlider;
    private JSlider speedControlSlider;
    private JButton resetButton;
    private MainModel passedModel;
    private Controller passedController;

    public MainFrame(MainModel someModel, Controller someController) {
        super("Simple Airplane Simulator");

        passedModel = someModel;
        passedController = someController;

        initialiseFrame();
    }

    public void initialiseFrame() {
        // Set layout of application
        setLayout(new GridLayout(2, 1));
        planeControlsPanel = new JPanel(new BorderLayout());

        // Create swing components
        planeStatements = new JTextArea();
        planeStatements.setEditable(false);
        planeStatementsPane = new JScrollPane(planeStatements, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        DefaultCaret caret = (DefaultCaret) planeStatements.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        xAxisControlSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5); 
        xAxisControlSlider.setName("xAxis Slider");
        xAxisControlSlider.addChangeListener(passedController);
        speedControlSlider = new JSlider(JSlider.VERTICAL, 0, 10, 0);
        speedControlSlider.setName("Speed Slider");
        speedControlSlider.addChangeListener(passedController);
        resetButton = new JButton("Reset");
        resetButton.setName("Reset Button");

        // Adding the components
        add(planeStatementsPane);
        add(planeControlsPanel);
        planeControlsPanel.add(xAxisControlSlider, BorderLayout.NORTH);
        planeControlsPanel.add(speedControlSlider, BorderLayout.CENTER);
        planeControlsPanel.add(resetButton, BorderLayout.SOUTH);

        // Set settings of application
        pack();
        setVisible(true);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method declaration from Observer Interface
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        MainModel updateModel = (MainModel) o;
		
		// Displays the status of the plane
        planeStatements.append(updateModel.getPlaneStatus());
    }
}