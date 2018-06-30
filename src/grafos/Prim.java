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
    static int [] predecessor  = null;
    static boolean [] visit;
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
        visit = new boolean[g.getNumeroDeVertices()];
        predecessor = new int [g.getNumeroDeVertices()];
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            key[u]= Double.MAX_VALUE;
            visit[u]= false;
        }        
        resp = new LinkedList<>();

    }
    
    public static RespostaKruskalPrim prim(GrafoAbstrato g){
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        key[0] = 0;
        predecessor[0] = 0;
        
        while(!filaprioridade.isEmpty()){
            
            auxaresta = filaprioridade.peek();
            resp.add(auxaresta);
            
            int u = auxaresta.getOrigem();
            
            filaprioridade.remove();
            
            for(Integer v : g.getAdjacentes(u)){
                if (!visit[u]
                        && g.getAresta(u, v) < key[v]){//duvida em como comparar se existe tal aresta em resp
                        key[v] = g.getAresta(u, v);
                        filaprioridade.add(g.getInstanciaAresta(u, v));
                        predecessor[v] = u;
                        
                }
                visit[v] = true;
            }
            
        }
        for(int i = 0; i < key.length; i++){
                peso += key[i];
        }
        for(int i = 0; i < predecessor.length; i++){
                System.out.println("n = " + predecessor[i]);
        }
                
        result.peso = peso;
        result.resp = predecessor;
        
        return result;
    }

      
}
