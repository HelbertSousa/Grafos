/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author a15026
 */
public class BuscaProfundidadeIterativo {

    static Integer[] caminho = null;
    static Integer[] descoberta = null;
    static List<Boolean> visitado;
    static Stack<Integer> pilha = null;

    
    public static RespostaDFS buscaProfundidadeIterativo(GrafoAbstrato g) {

        caminho = new Integer[g.getNumeroDeVertices()];
        descoberta = new Integer[g.getNumeroDeVertices()];
        
        
        DFS(g);
        
        RespostaDFS result = new RespostaDFS();

        result.tempoDescoberta = Arrays.asList(caminho);
        result.tempoFinalizacao = Arrays.asList(descoberta);

        return result;
    }
    
    public static void DFS(GrafoAbstrato g){
        visitado = new ArrayList<>(Collections.nCopies(g.getNumeroDeVertices(), false));
        for (int i = 0; i < g.getNumeroDeVertices(); i++)
                if (!visitado.get(i))
                    DFSPilha(i, visitado, g);
    }
    
    public static void DFSPilha(int vertice, List<Boolean> visit, GrafoAbstrato g){
        
        pilha = new Stack<>();
        
        int tempo = 0;
        pilha.push(vertice);
        int i = -1;
        while (!pilha.empty()) {
            vertice = pilha.peek();
            pilha.pop();
            if (visitado.get(vertice) == false) {
                tempo++;
                //System.out.println("vertice: " + (vertice) + " " + "tempo: " + (tempo));
                caminho[++i] = vertice;
                descoberta[i] = tempo;
                visitado.set(vertice, true);
            }

            Iterator<Integer> percorrer = g.getAdjacentes(vertice).iterator();
            int aux = 0;
            while (percorrer.hasNext()) {
                int v = percorrer.next();
                if (!visitado.get(v)) {
                    pilha.push(v);
                }
            }
        }
    }
}
