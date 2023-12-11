/**
 * Represents a point in space with coordinates and orientation angles.
 * This class provides a simple abstraction for spatial coordinates in a 3D space.
 */
package base;

public class SpacePlace {
    private int xOrgin;
    private int yOrgin;
    private double theta;
    private double phi;

    public SpacePlace() {
        xOrgin = 0;
        yOrgin = 0;
    }

    public SpacePlace(double theta, double phi) {
        super();
        this.theta = theta;
        this.phi = phi;
    }

    public int getxOrgin() {
        return xOrgin;
    }

    public void setxOrgin(int xOrgin) {
        this.xOrgin = xOrgin;
    }

    public int getyOrgin() {
        return yOrgin;
    }

    public void setyOrgin(int yOrgin) {
        this.yOrgin = yOrgin;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

}
