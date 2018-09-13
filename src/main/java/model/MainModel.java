package model;

import java.util.Observable;

public class MainModel extends Observable {
    private Plane somePlane;
    private Runaway someRunaway;
    private String planeStatus;

    public MainModel() {
        somePlane = new Plane(new Coordinates(5, 0), 0, 0);
        someRunaway = new Runaway(10, 100);
        planeStatus = "";
    }

    public void initiateSimulation(int time) {
        while (somePlane.getY() < someRunaway.getHeight()) {
            try {
                Thread.sleep(1000); // Adds a 1 second pause to the application
                displayStatus(time);
                somePlane.movePlane();

                time++;

                // if (time == 2) somePlane.setSpeed(9); // for dev testing purposes
            }
            catch (InterruptedException ex) {}
        }

        // Checks for a successful takeoff
        if (somePlane.getElevation() >= 5 && somePlane.getX() == 5) planeStatus = "Plane in air";
        else planeStatus = "Take off failed";

        setChanged();
		notifyObservers(this);
    }

    public void displayStatus(int time) {
        planeStatus = "Seconds: " + time;
        planeStatus += "\nX: " + somePlane.getX() + " Y: " + somePlane.getY() + " Speed: " + somePlane.getSpeed() + " Elevation: " + somePlane.getElevation() + "\n";
    
        setChanged();
		notifyObservers(this);
}

    public void resetSimulation(int time) {
        somePlane.resetPlane();
        initiateSimulation(time);

        setChanged();
		notifyObservers(this);
    }

    public Plane getPlane() {
        return somePlane;
    }

    public String getPlaneStatus() {
        return planeStatus;
    }

    // public static void main(String[] args) {
    //     MainModel testModel = new MainModel();

    //     testModel.initiateSimulation(0);
    // }
}