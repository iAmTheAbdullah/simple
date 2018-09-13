package model;

import java.util.Observable;

public class Plane extends Observable {
    private Coordinates coordinates; 
    private int speed;               
    private int elevation;           
    private int elevateSeconds;      
    
    public Plane(Coordinates coordinates, int speed, int elevation) {
        this.coordinates = coordinates;
        this.speed = speed;
        this.elevation = elevation;

        elevateSeconds = 0;
    }
    
    public void movePlane() {
        // sets the y-Coordinate of this specific Plane adds the speed on top of it.
        this.setY(this.getY() + speed);
        updateElevation();
    }

    public void updateElevation() {
        /*
        * Checks if the speed of the Plane is at 10 and if is, it increments the
        * elevateSeconds by 1 so that it can elevate when reaching stability.
        */
        if (speed == 10) {
            // Increments the elevatesSeconds variable by 1.
            elevateSeconds++;
            
            /*
            * If the elevateSeconds variable had exceeded the value of 1, the value
            * for the elevation variable is incremented by 1.
            */
            if (elevateSeconds > 4) elevation++;
        }
    }

    public void resetPlane() {
        coordinates.setX(5);
        coordinates.setY(0);
        speed = 0;
        elevation = 0;
        elevateSeconds = 0;
    }

    public int getX() {
        return coordinates.getX();
    }

    public int getY() {
        return coordinates.getY();
    }

    public int getSpeed() {
        return speed;
    }

    public int getElevation() {
        return elevation;
    }

    public void setX(int x) {
        this.coordinates.setX(x);

        setChanged();
		notifyObservers("xValueChanged");
    }

    public void setY(int y) {
        this.coordinates.setY(y);
    }

    public void setSpeed(int speed) {
        this.speed = speed;

        setChanged();
		notifyObservers("speedChanged");
    }
}