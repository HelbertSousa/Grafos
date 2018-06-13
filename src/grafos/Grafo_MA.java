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
public final class Grafo_MA extends GrafoAbstrato {

    double[][] mat = null;

    public Grafo_MA(int vertices) {
        super.representacao = Representacao.MATRIZ_ADJACENCIA;
        this.criarGrafo(vertices);
    }

    @Override
    protected void criarGrafo(int numeroDeVertices) {
        this.mat = new double[numeroDeVertices][numeroDeVertices];
        for (double[] mat1 : this.mat) {
            for (int j = 0; j < mat1.length; j++) {
                mat1[j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        this.mat[origem][destino] = peso;
    }

    @Override
    public void setAresta(int origem, int destino, double peso) {
        this.mat[origem][destino] = peso;
    }

    @Override
    public double getAresta(int origem, int destino) {
        return mat[origem][destino];

    }

    @Override
    public void removeAresta(int origem, int destino) {
        if (this.mat[origem][destino] != Double.POSITIVE_INFINITY) {
        } else {
            this.mat[origem][destino] = Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public int getNumeroArestas() {
        int n = 0;
        for (double[] line : mat) {
            for (double cell : line) {
                if (Double.compare(Double.POSITIVE_INFINITY, cell) != 0) {
                    n++;
                }
            }
        }

        return n;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return Representacao.MATRIZ_ADJACENCIA;
    }

    @Override
    public List<Integer> vertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public List<Integer> getAdjacentes(int vertice) {
        List<Integer> adjacentes = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            if (Double.compare(Double.POSITIVE_INFINITY, mat[vertice][i]) != 0) {
                adjacentes.add(i);
            }
        }
        return adjacentes;
    }

    @Override
    public int getNumeroDeVertices() {
        return mat.length;
    }

}
