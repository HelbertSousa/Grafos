/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author a15026
 */
public class Prim {
    static Queue<Aresta> filaprioridade = null;
    static double [] key = null;
    static int [] pi  = null;
    static List<Aresta> resp = null;
    static Aresta auxaresta = null;
    static double peso;
    
    
    public Prim(GrafoAbstrato g){
        filaprioridade = new PriorityQueue<>();
        for(int i = 0; i < g.getNumeroDeVertices(); i++){
            for(int j = 0; j < g.getNumeroDeVertices(); j++){
                filaprioridade.offer(new Aresta(i,j,(g.getAresta(i,j))));
            }
        }
        
        key = new double[g.getNumeroDeVertices()];
        pi = new int[g.getNumeroDeVertices()];
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            key[u]= Double.MAX_VALUE;
            pi[u]= -1;
        }
        
        resp = new LinkedList<>();

    
    }
    
    public static RespostaKruskalPrim prim(GrafoAbstrato g){
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        key[0] = 0;
        while(!filaprioridade.isEmpty()){
            auxaresta = filaprioridade.poll();
            resp.add(auxaresta);
            int u = auxaresta.getOrigem();
            
            for(Integer v : g.getAdjacentes(u)){
                if (filaprioridade.contains(g.getAresta(u, v)))
                    if(g.getAresta(u, v) < key[v]){
                        pi[v] = auxaresta.getOrigem();
                        key[v] = g.getAresta(u, v);                
                }
            }
        }
        for(int i = 0; i < key.length; i++){
                peso += key[i];
        }
        
        result.peso = peso;
        result.resp = pi;
        
        return result;
    }

      
}
