/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Arrays;

/**
 *
 * @author a15026
 */
public class BellmanFord {
    static double [] d = null;
    static int [] predecessor = null;
    
    public BellmanFord(GrafoAbstrato g){
        d = new double[g.getNumeroArestas()];
        predecessor = new int[g.getNumeroDeVertices()];
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            d[i] = Double.MAX_VALUE;
            predecessor[i] = -1;
        }
    }

    public static RespostaDijkBellFor bellmanford(GrafoAbstrato g, int inicio){
        RespostaDijkBellFor result = new RespostaDijkBellFor();
        predecessor[inicio] = 0;
        for(int i = 1; i < g.getNumeroDeVertices() - 1;  i++){
            for (Integer v : g.getAdjacentes(i)){
                relax(i,v, g.getAresta(i, v));
            }
        }
        
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            for(int v = 0; v < g.getNumeroArestas(); v++)
                if(d[v] > d[u] + g.getAresta(u, v)){
                    break;
                }  
        }
        for(int i = 0; i < d.length; i++){
            result.peso += d[i];
        }
        result.resp = predecessor;
        
        return result;
    }
    
    public static void relax(int u, int v, double peso){
        if(d[u] + peso < d[v]){
            d[v] = d[u] + peso;
            predecessor[v] = u;
        }    
    }
}