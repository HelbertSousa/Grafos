package grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a15026
 */
public class Dijkstra {
    static int [] predecessor = null;
    static double[] d = null;
    static List<Aresta> resp = null;
    static Queue fila = null;
    static Aresta aux = null;
    
    public Dijkstra(GrafoAbstrato g){
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            d[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }
        fila = new PriorityQueue<>();
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            for(int j = 0; j < g.getNumeroDeVertices(); j++){
                fila.offer(new Aresta(i,j,(g.getAresta(i,j))));
            }
        }   
        resp = new LinkedList<>();        
    }
    
    public static RespostaDijkBellFor dijkstra(GrafoAbstrato g, int vertice){
        RespostaDijkBellFor result = new RespostaDijkBellFor();
        
        while(fila.isEmpty()){
            aux = (Aresta) fila.poll();
            resp.add(aux);
            for(Integer v : g.getAdjacentes(aux.getOrigem())){
                relax(aux.getOrigem(), v, g.getAresta(aux.getOrigem(), v));
            }
        }  
        for(int i = 0; i < d.length; i++){
            result.peso += d[i];
        }
        
        result.resp = predecessor;
        
        return result;
    }
    
    public static void relax(int u, int v, double peso){
        if(d[u] + peso < d[v] ){
            d[v] = d[u] + peso;
            predecessor[v] = u;
        }    
    }    
}
