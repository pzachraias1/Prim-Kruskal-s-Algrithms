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
    Vector[] visited;

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

        visited = new Vector[xArray.length];
        unvisited = new Vector[xArray.length];// initialize unvisited array vector
        minEdge = new Edge[xArray.length - 1]; // initialize minimum edge array. it is minus 1 because edge is 1 less
                                               // than vector
        Edge[] tempEdge = new Edge[xArray.length * (xArray.length - 1)]; // temporary array that will take all of the
                                                                         // edge from each array

        // adding all of the vector into unisited vectors
        for (int i = 0; i < xArray.length; i++) {
            unvisited[i] = new Vector(xArray[i], yArray[i]);
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
        int nextVisited = 0;//point to the next slot in the visite array
        count = 0;// reintialize count to keep track of temp edge element.
        int next = 0; // keeping track of the minEdge element. When is the next element and so on
        // loop through the tempEdge array.
        while (count < tempEdge.length) {
            int caseVector = 0;//case 1: non of the source and destination is in the visited array
                                //case 2: source vector is visited but destination is not
                                //case 3: destination vector is visited but source is not
            if (minEdge[0] == null) {// if the minEdge first element is nothing. let it equal first element of temp
                minEdge[0] = tempEdge[0];// letting first element of min equal temp first element
                visited[nextVisited] = minEdge[0].s;//adding the source vector to the visited array
                nextVisited++;//point to the next slot in visited array
                visited[nextVisited] = minEdge[0].d;//add the destination vector to the visited array
                nextVisited++;//point to the next slot in the visited array
                next++;// set the next element to the next index
            } else {// if minEdge first element is not null
                int dup = 0;// counting the number of duplicate
                for (int i = next - 1; i >= 0; i--) {// looping throught the minEdge to compare with Temp
                    if (minEdge[i].equalEdge(tempEdge[count])) {// if there is a duplicate
                        dup++;// keep track that there is a duplicate
                    } else {
                        int sourceCounter = 0;// 0 if source has not been visited. 1 if source was visited
                        int desCounter = 0;// 0 if destination has not been visited. 1 if destination was visited
                        for (int j = 0; j < nextVisited; j++) {//loop through the visited array.
                            //check if tempEdge source has been visited
                            if (tempEdge[count].s.equals(visited[j])) {
                                sourceCounter++;//increment if visited
                            }
                            //check if tempEdge destination has been visited
                            if (tempEdge[count].d.equals(visited[j])) {
                                desCounter++;//increment if visited
                            }
                        }
                        //case 1 if both source and destination has not been visited
                        if (sourceCounter == 0 && desCounter == 0) {
                            caseVector = 1;
                        }
                        //case 2 if sources is visited but destination is not
                        if (sourceCounter == 1 && desCounter == 0) {
                            caseVector = 2;
                        }
                        //case 3 if destination is visited but source has not
                        if (sourceCounter == 0 && desCounter == 1) {
                            caseVector = 3;
                        }
                    }
                }
                if (dup == 0) {// if there is no duplicate, let minEdge index equal temp index
                    //case 1 is going to run
                    if (caseVector == 1) {
                        minEdge[next] = tempEdge[count];// letting element of min and temp equal
                        visited[nextVisited] = minEdge[next].s;//adding minEdge source to visited array
                        nextVisited++;//point to the next visited array slot
                        visited[nextVisited] = minEdge[next].d;//adding minEdge destination to the visited array
                        nextVisited++;//point to the next visited array slot
                        next++;// point to the next slot in min array to be fill in.
                    }
                    //case 2 will run
                    if (caseVector == 2) {
                        minEdge[next] = tempEdge[count];// letting element of min and temp equal
                        visited[nextVisited] = minEdge[next].d;//adding the minEdge destination to the visited array
                        nextVisited++;//point to the next slot in the visited array
                        next++;// point to the next slot in min array to be fill in.
                    }
                    //case 3 will run
                    if (caseVector == 3) {
                        minEdge[next] = tempEdge[count];// letting element of min and temp equal
                        visited[nextVisited] = minEdge[next].s;//adding the minEdge source to the visited array
                        nextVisited++;//point to the next slot in the visited array
                        next++;// point to the next slot in min array to be fill in.
                    }
                }
                if (next == minEdge.length) {// if there is no more slot in minEdge, break
                    break;// break out of the while loop
                }
            }
            count++;// the next temp element to be compare with minEdge array
        }

        printEdge(minEdge);// printing the minEdge array. It is a void method

        // getting the accumlative of all minEdge distance
        for (int i = 0; i < minEdge.length; i++) {
            result += minEdge[i].getValue();
        }

        return result;// return the total minimum ink spent
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