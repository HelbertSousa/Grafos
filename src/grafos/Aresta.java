/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author a15026
 */
public class Aresta implements Comparable<Aresta> {

    private int origem;
    private int destino;
    double peso;

    public Aresta(int origem, int destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Aresta(int origem, int destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigem() {
        return this.origem;
    }

    public int getDestino() {
        return this.destino;
    }

    public double getPeso() {
        return this.peso;
    }
    
    
    public int compareTo(Aresta o) {
        if(this.peso > o.peso) {return 1;}
        else if(this.peso < o.peso ) {return -1;}
        else {return 0;}
    }
}
