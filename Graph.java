import java.math.*;

public class Graph {
    private Vector v;
    private Edge e;

    public Graph(Vector v, Edge e){
        this.v = v;
        this.e = e;
    }
    
}

class Vector{
    double x, y;

    public Vector(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Vector (double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Edge{
    Vector s,d;
    Edge e;

    public Edge (){
        this.s = new Vector(0.0, 0.0);
        this.d = new Vector(0.0,0.0);
    }

    public Edge(Vector s, Vector d){
        this.s = s;
        this.d = d;
    }

    public String getSource(){
        return "(" + s.x + ", " + s.y + ")";
    }

    public String getDestination(){
        return "(" + d.x + ", " + d.y + ")";
    }

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

    public boolean equalEdge (Edge e){
        boolean result = false;

        if ((this.s.equals(e.s) && this.d.equals(e.d)) || (this.s.equals(e.d) && this.d.equals(e.s))){
            result = true;
        }

        return result;
    }
}
