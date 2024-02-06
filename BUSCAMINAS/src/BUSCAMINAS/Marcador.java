package BUSCAMINAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author d.pelado.2022
 */
public class Marcador {
    private int puntos_J1;
    private int puntos_J2;

    public Marcador(int puntos_J1, int puntos_J2) {
        this.puntos_J1 = puntos_J1;
        this.puntos_J2 = puntos_J2;
    }

    public Marcador() 
    {
        this.puntos_J1 = 0;
        this.puntos_J2 = 0;
    }
    
    
    public void addPuntos_J1()
    {
        this.setPuntos_J1(this.getPuntos_J1()+1);
    }
    
    public void addPuntos_J2()
    {
        this.setPuntos_J2(this.getPuntos_J2()+1);
    }    
    
    
    public int getPuntos_J1() {
        return puntos_J1;
    }

    public int getPuntos_J2() {
        return puntos_J2;
    }

    public void setPuntos_J1(int puntos_J1) {
        this.puntos_J1 = puntos_J1;
    }

    public void setPuntos_J2(int puntos_J2) {
        this.puntos_J2 = puntos_J2;
    }
    
    
}
