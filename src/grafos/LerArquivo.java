/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author a15026
 */
public class LerArquivo {

    public static GrafoAbstrato ler(String path, Representacao r) throws Exception {

        GrafoAbstrato grafo;
        List<String> file = Files.readAllLines(Paths.get(path));
        file.remove(0);

        for (int i = 0; i < file.size(); i++) {
            if (file.get(i).isEmpty()) {
                file.remove(i);
            }
        }

        int numeroVertices = 0;

        for (String line : file) {
            String[] s = line.split(",");
            int v1 = Integer.parseInt(s[0]), v2 = Integer.parseInt(s[1]);
            if (v1 > v2) {
                if (v1 > numeroVertices) {
                    numeroVertices = v1;
                }
            } else {
                if (v2 > numeroVertices) {
                    numeroVertices = v2;
                }
            }
        }

        numeroVertices++;

        if (r == Representacao.LISTAS_ADJACENCIA) {
            grafo = new Grafo_LA(numeroVertices);
        } else {
            grafo = new Grafo_MA(numeroVertices);
        }

        for (String line : file) {
            String[] s = line.split(",");
            grafo.addAresta(Integer.parseInt(s[0]), Integer.parseInt(s[1]), 0.0);
        }

        return grafo;
    }
}
