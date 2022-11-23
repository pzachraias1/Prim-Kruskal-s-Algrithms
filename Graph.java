/**
 * Pete Chee Zachraias
 * 
 * Data structure for Kruskal Algorithm. Would have implemented to Prim law but its already
 * been done when this data structre was created.
 */


import java.math.*;//importing java math to do the math

/**
 * Graph class that was not use. Just putting it here just in case of changes
 */
public class Graph {
    private Vector v;//Vector for the Graph
    private Edge e;//edge for the graph

    /**
     * constructor for the Graph Class
     * @param v Vector
     * @param e Edge
     */
    public Graph(Vector v, Edge e){
        this.v = v;//initialize vector
        this.e = e;//initialize edge
    }
    
}

/**
 * Vector class
 */
class Vector{
    double x, y;//x coordinate and y coordinate
    Vector parent;//parent vector is going to point to it parent

    /**
     * constructor for Vector class
     */
    public Vector(){
        this.x = 0.0;//initialize x
        this.y = 0.0;//initialize y
        this.parent = this;//initialize parent vector
    }

    /**
     * constructor for Vector class with parameter
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Vector (double x, double y){
        this.x = x;//initialize x
        this.y = y;//initialize y
        this.parent = this;//initialize vector parent
    }

    /**
     * set the parent vector. It is going to set it to point to its parent vector
     * @param v Vector
     */
    public void setParent (Vector v){
        this.parent = v;//set the parent vector
    }

    /**
     * get the parent vector. Whatever it is pointing to, it is going to return
     * @return return the vector that the current vector is pointing to
     */
    public Vector getParent(){
        return parent;//return the parent vector
    }
}

/**
 * Edge class
 */
class Edge{
    Vector s,d;// Source and Destination

    /*
     * constructor for the Edge Class
     */
    public Edge (){
        this.s = new Vector(0.0, 0.0);//initialize Source
        this.d = new Vector(0.0,0.0);//Initialize Destination 
    }

    /**
     * constructor for the Edge Class with parameters
     * @param s Source
     * @param d Destination
     */
    public Edge(Vector s, Vector d){
        this.s = s;//initialize Source
        this.d = d;//initialize Destination
    }

    /**
     * Getting the x and y coordinate of the Source Vector
     * @return String that formatted the X and Y coordinate of Source Vector
     */
    public String getSource(){
        return "(" + s.x + ", " + s.y + ")";//(x,y)
    }

    /**
     * Getting the x and y coordinate of Destination Vector
     * @return String formated with X and Y of Destination Vector
     */
    public String getDestination(){
        return "(" + d.x + ", " + d.y + ")"; //(x,y)
    }

    /**
     * Calcuating the distance between source and destination
     * @return distance between source and destination
     */
    public double getValue(){
        double value = 0.0;

        double difX = this.d.x - this.s.x; // taking the different of x1 and x2
        double difY = this.d.y - this.s.y; // taking the differn tof y1 and y2
        double sqrX = Math.pow(difX, 2); // taking the square of x2-x1
        double sqrY = Math.pow(difY, 2); // taking the square of y2-y1
        double com = sqrX + sqrY; // adding the square of x and square of y
        double sqrt = Math.sqrt(com); // taking the square root of com
        value = sqrt; // move sqrt to result for it to be return.

        return value;
    }

    /**
     * Check if This.Edge is the same as the pass in Edge
     * @param e edge to be compare with This.Edge
     * @return true if the edge is the same. false if they are different
     */
    public boolean equalEdge (Edge e){
        boolean result = false;

        //if this.source is equal to e.source
        //if this.destination is equal to e.destination
        //if this.source is equal to e.destinatino
        //if this.destination is equal to e.sources
        if ((this.s.equals(e.s) && this.d.equals(e.d)) || (this.s.equals(e.d) && this.d.equals(e.s))){
            result = true;
        }

        return result;
    }
}
