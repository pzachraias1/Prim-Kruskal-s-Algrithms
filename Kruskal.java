/**
 * Pete Chee Zachraias
 * 
 * The following method is going to focus more on the minimum cost. it will be adding a vector
 * base on the cost.
 */

 class Kruskal {
    Graph s, d;
    Vector [] visited;
    Vector [] unvisited;
    Edge [] minEdge;
    Edge [] e;

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

        visited = new Vector[xArray.length];
        unvisited = new Vector[xArray.length];
        minEdge = new Edge[xArray.length];
        Edge [] tempEdge = new Edge[xArray.length];
        e = new Edge[minEdge.length-1];

        for (int i = 0; i<xArray.length; i++){
            unvisited[i] = new Vector(xArray[i], yArray[i]);
        }

        for (int i = 0; i<unvisited.length; i++){
            for (int j = 0; j<unvisited.length; j++){
                if (i != j){
                    tempEdge [i] = new Edge(unvisited[i], unvisited[j]);
                    if (minEdge[i] == null){
                        minEdge[i] = tempEdge[i];
                    }
                    if ((minEdge[i].getValue() > tempEdge[i].getValue())){
                        minEdge[i] = tempEdge[i];
                    }
                }
            }
        }

        sortEdge(minEdge);
        e[0] = minEdge[0];
        int next = 1;
        for (int i =0; i < minEdge.length; i++){
            int count = 0;
            for (int j = next-1; j>=0; j--){
                if (minEdge[i].equalEdge(e[j])){
                    count ++;
                    break;
                }
            }
            if (count == 0){
                e[next] = minEdge[i];
                next++;
            }
        }
        

        for (int i = 0; i < e.length; i++){
            System.out.println(i+1 + ". Sources = " + e[i].getSource() + "\tDestination = " + 
            e[i].getDestination() + "\tDistance = " + e[i].getValue());
        }

        for (int i =0; i < e.length; i++){
            result += e[i].getValue();
        }
        
        return result;
    }

    public void sortEdge (Edge [] e){
        for (int i = 1; i<e.length; i++ ){
            Edge next = e[i];
            int j = i-1;
            while (j>=0 && next.getValue() < e[j].getValue()){
                e[j+1] = e[j];
                j--;
            }
            e[j+1] = next;
        }
    }

    public boolean equalVector (Vector v, Vector u){
        boolean result = false;

        if ((v.x == u.x) && (v.y == u.y)){
            result = true;
        }

        return result;
    }
 }