/**
 * Pete Chee Zachraias
 * 
 * The following method is going to focus more on the minimum cost. it will be adding a vector
 * base on the cost.
 */

 class Kruskal {
    private int [] visited;

    public Kruskal(){

    }

    /**
     * method that takes in all of the coordinate of the freckles and find the
     * minimum ink spent.
     * using the kruskal algorithm to find the minimun cost for ink spent
     * 
     * @param xArray it is the X array of the freckles
     * @param yArray it is the Y array of the freckles
     * @return a double that has the minimum ink spent.
     */
    public double kruskal(double []xArray, double [] yArray){
        double result = 0.0;

        result = 777;

        return result;
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
 }