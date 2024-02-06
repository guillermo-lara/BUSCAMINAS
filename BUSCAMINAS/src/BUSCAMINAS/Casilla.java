/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSCAMINAS;

/**
 *
 * @author g.lara.2022
 */
public class Casilla
{
    private int Coordenada_X;
    private int Coordenada_Y;
    private String Simbolo_oculto;
    private int contador; 

    public Casilla(int Coordenada_X, int Coordenada_Y, String Simbolo_oculto) {
        this.Coordenada_X = Coordenada_X;
        this.Coordenada_Y = Coordenada_Y;
        this.Simbolo_oculto = Simbolo_oculto;
        this.contador=0;
    }

    public Casilla(int Coordenada_X, int Coordenada_Y) {
        this.Coordenada_X = Coordenada_X;
        this.Coordenada_Y = Coordenada_Y;
        this.Simbolo_oculto = null;
        this.contador=0;
    }
    
    
    public void setSimbolo_oculto(String Simbolo_oculto) {
        this.Simbolo_oculto = Simbolo_oculto;
    }

    public String getSimbolo_oculto() {
        return Simbolo_oculto;
    }

    public int getCoordenada_X() {
        return Coordenada_X;
    }

    public int getCoordenada_Y() {
        return Coordenada_Y;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    public void addContador() {
        this.contador++;
    }
}

