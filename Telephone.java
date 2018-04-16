package telephone;


/**
* Telephone panel class to draw each phone at its position.
* Also draws a base point and labels this.
*
* @author Kiri Lenagh-Glue, Megan Seto, Nikolah Pearce and Megan Hayes.
*/

public class Telephone {

    private double north;
    private double east;
    
    private int x;
    private int y;

    public Telephone() { }
    
    public Telephone (double n, double e) {
        north = n;
        east = e;
        x = (int) east;
        y = (int) north;
    }

    public double getNorth() {
        return north;
    }

    public double getEast() {
        return east;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public String toString() {
        return "Telephone set up with location north: " + north + " and east: " + east;
    }

}
