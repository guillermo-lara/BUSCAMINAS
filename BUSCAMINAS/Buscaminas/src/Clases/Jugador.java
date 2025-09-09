/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author g.lara.2022
 */
 public class Jugador extends Usuario implements Serializable
 {
    private Estadisticas stats;
    public Jugador(String nombre, String contraseña)
    {
        super(nombre,contraseña);
        this.stats = new Estadisticas();
    }

    public Jugador(String nombre, String contraseña, Estadisticas stats)
    {
        super(nombre, contraseña);
        this.stats = stats;
    }

    public Estadisticas getStats() {
        return stats;
    }

    public void setStats(Estadisticas stats) {
        this.stats = stats;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
     
 }
