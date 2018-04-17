package e8;

import java.util.ArrayList;

/**
* Range does all the computations for the Telephone App.
* It calculates the maximum range, tests is and returns it.
*
* @author Kiri Lenagh-Glue, Megan Seto, Nikolah Pearce and Megan Hayes.
*/
public class Range {
    
    private int centreX;
    private int centreY;

    private int radius;
    
    private int baseX;
    private int baseY;

    private double maxEast;
    private double maxNorth;

    private ArrayList<Telephone> phones;
    
    public Range() { }

    /**
     * Concstructor to set the range data fields.
     * @param baseX the x point for the base.
     * @param baseY the y point for the base.
     * @param phones the ArrayList of Telephones.
     */
    public Range(int baseX, int baseY, ArrayList<Telephone> phones, double maxEast, double maxNorth) {
        this.baseX = baseX;
        this.baseY=  baseY;

        // is this even needed?
        this.centreX = baseX;
        this.centreY = baseY;

        this.phones = phones;

        this.maxEast = maxEast;
        this.maxNorth = maxNorth;
        // pass to find mx now


        // Set your first radius???
        if (maxEast > maxNorth) {
            this.radius = (int) maxEast + 10;
        } else {
            this.radius = (int) maxNorth + 10;
        }
        
    }
    
    /**
     * Calculates a potential range to place the twelth phone.
     * Calls helped methods to perform all checks.
     * If the range doesn't satisy, it will make it smaller and check again.
     */
    public void calculateRange() {
        boolean numberAccepted;
        boolean rangeAccepted;

        numberAccepted = false;
        rangeAccepted = false;
        
        if (phones.size() < 12) {
            System.out.println("Infinite range - there are less than 11 phones in total.");
            return;
        }

        System.out.println("Testing range with radius: " + radius + " and x: " + centreX + " y: " + centreY);
        
        // Compute until you find an answer
        while (!rangeAccepted) {
            // make the range smaller and check again
            radius--;
            numberAccepted = checkNumberPhones();
            //
            if (numberAccepted) {
                rangeAccepted = checkRange();
            }
            
        }

        System.out.println("Found a potential range! Radius: " + radius + " and x: " + centreX + " y: " + centreY);
    }
   

    /** 
     * Checks that the potential range of the phone satisfies other locations too.
     * Moves the range and checks that never more than 11 phones are within.
     * @return true if the range never has more than 11 phones.
     */
    public boolean checkRange() {
        // move the range around to check again


        // Need to not return false, but something?
        if (centrexX > maxEast || centreY > maxNorth) {
            return false;
        }


        // when it finds > 11 phones.. Recalculate the radius based on the max of the found points?
        for (Telephone phone : phones) {
            double n = phone.getNorth();
            double e = phone.getEast();
            boolean check = pointInRange(n, e);
            ArrayList<Telephone> phonesInside = new ArrayList<Telephone>();

            if (check) {
                phonesInside.add(phone);
            }
        }
        return true;
    }

     /** 
     * Checks that range is acceptable with not too many phones in it.
     * @return true if the range has less than 11 phones.
     */
    public boolean checkNumberPhones() {
        int numPhones = numberInRange();
        if (numPhones < 12) {
            return true;
        }
        return false;
    }
    
    /**
     * Calculates the number of Telephones within a range of a given radius.
     * @return the number of phones in the range
     */
    public int numberInRange() {
        int count = 0;
        for (Telephone phone : phones) {
            double n = phone.getNorth();
            double e = phone.getEast();
            boolean check = pointInRange(n, e);
            if (check) {
                count++;
            }
            if (count > 11) {
                break;
            }
        }
        System.out.println("Number in range: " + count);
        return count;
    }

    /**
     * Takes a single point with north and east values.
     * Checks whether is falls within a range given a radius and centre points.
     * @param n the distance north of the point.
     * @param e the distance east of the point.
     * @return true if the point is within range.
     */
    public boolean pointInRange (double n, double e) {
        //If the centre of the circle is 0, easy;
        if (centreX == baseX && centreY == baseY) {
            if (n > 0) {
                if (e > 0) {
                    if (n <= radius && e <= radius) {
                        return true;
                    }
                } else {
                    if (n <= radius && (e*-1) <= radius) {
                        return true;
                    }
                }  
            } else {
                if (e > 0) {
                    if ((n*-1) <= radius && e <= radius) {
                        return true;
                    }
                } else {
                    if ((n*-1) <= radius && (e*-1) <= radius) {
                        return true;
                    }
                }
            } 
        }
        return false;
    }
   /*
    public double getMaxNorth() {
        double maxNorth = 0.0;
        for (Telephone phone : phones) {
            double north = phone.getNorth();
            if (north > maxNorth) {
                maxNorth = north;
            }
        }
        return maxNorth;
    }

    public double getMaxEast() {
        double maxEast = 0.0;
        for (Telephone phone : phones) {
            double east = phone.getEast();
            if (east > maxEast) {
                maxEast = east;
            }
        }
        return maxEast;
    }*/
    
}