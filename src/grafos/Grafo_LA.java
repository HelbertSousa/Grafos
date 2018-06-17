/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a15026
 */
public final class Grafo_LA extends GrafoAbstrato {

    private int numeroDeVertice;
    List<List<Aresta>> vertices = new ArrayList<>();

    public Grafo_LA(int vertices) {
        super.representacao = Representacao.LISTAS_ADJACENCIA;
        this.criarGrafo(vertices);
    }

    @Override
    protected void criarGrafo(int numeroDeVertices) {
        for (int i = 0; i < numeroDeVertices; i++) {
            vertices.add(new ArrayList<>());
        }
        this.numeroDeVertice = numeroDeVertices;
    }

    @Override
    public int getNumeroDeVertices() {
        return numeroDeVertice;
    }

    @Override
    public List<Integer> getAdjacentes(int vertice) {
        List<Integer> adjacentes = new ArrayList<>();

        vertices.get(vertice).forEach((aresta) -> {
            adjacentes.add(aresta.getDestino());
        });
        return adjacentes;
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        vertices.get(origem).add(new Aresta(origem, destino, peso));
    }

    @Override
    public void setAresta(int origem, int destino, double peso) {
        List<Aresta> arestas = vertices.get(origem);
        for (Aresta aux : arestas) {
            if (aux.getDestino() == destino) {
                aux.peso = peso;
                return;
            }
        }
    }

    @Override
    public double getAresta(int origem, int destino) {
        List<Aresta> arestas = vertices.get(origem);
        for (Aresta aux : arestas) {
            if (aux.getDestino() == destino) {
                return aux.peso;
            }
        }
        return 0.0;
    }

    @Override
    public void removeAresta(int origem, int destino) {
        List<Aresta> arestas = vertices.get(origem);
        for (int i = 0; i < arestas.size(); i++) {
            Aresta aresta = arestas.get(i);
            if (aresta.getDestino() == destino) {
                arestas.remove(aresta);
            }
        }
    }

    @Override
    public int getNumeroArestas() {
        int numero = 0;
        for (List<Aresta> arestas : vertices) {
            for (Aresta aresta : arestas) {
                numero++;
            }
        }

        return numero;
    }

    @Override
    public List<Integer> vertices() {
        List<Integer> vertices = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            vertices.add(i);
        }

        return vertices;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return Representacao.LISTAS_ADJACENCIA;
    }

}
