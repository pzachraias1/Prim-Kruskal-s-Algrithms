/**
 * Pete Chee Zachraias
 * Algorithm's coding project: using Prim and Kruskal's algorithm for finding minimum ink usage
 * for connecting all of the freckles at the back of Dick's back
 * 
 * Class Prim to going to use the Prim's algorithm to connect all of the freckles with minimum ink 
 * usage.
 */

import java.math.*; //importing math class to use
import java.util.*;

class Prim {
    int[] visited;// array to keep track of visited vector

    /**
     * constructor for the Prim class
     */
    public Prim() {

    }

    /**
     * method that takes in all of the coordinate of the freckles and find the
     * minimum ink spent.
     * using the prim algorithm to find the minimun cost for ink spent
     * 
     * @param xA it is the X array of the freckles
     * @param yA it is the Y array of the freckles
     * @return a double that has the minimum ink spent.
     */
    public double prim(double[] xA, double[] yA) {

        double result = 0.0; // initialize the result
        visited = new int[xA.length]; // set the lenght of visited and initialize it
        Random ran = new Random();// create an object for random method. it is going to generate a random start
                                  // point for the prim algorithms

        double min = 0, temp; // initialize minimum to store minimum value in it and declare temporary
        int curr = ran.nextInt(xA.length);// randomly generate a vector to start with. Where in the given coordinate to
                                          // start with
        // it is going to take the index of the vector that has the closest distance to
        // the current
        // index.
        int minIndex = 0;
        visited[0] = curr;// let the start index or vector be in the visited array. since we are starting
                          // with it, we are adding it to the visited array

        // it is going to loop starting from the next index in the visited array
        for (int i = 1; i < visited.length; i++) {
            if (visited == null) {// base case if visited array is nothing.
                return result = 0.0;
            } else { // if the visited array has value or initial vector in it already
                     // it is going to loop to until it reached the next index of the visited array.
                for (int j = 0; j < i; j++) {
                    int currValue = visited[j]; // take a vector from the visited
                    // it is going to loop around all of the vectors or coordinate
                    for (int c = 0; c < xA.length; c++) {
                        // To check if the coordinate to be compare with is not the same thing
                        // and check if the coordinate is already inside the visited array
                        if (!hasVisited(c, i - 1) && !checkArray(xA[currValue], yA[currValue], xA[c], yA[c])) {
                            temp = distance(xA[currValue], yA[currValue], xA[c], yA[c]);// taking the distance between
                                                                                        // coordinate
                            if (min == 0 || min > temp) {// if minimum is bigger or if minimum is 0
                                min = temp;// let minimum = temp or the distance
                                minIndex = c;// take the vector of the smaller route to from the current vectors
                            }
                        }
                    }

                }
                result += min;// accumlate the result with all of the minimum route
                min = 0;// reinitialize minimum since we have already got the minimum. now we start over
                        // to find the next minimum cost of ink
                visited[i] = minIndex;// the minimum index will be in the visited array
            }
        }
        System.out.print("\n[");
        for (int i = 0; i < xA.length; i++) {
            if (i == xA.length - 1) {
                System.out.print(visited[i]);
            } else {
                System.out.print(visited[i] + ", ");
            }
        }
        System.out.println("]");
        return result;// return accumlate minimum
    }

    /**
     * to find the distance between 2 vectors
     * 
     * @param x1 x of the first coordinate
     * @param y1 y of the first coordinate
     * @param x2 x of the second coordinate
     * @param y2 y of the second coordinate
     * @return the distance between 2 coordinate
     */
    public double distance(double x1, double y1, double x2, double y2) {
        double result = 0.0;// initialize result

        double difX = x2 - x1; // taking the different of x1 and x2
        double difY = y2 - y1; // taking the differn tof y1 and y2
        double sqrX = Math.pow(difX, 2); // taking the square of x2-x1
        double sqrY = Math.pow(difY, 2); // taking the square of y2-y1
        double com = sqrX + sqrY; // adding the square of x and square of y
        double sqrt = Math.sqrt(com); // taking the square root of com
        result = sqrt; // move sqrt to result for it to be return.

        return result;
    }

    /**
     * checking if the current vector is the same as the vector that is being
     * compare to
     * 
     * @param xi x of the index i
     * @param yi y of the index i
     * @param xj x of teh index j
     * @param yj y of the index i
     * @return return true if the vector that is being compare is the same as the
     *         current vector.
     *         return false if the 2 vector are different
     */
    public boolean checkArray(double xi, double yi, double xj, double yj) {
        boolean result = false;

        // checking if the 2 vector are the same or not
        if (xi == xj && yi == yj) {
            result = true;
        }

        return result;
    }

    /**
     * checking if the current vector has been visited
     * 
     * @param num   current vector
     * @param visit array of the vector that has been visited
     * @return return true if the vector has been visite before or not.
     */
    public boolean hasVisited(double num, int index) {
        boolean result = false;

        // check if the vector has been visited or not.
        for (int i = index; i >= 0; i--) {
            if (visited[i] == num)
                result = true;
        }

        return result;
    }

}