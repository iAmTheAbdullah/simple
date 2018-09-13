package controller;

import model.MainModel;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener, ActionListener {
    private MainModel passedModel;

    public Controller (MainModel someModel) {
        passedModel = someModel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider someSlider = (JSlider) e.getSource();

        if (someSlider.getName().equals("xAxis Slider")) {
            passedModel.getPlane().setX(someSlider.getValue());
        }
        else if (someSlider.getName().equals("Speed Slider")) {
            passedModel.getPlane().setSpeed(someSlider.getValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        passedModel.resetSimulation();
    }
}