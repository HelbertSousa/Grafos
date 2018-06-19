/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 *
 * @author a15026
 */
public class Kruskal {

    static double peso;
    static int edgesaux, num = 0;
    
    static ArrayList<Aresta> edges = null;
    static int pai[] = null;
    
    public Kruskal(GrafoAbstrato g) {

        pai = new int[g.getNumeroDeVertices()];
        for (int i = 0; i < g.getNumeroDeVertices(); i++) {
            pai[i] = i;
        }
        
        edges = new ArrayList<>();
          for(int i = 0; i < g.getNumeroDeVertices(); i++){
            for(int j = 0; j < g.getNumeroDeVertices(); j++){
                edges.add(new Aresta(i,j,(g.getAresta(i,j))));
            }
        }      
    }

    public static RespostaKruskalPrim krus(GrafoAbstrato g) {
        Collections.sort(edges);
        
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        
        while ((edgesaux  < g.getNumeroDeVertices()-1 || num < g.getNumeroArestas())){
                       
            if (find(edges.get(num).getOrigem()) != find(edges.get(num).getDestino())){             
                unite(edges.get(num).getOrigem(), edges.get(num).getDestino());           
                peso += edges.get(num).getPeso();    
                
                edgesaux++;
            }    
            num++;
        }
//        for(int r = 0; r < g.getNumeroDeVertices(); r++)
//            System.out.println( r + " -> " + pai[r]);
        
//        System.out.println(peso);
        result.peso = peso;
        result.resp = pai;
        return result;
    }
           

    public static int find(int x) {
        if (pai[x] == x) {
            return x;
        }
        return find(pai[x]);
    }

    public static void unite(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        pai[fx] = fy;
    }

   

}
