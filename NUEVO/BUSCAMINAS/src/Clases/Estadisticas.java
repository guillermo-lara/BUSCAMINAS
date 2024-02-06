/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author g.lara.2022
 */
public class Estadisticas
{
    private int jugadas;
    private int ganadas;
    private int perdidas;
    private int minas_a_favor;
    private int minas_en_contra;

    public Estadisticas()
    {
        this.ganadas = 0;
        this.jugadas = 0;
        this.perdidas = 0;
        this.minas_a_favor = 0;
        this.minas_en_contra = 0;
    }

    public Estadisticas(int jugadas, int ganadas, int perdidas, int minas_a_favor, int minas_en_contra) {
        this.jugadas = jugadas;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.minas_a_favor = minas_a_favor;
        this.minas_en_contra = minas_en_contra;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getMinas_a_favor() {
        return minas_a_favor;
    }

    public void setMinas_a_favor(int minas_a_favor) {
        this.minas_a_favor = minas_a_favor;
    }

    public int getMinas_en_contra() {
        return minas_en_contra;
    }

    public void setMinas_en_contra(int minas_en_contra) {
        this.minas_en_contra = minas_en_contra;
    }
    
    
}
