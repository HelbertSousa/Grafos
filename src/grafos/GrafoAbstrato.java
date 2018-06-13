/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.List;

/**
 *
 * @author a15026
 */
public abstract class GrafoAbstrato {
    
    Representacao representacao = null;
    
    protected abstract void criarGrafo(int numeroDeVertices);
    
    public abstract void addAresta(int origem,int destino, double peso);

    public abstract void setAresta(int origem,int destino, double peso);
    
    public abstract double getAresta(int origem,int destino);
    
    public abstract void removeAresta(int origem,int destino);

    public abstract int getNumeroArestas();
    
    public abstract Representacao getRepresentacaoComputacional();
    
    public abstract List<Integer> vertices();
    
    public abstract List<Integer> getAdjacentes(int vertice);
    
    public abstract int getNumeroDeVertices();
}
