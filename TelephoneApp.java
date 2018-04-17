package e8;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cordless Telephones Group Etude 8.
 *
 * @author Kiri Lenagh-Glue, Megan Seto, Nikolah Pearce and Megan Hayes.
 */

 public class TelephoneApp {

    /** ArrayList of all telephones that are added  */
    private static ArrayList<Telephone> phones = new ArrayList<Telephone>();

    private static double maxEast = 0;
    private static double maxNorth = 0;

    /**
     * Main calls everything that is sick brah.
     * @param args any commmand line arguments.
     */
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!(line.equals("Telephone sites"))) {
                double[] input = new double[2];
                String[] lineArray = line.split(" ");

                // Convert each string input to a double, else output to StdErr
                for (int i = 0; i < input.length; i++) {
                    try {
                        input[i] = Double.parseDouble(lineArray[i]);
                    } catch (NumberFormatException e) {
                        System.err.println("Input lines should be in the format '12.3 12.3' etc");
                    }
                }

                // Call the constructor to set up this telephone
                Telephone phone = new Telephone(input[0], input[1]);

                // Add the phone to the ArrayList
                phones.add(phone);
            }
        }

        // Finish set up and print out that we have set up
        for (Telephone phone : phones) {

            double east = phone.getEast();
            double north = phone.getNorth();

            // Set the two static maximum variables
            if (east > maxEast) {
                maxEast = east;
            }
            if (north > maxNorth) {
                maxNorth = north;
            }
            System.out.println(phone.toString());
        }

        Range rangeChecker = new Range(0 ,0, phones, maxEast, maxNorth);
        rangeChecker.calculateRange();

    }


 }
