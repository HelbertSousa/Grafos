/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author a15026
 */
public class Prim {
    static Queue<Aresta> fila = null;
    static int [] key = null;
    static double [] pi  = null;
    static List<Aresta> resp = null;
    static Aresta auxaresta = null;
    static List<Integer> adj = null;
    
    
    public Prim(GrafoAbstrato g){
        fila = new PriorityQueue<>();
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            for(int j = 0; j < g.getNumeroDeVertices(); j++){
                fila.add(new Aresta(i,j,(g.getAresta(i,j))));
            }
        }
        
        key = new int[g.getNumeroDeVertices()];
        pi = new double[g.getNumeroDeVertices()];
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            key[u]= Integer.MAX_VALUE;
            pi[u]= -1;
        }
        
        resp = new LinkedList<>();
        adj = new LinkedList<>();
    }
    
    public static RespostaKruskalPrim prim(GrafoAbstrato g){
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        key[0] = 0;
        boolean aux = false;
        while(fila.isEmpty()){
            auxaresta = fila.poll();
            resp.add(auxaresta);
            adj.addAll(g.getAdjacentes(auxaresta.getOrigem()));
            for (int w : adj) {
              //      if (){
                        
                    }
        }
        
        return result;
    }

      
}
