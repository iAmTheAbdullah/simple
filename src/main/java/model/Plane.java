package model;

public class Plane {
    // These variables are the characteristics of a Plane
    private Coordinates coordinates; // contains the coordinates of a Plane as a set of Coordinates 
    private int speed;               // contains the speed of a Plane as an integer value
    private int elevation;           // contains the level of elevation of a Plane as an integer value
    private int elevateSeconds;      // contains the time break when the Plane is at speed(10) 
    
    /* 
    * This method is the constructor of the Plane which allows almost all 
    * of the attributes of a Plane to be assigned a value, except for
    * the elevateSeconds variable.
    */
    public Plane(Coordinates coordinates, int speed, int elevation) {
        this.coordinates = coordinates;
        this.speed = speed;
        this.elevation = elevation;
    }
    
    /*
    * This method moves the Plane by incrementing the y-Coordinate of
    * the Plane with the speed.
    */
    public void movePlane() {
        // sets the y-Coordinate of this specific Plane adds the speed on top of it.
        this.setY(this.getY() + speed);
    }

    /*
    * This method causes the Plane to elevate when the speed of the Plane is at 10.
    */
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
            if (elevateSeconds > 4) {
                elevation++;
            }
        }
    }

    // This method allows the x coordinate of a Plane to be returned as an integer value.
    public int getX() {
        return coordinates.getX();
    }

    // This method allows the y coordinate of a Plane to be returned as an integer value.
    public int getY() {
        return coordinates.getY();
    }

    // This method allows the speed of a Plane to be returned as an integer value.
    public int getSpeed() {
        return speed;
    }

    // This method allows the point of elevation of a Plane to be returned as an integer value.
    public int getElevation() {
        return elevation;
    }

    // This method allows the x coordinate of a Plane to be assigned an integer value.
    public void setX(int x) {
        this.coordinates.setX(x);
    }

    // This method allows the y coordinate of a Plane to be assigned an integer value.
    public void setY(int y) {
        this.coordinates.setY(y);
    }

    // This method allows speed of a Plane to be assigned an integer value.
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // This method allows the elevation of a Plane to be assigned an integer value.
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
    
    // This method allows the counter variable of the elevation of a Plane to be assigned an integer value.
    public void setElevateSeconds(int elevateSeconds) {
        this.elevateSeconds = elevateSeconds;
    }