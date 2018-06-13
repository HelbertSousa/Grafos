/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author a15026
 */
public class BuscaEmLargura {

    static int[] visitado = null;
    static Integer[] distancia = null;
    static Integer[] pi = null;
    static LinkedList<Integer> fila = null;

    public static RespostaBFS buscaLargura(GrafoAbstrato g, int inicio) {

        visitado = new int[g.getNumeroDeVertices()];
        distancia = new Integer[g.getNumeroDeVertices()];
        pi = new Integer[g.getNumeroDeVertices()];
        fila = new LinkedList<>();

        for (int i = 0; i < g.getNumeroDeVertices(); i++) {
            distancia[i] = Integer.MAX_VALUE;
        }
        distancia[inicio] = 0;
        visitado[inicio] = 1;
        fila.add(inicio);

        while (!fila.isEmpty()) {
            int v = fila.poll();

            for (int w : g.getAdjacentes(v)) {
                if (visitado[w] == 0) {
                    visitado[w] = 1;
                    distancia[w] = distancia[v] + 1;
                    pi[w] = v;
                    fila.add(w);
                }
            }
            visitado[v] = 2;
        }

        RespostaBFS result = new RespostaBFS();

        result.d = Arrays.asList(distancia);
        result.pi = Arrays.asList(pi);

        return result;
    }
}
