/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUSCAMINAS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Almacen_J
{

    /**
     *
     */
    public static ArrayList<Jugador> copy ;
    
      public Almacen_J() 
      {
        }
    
    public boolean autenticar (Jugador u)
    {
        int i = 0;
       
        while(i<copy.size())
        {
           if (copy.get(i).equals(u) == true)
           {
               return true;
           }
           i++;
        }
        return false;
    }
    
    
    
    public Jugador retrnJugador (String name, String psw)
    {
        int i = 0;
       
        while(i<copy.size())
        {
           if ((copy.get(i).nombre.equals(name)&& copy.get(i).contraseña.equals(psw) )== true)
           {
               return copy.get(i);
           }
           i++;
        }
        return null;
    }

  
    public void alta (Jugador j)
    {
        copy.add(j);
    }
    
    
    public void baja (Jugador j)
    {
        copy.remove(j);
    }
    
    
    public ArrayList<Jugador> clasificacion_por_victorias()
    {
        ArrayList<Jugador> res = new ArrayList<>();
        for(int i = 0; i < copy.size(); i++)
        {
            if("Jugador".equals(copy.get(i).getClass().toString()))
            {
                res.add((Jugador) copy.get(i));
            }
        }
        Collections.sort(res, new Comparator<Jugador>()
        {
            @Override
            public int compare(Jugador j1, Jugador j2)
            {
                return Integer.valueOf(j2.getStats().getGanadas()).compareTo(j1.getStats().getGanadas());
            }
        });
        return res;
    }    
        
        
    public ArrayList<Jugador> clasificacion_por_nombre()
    {
        ArrayList<Jugador> res = new ArrayList<>();
        for(int i = 0; i < copy.size(); i++)
        {
            if("Jugador".equals(copy.get(i).getClass().toString()))
            {
                res.add((Jugador) copy.get(i));
            }
        }
    Collections.sort(res, new Comparator<Jugador>(){
        @Override
        public int compare(Jugador j1, Jugador j2)
        {
            return j1.getNombre().compareTo(j2.getNombre());
        }
    });
    return res;
    }
}
