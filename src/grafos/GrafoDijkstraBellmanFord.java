/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author a15026
 */
public class GrafoDijkstraBellmanFord {
    public static void main(String[] args) throws Exception {
        Representacao representacao;

        Map<String, String> argumentos = new HashMap<>();

        for (int i = 0; i < args.length; i = i + 2) {
            argumentos.put(args[i], args[i + 1]);
        }
        
        int x = Integer.parseInt(argumentos.get("-representacao"));
        if (x == 1) {
            representacao = Representacao.MATRIZ_ADJACENCIA;
        } else {
            representacao = Representacao.LISTAS_ADJACENCIA;
        }      
        GrafoAbstrato grafo = LerKruskalPrim.ler(argumentos.get("-input"), representacao);
        int inicio = 0;
        switch (argumentos.get("-algorithm")) {
            case "bellmanford":
                RespostaDijkBellFor resultBellmanFord;
                BellmanFord bellmanford = new BellmanFord(grafo);
                resultBellmanFord = BellmanFord.bellmanford(grafo, inicio);
                ImprimirSaida.ImprimirSaidaDijkstraBellmanFord(argumentos.get("-output"), resultBellmanFord);
                break;
            case "dijkstra":
                RespostaDijkBellFor resultDijkstra;
                Dijkstra dijkstra = new Dijkstra(grafo);
                resultDijkstra = Dijkstra.dijkstra(grafo, inicio);
                ImprimirSaida.ImprimirSaidaDijkstraBellmanFord(argumentos.get("-output"), resultDijkstra);
                break;
        }
    }
    
}
