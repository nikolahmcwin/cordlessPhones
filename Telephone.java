/**
* Telephone class to track each phone and its position.
* @author Kiri Lenagh-Glue, Megan Seto, Nikolah Pearce and Megan Hayes.
*/

public class Telephone {

    private double north;
    private double east;

    public Telephone (double n, double e) {
        north = n;
        east = e;
    }

    public String toString() {
        return "Telephone set up with location north: " + north + " and east: " + east;
    }
}