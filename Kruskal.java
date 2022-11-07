import java.io.LineNumberInputStream;
import java.util.concurrent.TimeoutException;

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
    Edge[] minEdge; // will be holding all of the minimum edges. All of the minimum edge with no duplicate

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
        minEdge = new Edge[xArray.length - 1]; // initialize minimum edge array
        Edge[] tempEdge = new Edge[xArray.length * (xArray.length - 1)]; // temporary array that will take all of the
                                                                         // edge from each array

        for (int i = 0; i < xArray.length; i++) {
            unvisited[i] = new Vector(xArray[i], yArray[i]);
        }

        int count = 0;
        for (int i = 0; i < unvisited.length; i++) {
            for (int j = 0; j < unvisited.length; j++) {
                if (i != j) {
                    tempEdge[count] = new Edge(unvisited[i], unvisited[j]);
                    count++;
                }
            }
        }

        sortEdge(tempEdge);

        count = 0;
        int next = 0;
        while (count < tempEdge.length) {
            if (minEdge[0] == null) {
                minEdge[0] = tempEdge[0];
                next++;
            } else {
                int dup = 0;
                for (int i = next - 1; i >= 0; i--) {
                    if (minEdge[i].equalEdge(tempEdge[count])) {
                        dup++;
                    }
                }
                if (dup == 0) {
                    minEdge[next] = tempEdge[count];
                    next++;
                }
                if (next == minEdge.length) {
                    break;
                }
            }
            count++;
        }

        printEdge(minEdge);

        for (int i = 0; i < minEdge.length; i++) {
            result += minEdge[i].getValue();
        }

        return result;
    }

    public void printEdge(Edge[] ei) {
        for (int i = 0; i < ei.length; i++) {
            System.out.println(i + 1 + ". Sources = " + ei[i].getSource() + "\tDestination = " +
                    ei[i].getDestination() + "\tDistance = " + ei[i].getValue());
        }
    }

    public void sortEdge(Edge[] e) {
        for (int i = 1; i < e.length; i++) {
            Edge next = e[i];
            int j = i - 1;
            while (j >= 0 && next.getValue() < e[j].getValue()) {
                e[j + 1] = e[j];
                j--;
            }
            e[j + 1] = next;
        }
    }

    public boolean equalVector(Vector v, Vector u) {
        boolean result = false;

        if ((v.x == u.x) && (v.y == u.y)) {
            result = true;
        }

        return result;
    }
}