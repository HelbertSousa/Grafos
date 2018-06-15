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
public class Grafos {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Representacao representacao;

        Map<String, String> argumentos = new HashMap<>();

        for (int i = 0; i < args.length; i = i + 2) {
            argumentos.put(args[i], args[i + 1]);
        }
        // argumentos.get("-grafo") = guarda na Hash o tipo de grafo escolhido
        int x = Integer.parseInt(argumentos.get("-grafo"));
        if (x == 1) {
            representacao = Representacao.MATRIZ_ADJACENCIA;
        } else {
            representacao = Representacao.LISTAS_ADJACENCIA;
        }
        //argumentos.get("-csvorigem") = guarda na hash o nome do arquivo de origem
        GrafoAbstrato grafo = LerArquivo.ler(argumentos.get("-csvorigem"), representacao);
        
        // argumentos.get("-rep") = guarda na Hash o tipo de representação escolhido
        switch (argumentos.get("-rep")) {
            case "DFS":
                // argumentos.get("-f") = guarda na hash o Tipo de DFS
                if ("R".equals(argumentos.get("-f"))) {
                    RespostaDFS resultDFS;
                    resultDFS = BuscaProfundidade.buscaProfundidade(grafo);
                    //-csvdestino = guarda na hash o nome do arquivo de saida
                    ImprimirSaida.ImprimirSaidaDFS(argumentos.get("-csvdestino"), resultDFS);
                } else if ("I".equals(argumentos.get("-f"))) {
                    RespostaDFS resultDFSIterativo;
                    resultDFSIterativo = BuscaProfundidade.buscaProfundidade(grafo);
                    //-csvdestino = guarda na hash o nome do arquivo de saida
                    ImprimirSaida.ImprimirSaidaDFS(argumentos.get("-csvdestino"), resultDFSIterativo);
                }
                break;
            case "BFS":
                RespostaBFS resultBFS;
                // argumentos.get("-f") = guarda na hash o grafo de inicio do caminhamento
                resultBFS = BuscaEmLargura.buscaLargura(grafo, Integer.parseInt(argumentos.get("-f")));
                //-csvdestino = guarda na hash o nome do arquivo de saida
                ImprimirSaida.ImprimirSaidaBFS(argumentos.get("-csvdestino"), resultBFS);
                break;
        }
    }
}
//IF representacao 1 = Matriz 2 = Lista
//        if (args[0].equals(1)) {
//            representacao = Representacao.MATRIZ_ADJACENCIA;
//        } else {
//            representacao = Representacao.LISTAS_ADJACENCIA;
//        }
//        // IF tipo de busca: BFS OU DFS
//        if (args[1].equals("BFS")) {
//            //args3 = nome do arquivo de entrada do grafo
//            GrafoAbstrato grafo = LerArquivo.ler(args[3], representacao);
//            RespostaBFS resultBFS;
//            //args2 = grafo de inicio do caminhamento
//            resultBFS = BuscaEmLargura.buscaLargura(grafo, Integer.parseInt(args[2]));
//            //args4 = nome do arquivo de saida
//            ImprimirSaida.ImprimirSaidaBFS(args[4], resultBFS);
//        }
//        if (args[1].equals("DFS")) {
//            //IF Tipo de DFS I = Iterativo R = Recursivo
//            if (args[2].equals("I")) {
//                //args3 = nome do arquivo de entrada do grafo
//                GrafoAbstrato grafo = LerArquivo.ler(args[3], representacao);
//                RespostaDFS resultDFSIterativo;
//                resultDFSIterativo = BuscaProfundidade.buscaProfundidade(grafo);
//                //args4 = nome do arquivo de saida
//                ImprimirSaida.ImprimirSaidaDFS(args[4], resultDFSIterativo);
//            } else if (args[2].equals("R")) {
//                //args3 = nome do arquivo de entrada do grafo
//                GrafoAbstrato grafo = LerArquivo.ler(args[3], representacao);
//                RespostaDFS resultDFS;
//                resultDFS = BuscaProfundidade.buscaProfundidade(grafo);
//                //args4 = nome do arquivo de saida
//                ImprimirSaida.ImprimirSaidaDFS(args[4], resultDFS);
//            }
//        }

//      System.out.println("Descoberta: ");
//          if (resultBFS.tempoDescoberta.size() > 0) {
//            System.out.print(resultBFS.tempoDescoberta.get(0));
//        }
//        for (int i = 1; i < resultBFS.tempoDescoberta.size(); i++) {
//           System.out.print("," + resultBFS.tempoDescoberta.get(i));
//        }
//       
//       System.out.println("\nFinalização: ");
//        if (resultBFS.tempoFinalizacao.size() > 0) {
//           System.out.print(resultBFS.tempoFinalizacao.get(0));
//        }
//        for (int i = 1; i < resultBFS.tempoFinalizacao.size(); i++) {
//            System.out.print("," + resultBFS.tempoFinalizacao.get(i));
//        }
//        
//        System.out.println("");

