
/**
 * Pete Chee Zachraias
 * Algorithm's coding project: using Prim and Kruskal's algorithm for finding minimum ink usage
 * for connecting all of the freckles at the back of Dick's back
 * 
 * Class Prim to going to use the Prim's algorithm to connect all of the freckles with minimum ink 
 * usage.
 */

import java.math.*;

class Prim {
    double[] visited;//array to keep track of visited vector

    /**
     * constructor for the Prim class
     */
    public Prim() {

    }

    /**
     * method that takes in all of the coordinate of the freckles and find the minimum ink spent.
     * using the prim algorithm to find the minimun cost for ink spent
     * @param xA it is the X array of the freckles
     * @param yA it is the Y array of the freckles
     * @return a double that has the minimum ink spent.
     */
    public double prim(double[] xA, double[] yA) {
        //value that is going to be the final value that is going to return. It is the 
        //total addition of all minimun cost from one freckle to another
        double result = 0.0;

        double min = 0;//placeholder for the minimum.
        double temp = 0.0;//placeholder for the difference between 2 coordinate.
        int i = 0; //index on where is currently being visited.
        int iHolder = 0; // placeholder for the potential index on to be visited.
        int count = 0; // counting the number of vector to be visited.
        visited = new double[xA.length];//set the lenght of visited array

        while (count < xA.length) { //will be looping until all vector is visited.
            //setting min to 0 to restart it. It is going to be restart to 0 as the next
            //vector is new and will need new initial min.
            min = 0;
            for (int j = 0; j < xA.length; j++) {//looping all of the coordinate until all have been visited
                //check if the current vector is not being taken different of it self
                //and to check if this vector has been visited before
                //if none of the 2 condition are true, then it will proceed and do the follow code block
                if (!hasVisited(j, visited) && !checkArray(xA[i], yA[i], xA[j], yA[j])) {
                    temp = distance(xA[i], yA[i], xA[j], yA[j]);//taking the differnt between 2 coordinate
                    //base. if vector is new, it will let the new different be the new minimum
                    if (min == 0) {
                        min = temp;//minimum = different of the first 2 vector
                        iHolder = j;//let index holder equal the current vector index.
                    } else if (temp < min) {//if temp is greater than minimum
                        min = temp;//let minimum = different or setting minimum its new value
                        iHolder = j;//placehold for index
                    }
                }
            }
            i = iHolder;//let index = its holder
            visited[count] = i; // let the current index be in the visited array. this is the index of the new minimum cost vector. it is the vector that is closes to the previous vector
            result += min;//accumlate the minimum to result
            count++;//increment count
        }
        return result;//return accumlate minimum
    }

    /**
     * to find the distance between 2 vectors
     * @param x1 x of the first coordinate
     * @param y1 y of the first coordinate
     * @param x2 x of the second coordinate
     * @param y2 y of the second coordinate
     * @return the distance between 2 coordinate
     */
    public double distance(double x1, double y1, double x2, double y2) {
        double result = 0.0;//initialize result

        double difX = x2 - x1; //taking the different of x1 and x2
        double difY = y2 - y1; //taking the differn tof y1 and y2
        double sqrX = Math.pow(difX, 2); //taking the square of x2-x1
        double sqrY = Math.pow(difY, 2); //taking the square of y2-y1
        double com = sqrX + sqrY; //adding the square of x and square of y
        double sqrt = Math.sqrt(com); // taking the square root of com
        result = sqrt; // move sqrt to result for it to be return.

        return result;
    }

    /**
     * checking if the current vector is the same as the vector that is being compare to
     * @param xi x of the index i
     * @param yi y of the index i
     * @param xj x of teh index j
     * @param yj y of the index i
     * @return return true if the vector that is being compare is the same as the current vector.
     * return false if the 2 vector are different
     */
    public boolean checkArray(double xi, double yi, double xj, double yj) {
        boolean result = false;

        //checking if the 2 vector are the same or not
        if (xi == xj && yi == yj) {
            result = true;
        }

        return result;
    }

    /**
     * checking if the current vector has been visited
     * @param num current vector
     * @param visit array of the vector that has been visited
     * @return return true if the vector has been visite before or not.
     */
    public boolean hasVisited(double num, double[] visit) {
        boolean result = false;

        //check if the vector has been visited or not.
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == num)
                result = true;
        }

        return result;
    }

}