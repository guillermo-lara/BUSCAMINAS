package Clases;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author d.pelado.2022
 */
public class Partida
{
    private Jugador jugador_1, jugador_2;
    private Tablero tablero;
    private ArrayList<Movimientos> moves;
    private Marcador marcador;

    public Partida(Jugador jugador_1, Jugador jugador_2, Tablero tablero, ArrayList<Movimientos> moves, Marcador marcador) {
        this.jugador_1 = jugador_1;
        this.jugador_2 = jugador_2;
        this.tablero = tablero;
        this.moves = moves;
        this.marcador = marcador;
    }

    public Jugador getJugador_1() {
        return jugador_1;
    }
    public Jugador getJugador_2() {
        return jugador_2;
    }
    public Tablero getTablero() {
        return tablero;
    }
    public ArrayList<Movimientos> getMoves() {
        return moves;
    }
    public Marcador getMarcador() {
        return marcador;
    }

    public void setMoves(ArrayList<Movimientos> moves) {
        this.moves = moves;
    }
    
    
    public void info_partida()
    {
        
    }
    
    public void jugar()
    {
        
    }
    private void cambiarTurno()
    {
        Jugador aux_1 = this.jugador_1;
        Jugador aux_2 = this.jugador_1;
        this.jugador_1 = aux_2;
        this.jugador_2 = aux_1;
    }
    
    
}
