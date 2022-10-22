/**
 * Pete Chee Zachraias
 * Algorithm's coding project: using Prim and Kruskal's algorithm for finding minimum ink usage
 * for connecting all of the freckles at the back of Dick's back
 * 
 * Class Prim to going to use the Prim's algorithm to connect all of the freckles with minimum ink 
 * usage.
 */

 class Prim{
    double x, y;
    double [] xArray;
    double [] yArray;
    double [] visited;


    public Prim(){
        this.x = 0;
        this.y = 0;
    }

    public Prim(double x, double y, double[]xArray, double [] yArray){
        this.x = x;
        this.y = y;
        for (int i = 0; i<xArray.length; i++){
            this.xArray [i] = xArray[i];
        }
        for (int i = 0; i<yArray.length; i++){
            this.xArray [i] = yArray[i];
        }
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setArray_X (double [] array){
        this.xArray = array;
    }

    public void setArray_Y (double [] array){
        this.yArray = array;
    }
    
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double[] getArray_X (){
        return xArray;
    }

    public double[] getArray_Y (){
        return yArray;
    }

    
 }