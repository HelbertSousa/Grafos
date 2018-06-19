/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author a15026
 */
public class ImprimirSaida {

    public static boolean ImprimirSaidaDFS(String output_file, RespostaDFS r) {
        FileWriter arq;
        PrintWriter gravarArq;

        try {
            arq = new FileWriter(output_file);
            gravarArq = new PrintWriter(arq);
        } catch (IOException ex) {
            return false;
        }

        gravarArq.printf("Origem,Encontrado,Finalizado\n");
        for (int i = 0; i < r.tempoDescoberta.size(); i++) {
            gravarArq.printf(i + ",");
            gravarArq.printf(r.tempoDescoberta.get(i) + ",");
            gravarArq.printf(r.tempoFinalizacao.get(i) + ",");
            gravarArq.printf("\n");
        }
        try {
            arq.close();
            gravarArq.close();
        } catch (IOException ex) {
        }
        return true;
    }

    public static boolean ImprimirSaidaBFS(String output_file, RespostaBFS r) {
        FileWriter arq;
        PrintWriter gravarArq;

        try {
            arq = new FileWriter(output_file);
            gravarArq = new PrintWriter(arq);
        } catch (IOException ex) {
            return false;
        }

        gravarArq.printf("Vertice,PI,Distancia\n");
        for (int i = 0; i < r.pi.size(); i++) {
            gravarArq.printf(i + ",");
            gravarArq.printf(r.pi.get(i) + ",");
            gravarArq.printf(r.d.get(i) + ",");
            gravarArq.printf("\n");
        }
        try {
            arq.close();
            gravarArq.close();
        } catch (IOException ex) {
        }
        return true;
    }
    public static boolean ImprimirSaidaKruskal(String output_file, RespostaKruskalPrim r) {
        FileWriter arq;
        PrintWriter gravarArq;

        try {
            arq = new FileWriter(output_file);
            gravarArq = new PrintWriter(arq);
        } catch (IOException ex) {
            return false;
        }

        gravarArq.printf("Vertice x, Vertice y\n");
        int aux = 0;
        for (int i = 0; i < r.resp.length - 1; i++) {
            gravarArq.printf( r.resp[aux] + ",");
            aux = r.resp[aux];
            gravarArq.printf( r.resp[aux] + "");   
            gravarArq.printf("\n");
        }
        gravarArq.printf("peso total:" + r.peso);
        try {
            arq.close();
            gravarArq.close();
        } catch (IOException ex) {
        }
        return true;
    }
    public static boolean ImprimirSaidaDijkstraBellmanFord(String output_file, RespostaDijkBellFor r) {
        FileWriter arq;
        PrintWriter gravarArq;

        try {
            arq = new FileWriter(output_file);
            gravarArq = new PrintWriter(arq);
        } catch (IOException ex) {
            return false;
        }

        gravarArq.printf("Vertice x, Vertice y\n");
        int aux = 0;
        for (int i = 0; i < r.resp.length - 1; i++) {
            gravarArq.printf( r.resp[aux] + ",");
            aux = r.resp[aux];
            gravarArq.printf( r.resp[aux] + "");   
            gravarArq.printf("\n");
        }
        gravarArq.printf("peso total:" + r.peso);
        try {
            arq.close();
            gravarArq.close();
        } catch (IOException ex) {
        }
        return true;
    }
}
