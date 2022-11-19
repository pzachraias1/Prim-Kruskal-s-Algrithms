
/**
 * Pete Chee Zachraias
 * Algorithm's coding project: using Prim and Kruskal's algorithm for finding minimum ink usage
 * for connecting all of the freckles at the back of Dick's back
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.nio.file.*;

class main {
    public static void main(String[] arg) {
        // int numFreckle = 0; // the number of freckle at the back of Dick
        // int numTest = 0; // number of test case
        Scanner input = new Scanner(System.in); // Scanner object that will handle the input of the user
        BufferedReader reader;
        double[] xArray = { 1.0, 2.0, 2.0 };
        double[] yArray = { 1.0, 2.0, 4.0 };
        int counter = 0;
        String s = "";

        // test to see the end result
        for (int i = 0; i < xArray.length; i++) {
            System.out.print(i + ". ");
            System.out.printf("(%.2f, %.2f)\n", xArray[i], yArray[i]);
        }
        System.out.println("");

        // ---------------------Prim's Algorithm----------------------------
        System.out.println("-------------------------PRIM---------------------------");
        Prim prim = new Prim(); // create Prim object
        double p = prim.prim(xArray, yArray);// using the data from xArray and yArray to find the minimum ink spent
        System.out.printf("Prim = %.2f\n", p);// format the display
        System.out.println();// create space for formatting

        // ---------------------Kruskal's Algorithm----------------------------
        System.out.println("-------------------------Kruskal---------------------------");
        Kruskal krus = new Kruskal();
        double k = krus.kruskal(xArray, yArray);
        System.out.printf("Kruskal = %.2f\n", k);// format the display

        // ----------------------------------Input
        // option--------------------------------
        // Random ran = new Random(); // random object that will generate random number
        // System.out.print("Please enter the number of test: "); // display a prompt
        // that is going to take the number of
        // String temp = input.nextLine(); // temporary that is going to take the input
        // of the user and pass it to a method
        // numTest = intCheckTest(temp);// pass in string to the method and return an
        // integer. it check if the string is
        // // integer or not.
        // System.out.print("\nEnter a number of FRECKLES: ");// display a prompt for a
        // number of freckles
        // // integer validation. there is no way for a double or string to be number of
        // // freckles
        // while (!input.hasNextInt()) {
        // System.out.print("Please enter a positive integer: ");
        // input.next();
        // }
        // numFreckle = input.nextInt(); // take the input and store it inside
        // numFreckles

        // double[] xArray = new double[numFreckle];// array that holds all x-axis value
        // double[] yArray = new double[numFreckle];// array that holds all y-axis value

        // generating different number of x and y. between 0 and 100 as the plane
        /*
         * for (int i = 0; i < numFreckle; i++) {
         * x = (double) ran.nextInt(101) + ran.nextDouble();
         * y = (double) ran.nextInt(101) + ran.nextDouble();
         * 
         * // loop around if there exist a coordinate in the array.
         * while (checkArray(xArray, yArray, x, y)) {
         * x = (double) ran.nextInt(101) + ran.nextDouble();
         * y = (double) ran.nextInt(101) + ran.nextDouble();
         * }
         * 
         * xArray[i] = x; // storing random x to x[index] array
         * yArray[i] = y; // storing random y to y[index] array
         * }
         */
        // ------------------------------------end of input
        // option------------------------

        // ----------------------------------File reader------------------------------
        try {
            reader = new BufferedReader(new FileReader("test_case.txt"));
            String line = reader.readLine();
            while (line != null) {
                s = line;
                if (s.length() == 0) {
                    System.out.println();
                    for (int i = 0; i < xArray.length; i++) {
                        System.out.print(i + ". ");
                        System.out.printf("(%.2f, %.2f)\n", xArray[i], yArray[i]);
                    }
                    System.out.println("");

                    // ---------------------Prim's Algorithm----------------------------
                    System.out.println("-------------------------PRIM---------------------------");
                    prim = new Prim(); // create Prim object
                    p = prim.prim(xArray, yArray);// using the data from xArray and yArray to find the minimum ink spent
                    System.out.printf("Pim = %.2f\n", p);// format the display
                    System.out.println();// create space for formatting

                    // ---------------------Kruskal's Algorithm----------------------------
                    System.out.println("-------------------------Kruskal---------------------------");
                    krus = new Kruskal();
                    k = krus.kruskal(xArray, yArray);
                    System.out.printf("Kruskal = %.2f\n", k);// format the display
                    line = reader.readLine();
                }

                if (s.length() < 5) {
                    s = line;
                    int num = Integer.parseInt(s);
                    xArray = new double[num];
                    yArray = new double[num];
                    counter = 0;
                    line = reader.readLine();
                }

                if (s.length() >= 5) {
                    double x = 0, y = 0;
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        char space = ' ';
                        if (c == space) {
                            String xString = s.substring(0, i);
                            String yString = s.substring(i + 1, s.length());
                            x = Double.parseDouble(xString);
                            y = Double.parseDouble(yString);
                            xArray[counter] = x;
                            yArray[counter] = y;
                            counter++;
                            line = reader.readLine();
                            break;
                        }
                    }
                }

            }
            System.out.println();
            for (int i = 0; i < xArray.length; i++) {
                System.out.println(xArray[i] + ", " + yArray[i]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ----------------------------------End of File Reader-----------------------

        System.out.println();
        // test to see the end result
        for (int i = 0; i < xArray.length; i++) {
            System.out.print(i + ". ");
            System.out.printf("(%.2f, %.2f)\n", xArray[i], yArray[i]);
        }
        System.out.println("");

        // ---------------------Prim's Algorithm----------------------------
        System.out.println("-------------------------PRIM---------------------------");
        prim = new Prim(); // create Prim object
        p = prim.prim(xArray, yArray);// using the data from xArray and yArray to find the minimum ink spent
        System.out.printf("Prim = %.2f\n", p);// format the display
        System.out.println();// create space for formatting

        // ---------------------Kruskal's Algorithm----------------------------
        System.out.println("-------------------------Kruskal---------------------------");
        krus = new Kruskal();
        k = krus.kruskal(xArray, yArray);
        System.out.printf("Kruskal = %.2f\n", k);// format the display

        input.close();

    }

    /**
     * This method is going to check if the random generate coordinate is already
     * been enter.
     * to make sure that all freckle are at different coordinate. There is no way
     * for a freckle
     * to overlap each other.
     * 
     * @param xArray passing the x array
     * @param yArray passing the y array
     * @param x      the random x value
     * @param y      the random y value
     * @return return true if there exist already a coordinate in the array. Return
     *         false if not
     */
    public static boolean checkArray(double[] xArray, double[] yArray, double x, double y) {
        boolean check = false;

        for (int i = 0; i < xArray.length; i++) {
            if (x == xArray[i] && y == yArray[i]) {
                return check = true;
            }
        }
        return check;
    }

    /**
     * it is going to parse the input into integer and check if integer is between 1
     * and 100
     * 
     * @param s input from the user.
     * @return integer that has been parse from the input string
     */
    public static int intCheckTest(String s) {
        int num = 0; // initialize number to 0
        Scanner input = new Scanner(System.in); // scanner

        // if the input is an integer, it is going to parse it
        if (checkInt(s)) {
            num = Integer.parseInt(s);
        }

        // loop around when input is not a integer or if the parse input integer is
        // greater than 100
        while (!checkInt(s) || num > 100) {
            System.out.print("Please enter an integer between 1 and 100: ");
            s = input.next();

            // if parseable, parse it to integer
            if (checkInt(s)) {
                num = Integer.parseInt(s);
            }
        }
        return num; // return the parse integer
    }

    /**
     * It is going to check if the input is integer or not
     * 
     * @param s input from the user
     * @return boolean. If input is integer, return true. If input is not, return
     *         false
     */
    public static boolean checkInt(String s) {
        boolean check = true; // initialize boolean to false

        // base case if input is enter as nothing. return false
        if (s == null) {
            check = false;
        }

        try {
            int num = Integer.parseInt(s); // if input is integer, it will conserve boolean as true
        } catch (NumberFormatException nfe) {
            // when the Integer.parseInt false, it will throw except and will change boolean
            // to false
            // as the input is not integer
            check = false;
        }

        return check;
    }
}