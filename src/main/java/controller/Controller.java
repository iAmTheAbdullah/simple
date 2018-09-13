package controller;

import model.MainModel;
import view.MainFrame;

import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {
    private MainModel someModel;

    public Controller (MainModel someModel) {
        this.someModel = someModel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider someSlider = (JSlider) e.getSource();

        if (someSlider.getName().equals("xAxis Slider")) {
            someModel.getPlane().setX(someSlider.getValue());
        }
        else if (someSlider.getName().equals("Speed Slider")) {
            someModel.getPlane().setSpeed(someSlider.getValue());
        }
    }
}