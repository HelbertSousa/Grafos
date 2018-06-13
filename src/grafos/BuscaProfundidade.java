/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author a15026
 */
public class BuscaProfundidade {

    static Integer[] f = null;
    static Integer[] d = null;
    static List<Integer> ordemDeVisita = null;
    static List<Integer> adjacentes = null;

    public static RespostaDFS buscaProfundidade(GrafoAbstrato g) {
        int[] cor = new int[g.getNumeroDeVertices()];
        f = new Integer[g.getNumeroDeVertices()];
        d = new Integer[g.getNumeroDeVertices()];

        RespostaDFS result = new RespostaDFS();

        for (int i = 0; i < g.getNumeroDeVertices(); i++) {
            f[i] = 0;
            d[i] = 0;
        }

        if (ordemDeVisita == null) {
            ordemDeVisita = new ArrayList<>();
            for (int i = 0; i < g.getNumeroDeVertices(); i++) {
                ordemDeVisita.add(i);
            }
        }

        int tempo = 0;
        g.vertices().forEach((vertice) -> {
            cor[vertice] = 0;
        });

        for (Integer vertice : ordemDeVisita) {
            if (cor[vertice] == 0) {
                try {
                    tempo = dfsVisit(g, ordemDeVisita, vertice, null, cor, d, f, tempo, result);
                } catch (Exception ex) {
                }
            }
        }
        result.tempoDescoberta = Arrays.asList(d);
        result.tempoFinalizacao = Arrays.asList(f);

        return result;
    }

    public static int dfsVisit(GrafoAbstrato g, List<Integer> ordemVisita,
            Integer vertice, Integer pai, int[] cor,
            Integer[] d, Integer[] f, int tempo,
            RespostaDFS result) {
        cor[vertice] = 1;
        d[vertice] = ++tempo;

        adjacentes = g.getAdjacentes(vertice);

        for (Integer adj : ordemVisita) {
            if (!adjacentes.contains(adj)) {
                continue;
            }

            if (cor[adj] == 0) {
                tempo = dfsVisit(g, ordemDeVisita, adj, vertice, cor, d, f, tempo, result);
            }
        }

        cor[vertice] = 2;
        f[vertice] = ++tempo;

        return tempo;
    }

}
