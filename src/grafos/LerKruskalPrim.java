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
public class LerKruskalPrim {

    static int cont;

    public static GrafoAbstrato ler(String path, Representacao r) throws Exception {

        GrafoAbstrato grafo;
        List<String> file = Files.readAllLines(Paths.get(path));

        file.remove(0);

        for (int i = 0; i < file.size(); i++) {
            if (file.get(i).isEmpty()) {
                file.remove(i);
            }
        }
        cont = file.size();

        if (r == Representacao.LISTAS_ADJACENCIA) {
            grafo = new Grafo_LA(cont);
        } else {
            grafo = new Grafo_MA(cont);
        }
        
        double vetx[] = new double[cont];
        double vety[] = new double[cont];
        int i = -1;
        
        for (String line : file) {
            i++;
            String[] s = line.split(",");
            vetx[i] = Double.parseDouble(s[0]);
            vety[i] = Double.parseDouble(s[1]);
        }
        for(int auxx = 0; auxx < cont; auxx++){
            for (int auxy = 0; auxy < cont; auxy++){
                grafo.addAresta(auxx, auxy, DistanciaEuclidiana(vetx[auxx], vety[auxx], vetx[auxy], vety[auxy]));
            }
        }

        return grafo;
    }

    public static double DistanciaEuclidiana(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1, y1) + Math.pow(x2, y2));

    }

}
