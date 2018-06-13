/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author a15026
 */
public class Prim {
    static Queue<Aresta> fila = null;
    static int [] key,pi = null;
    
    
    public Prim(GrafoAbstrato g){
        fila = new PriorityQueue<>();
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            for(int j = 0; j < g.getNumeroDeVertices(); j++){
                fila.add(new Aresta(i,j,(g.getAresta(i,j))));
            }
        }
        
        key = new int[g.getNumeroDeVertices()];
        pi = new int[g.getNumeroDeVertices()];
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            key[u]= Integer.MAX_VALUE;
        }
        
        
        
        
    }
    
    public static RespostaKruskalPrim prim(GrafoAbstrato g){
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        
        
        return result;
    }

      
}
