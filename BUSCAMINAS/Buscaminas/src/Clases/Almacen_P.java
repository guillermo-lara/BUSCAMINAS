/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author g.lara.2022
 */
public class Almacen_P extends AbstractListModel
{
    private ArrayList <Partida> partidas;
    
    public Almacen_P(ArrayList<Partida> partidas)
    {
        this.partidas = partidas;
    }
    
    
    public void insert_partida(Partida nueva)
    {
        this.partidas.add(this.partidas.size(), nueva);
    }
    
    public ArrayList<Partida> get_partida(Jugador player)
    {
        ArrayList<Partida> devolver = new ArrayList<>();
        int j = 0;
        for(int i=0; i < this.partidas.size(); i++)
        {
            if(this.partidas.get(i).getJugador_1() == player)
            {
                devolver.add(j, this.partidas.get(i));
                j++;
            }
            else if(this.partidas.get(i).getJugador_2() == player)
            {
                devolver.add(j, this.partidas.get(i));
                j++;
            }        
        }
        return devolver;
    }

    @Override
    public int getSize() {
        return partidas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return partidas.get(index);
    }
}
