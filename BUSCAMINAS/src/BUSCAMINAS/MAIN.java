/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSCAMINAS;

import java.util.ArrayList;

/**
 *
 * @author g.lara.2022
 */
public class MAIN 
{
    public static ArrayList<Jugador> listaJ ;
    public static ArrayList<Partida> listaP ;
    
    public static void main(String[] args)
    {
        listaP = new ArrayList<>();
        listaJ = new ArrayList<>();
        DEFAULT hola = new DEFAULT();
        hola.setVisible(true);
    }
}
