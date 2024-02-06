package BUSCAMINAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author d.pelado.2022
 */
public class Movimientos {
    private int CoordenadaX;
    private int CoordenadaY;
    private String nombre_jugador;

    public Movimientos(int CoordenadaX, int CoordenadaY, String nombre_jugador)
    {
        this.CoordenadaX = CoordenadaX;
        this.CoordenadaY = CoordenadaY;
        this.nombre_jugador = nombre_jugador;
    }

    public int getCoordenadaX() 
    {
        return CoordenadaX;
    }

    public int getCoordenadaY()
    {
        return CoordenadaY;
    }

    public String getNombre_jugador()
    {
        return nombre_jugador;
    }

    public void setCoordenadaX(int CoordenadaX)
    {
        this.CoordenadaX = CoordenadaX;
    }

    public void setCoordenadaY(int CoordenadaY)
    {
        this.CoordenadaY = CoordenadaY;
    }

    public void setNombre_jugador(String nombre_jugador)
    {
        this.nombre_jugador = nombre_jugador;
    }

    @Override
    public String toString()
    {
        return nombre_jugador +"#"+ CoordenadaX + CoordenadaY;
    }
    
    
}
