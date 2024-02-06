/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Buscaminas;
import Interfaces.*;
import Clases.*;
import java.io.File;
import java.util.ArrayList;

public class main 
{
    public static ArrayList<Jugador> listaJ ;
    public static ArrayList<Partida> listaP ;
    public static File f = new File("C:\\BUSCAMINAS\\note");

    public static void main(String[] args)
    {
        InicioSesion Comienzo = new InicioSesion();
    }
    
}
