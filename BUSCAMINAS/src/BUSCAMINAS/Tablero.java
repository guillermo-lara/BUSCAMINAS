package BUSCAMINAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author d.pelado.2022
 */
public class Tablero 
{
    private final int minas=51; 
    private ArrayList <Casilla> lista;

    Casilla[][] casillas;
    
    
    
        
    
    public Tablero()
    {
        this.lista = new ArrayList<>();
        this.inicializarCasillas();
        matrizToArrayList();
    }
    
    public ArrayList<Casilla> getLista()
    {
        return lista;
    }    
    
    private void matrizToArrayList()
    {
        
        for(int i = 0; i<16; i++)
        {
            for(int j = 0; j<16; j++)
            {
                this.lista.add(casillas[j][i]);
            }
        }
    }
  
    private void inicializarCasillas()
    {
        casillas = new Casilla[16][16];
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                casillas[i][j] = new Casilla (i,j,"BLANCO");
            }
        }
        generarMinas();
    }
    
    
    private void generarMinas()
    {
        int minasGene = 0;
        while(minas!=minasGene)
        {
            int i = (int)(Math.random()*16);
            int j = (int)(Math.random()*16);
            if(!"MINA".equals(casillas[i][j].getSimbolo_oculto()))
            {
                casillas[i][j].setSimbolo_oculto("MINA");
                minasGene++;
            }
        }
        setCasillasAdyacentes();
    }
    

 
    private void setCasillasAdyacentes()
    {
        for (int i=0;i<16;i++)
        {
            for (int j=0;j<16;j++)
            {
                if("MINA".equals(this.casillas[i][j].getSimbolo_oculto()))
                {
                    List<Casilla> aux = comprobarAlrededor(i,j);
                    aux.forEach((c)->c.addContador());
                    aux.forEach((c)->c.setSimbolo_oculto("ADYACENTE"));
                }
            }
        }
        
    }
    
    private List<Casilla> comprobarAlrededor(int pos_fila, int pos_columna)
    {
        List <Casilla> alrededor = new LinkedList<>();
 
        for(int i = 0; i<8; i++)
        {
            int fila = pos_fila;
            int colum = pos_columna;
            switch(i)
            {
                case 0: fila-- ;break;
                case 1: fila--;colum++;break;
                case 2: colum++;break;
                case 3: colum++;fila++;break;
                case 4: fila++;break;
                case 5: fila++;colum--;break;
                case 6: colum--;break;
                case 7: fila--;colum--;break;
            }
            if(fila >=0 && fila<this.casillas.length
                    && colum>=0 && colum<this.casillas[0].length)
            {
                alrededor.add(this.casillas[fila][colum]);
            }
        }
        
        return alrededor;
    }
            
       
}    


    
    
    
    
    

