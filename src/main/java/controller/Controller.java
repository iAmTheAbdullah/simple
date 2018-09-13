package controller;

import model.MainModel;
import view.MainFrame;

import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {
    private MainModel someModel;
    private MainFrame someFrame;

    public Controller (MainModel someModel, MainFrame someFrame) {
        this.someModel = someModel;
        this.someFrame = someFrame;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider someSlider = (Jslider) e.getSource();
    }
}