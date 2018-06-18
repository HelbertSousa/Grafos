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
    
    public void dijkstra(GrafoAbstrato g, int vertice){
        while(fila.isEmpty()){
            aux = (Aresta) fila.poll();
            resp.add(aux);
            for(Integer v : g.getAdjacentes(aux.getOrigem())){
                relax(aux.getOrigem(), v, g);
            }
        }               
    }
    
    public static void relax(int u, int v, GrafoAbstrato g){
        if(d[v] > d[u] + g.getAresta(u, v)){
            d[v] = d[u] + g.getAresta(u, v);
            predecessor[v] = u;
        }    
    }    
}
