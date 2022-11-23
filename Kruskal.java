import java.util.LinkedList;
import java.util.Queue;

/**
 * Pete Chee Zachraias
 * 
 * The following method is going to focus more on the minimum cost. it will be
 * adding a vector
 * base on the cost.
 */

class Kruskal {
    Vector[] unvisited; // taking all of the vector and put them in. keeping track of the unvisited
                        // vectors
    Edge[] minEdge; // will be holding all of the minimum edges. All of the minimum edge with no
                    // duplicate

    /**
     * Constructor for the Kruskal's Algorithm
     */
    public Kruskal() {

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
    public double kruskal(double[] xArray, double[] yArray) {
        double result = 0.0; // will be the accumulated from all minimum edges

        unvisited = new Vector[xArray.length];// initialize unvisited array vector
        minEdge = new Edge[xArray.length - 1]; // initialize minimum edge array. it is minus 1 because edge is 1 less
                                               // than vector
        Edge[] tempEdge = new Edge[xArray.length * (xArray.length - 1)]; // temporary array that will take all of the
                                                                         // edge from each array

        // adding all of the vector into unisited vectors
        for (int i = 0; i < xArray.length; i++) {
            unvisited[i] = new Vector(xArray[i], yArray[i]);
            unvisited[i].parent = unvisited[i];
        }

        int count = 0;// count the number of tempEdge.
        // putting all possible source to destination into Temp edge.
        for (int i = 0; i < unvisited.length; i++) {// source loop
            for (int j = 0; j < unvisited.length; j++) {// destination loop
                if (i != j) {// make sure that the source is the not same as teh destination
                    tempEdge[count] = new Edge(unvisited[i], unvisited[j]);// creating a new temp edge with j and i
                    count++;// keeping track of the next element in the array.
                }
            }
        }

        sortEdge(tempEdge);// sorting all of the edge from least to greatest distance

        // ----------------------Kruskal's Algorithm re-implementation-----------------------
        Queue<Edge> q = new LinkedList<>();//using queue to get the lowest cost weight and make its way to the last
        for (int i = 0; i < tempEdge.length; i++) {//adding all sorted x array to the queue
            q.add(tempEdge[i]);
        }

        int index = 0;//index is going to the size of the edge array. also index point to where to add next edge
        while (index < xArray.length - 1) {//loop until index is at the end of the edge array (E=V-1)
            Edge e = q.remove();//get the first edge in the queue
            
            Vector a = find(e.s);//going to find the root parent vector of the source vector
            Vector b = find(e.d);//going to find the root parent of the destination vector
            if (!a.equals(b)){//if parent of a and b is not the same, it is going to add edge to the mini edge array
                minEdge[index] = e;
                index++;//increment the index. point to the next place to add next acyclic coordinate
                merge(a, b);//combine the two vector
            }
        }
        // -----------------------end re-implementation--------------------------------------

        System.out.println();//spacing
        printEdge(minEdge);// printing the minEdge array. It is a void method

        //getting the accumlative of all minEdge distance
        for (int i = 0; i < minEdge.length; i++) {
        result += minEdge[i].getValue();
        }

        return result;// return the total minimum ink spent
    }

    /**
     * It is going to find the parent of the vector
     * @param v Vector
     * @return the parent of the vector
     */
    public Vector find(Vector v) {
        if (!v.parent.equals(v)) {//it is going to loop untied it reaches its root parent
            return find(v.parent);//recursion loop
        }
        return v;//return the root parent
    }

    /**
     * going to merge the 2 vector. it is going to get the parent of vector a and let that be the new parent for b
     * @param a Vector 1
     * @param b Vector 2
     */
    public void merge(Vector a, Vector b) {
        Vector parent_a = find(a);//find the parent for a
        Vector parent_b = find(b);//find the parent for b
        parent_b.parent = parent_a;//let a be the parent for b
    }

    /**
     * Method to print the Edge array
     * 
     * @param ei any edge array that is being pass.
     */
    public void printEdge(Edge[] ei) {
        for (int i = 0; i < ei.length; i++) {// looping through the given edge array
            System.out.println(i + 1 + ". Sources = " + ei[i].getSource() + "\tDestination = " +
                    ei[i].getDestination() + "\tDistance = " + ei[i].getValue());
        }
    }

    /**
     * Using insertion sort to do the sorting of the edge array. the sorting is base
     * on the
     * distance between source and destination
     * 
     * @param e any given or pass in edge array
     */
    public void sortEdge(Edge[] e) {
        for (int i = 1; i < e.length; i++) {// looping through the unsorted part of the array
            Edge next = e[i];// initialize the first unsorted element
            int j = i - 1;// last element of the sorted array
            // looping through the sorted array and trying to place the unsorted array at
            // end the while loop if the unsorted element is greater than the sorted array
            // and if unsorted element reached the end of the sorted array
            while (j >= 0 && next.getValue() < e[j].getValue()) {
                e[j + 1] = e[j];// placing the unsorted array in the correct spot
                j--;// decrement index of the sorted array
            }
            e[j + 1] = next;// put the unsorted element at the start of the sorted array
        }
    }
}