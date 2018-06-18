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
    static int [] color, predecessor  = null;
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
        color = new int[g.getNumeroDeVertices()];
        predecessor = new int [g.getNumeroDeVertices()];
        for(int u = 0; u < g.getNumeroDeVertices(); u++){
            key[u]= Double.MAX_VALUE;
            color[u]= -1;
        }        
        resp = new LinkedList<>();

    }
    
    public static RespostaKruskalPrim prim(GrafoAbstrato g){
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        key[0] = 0;
        predecessor[0] = 0;
        while(!filaprioridade.isEmpty()){
            auxaresta = filaprioridade.poll();
            resp.add(auxaresta);
            int u = auxaresta.getOrigem();
            
            for(Integer v : g.getAdjacentes(u)){
                if (filaprioridade.contains(g.getInstanciaAresta(u, v)) 
                        && g.getAresta(u, v) < key[v]){//duvida em como comparar se existe tal aresta em resp
                        key[v] = g.getAresta(u, v);
                        //Mudar valor da fila para nova chave;
                        predecessor[v] = u;     
                }
            }
        }
        for(int i = 0; i < key.length; i++){
                peso += key[i];
        }
        
        result.peso = peso;
        result.resp = predecessor;
        
        return result;
    }

      
}
