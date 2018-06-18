/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author a15026
 */
public class BellmanFord {
    static double [] d = null;
    static int [] predecessor = null;
    
    public BellmanFord(GrafoAbstrato g){
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            d[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }
    }

    public boolean bellmanford(GrafoAbstrato g, int inicio){
        boolean resp = false;
        
        for(int i = 1; i < g.getNumeroDeVertices() - 1;  i++){
            for (Integer v : g.getAdjacentes(i))
        }
            
        return resp;
    }
    
    public static void relax(int u, int v, double peso){
        if(d[v] > d[u] + peso){
            d[v] = d[u] + peso;
            predecessor[v] = u;
        }    
    }
    


}