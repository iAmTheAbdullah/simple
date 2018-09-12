package model;

import java.util.Observable;

public class MainModel extends Observable {
    private Plane somePlane;
    private Runaway someRunaway;

    public MainModel() {
        somePlane = new Plane(new Coordinates(5, 0), 0, 0);
        someRunaway = new Runaway(10, 100);
    }
}