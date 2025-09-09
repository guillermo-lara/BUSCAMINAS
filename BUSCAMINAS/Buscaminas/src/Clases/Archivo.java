/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Buscaminas.*;
import Interfaces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Archivo
{
    File f ;
    int ln=0;

    public Archivo()
    {
        File f= new File("C:\\BUSCAMINAS\\note");
    }

    public Archivo(File f) {
        this.f = f;
    }
    
    
    
    
    
    
    
    private void crearCarpeta()
    {
        if(!f.exists())
        {
            f.mkdirs();
        }
    }
    
    private void leerArchivo() 
    {
        try{
            FileReader fr = new FileReader(f+"\\logins,txt");
            System.err.println("EXISTE EL ARCHIVO");
        } catch (FileNotFoundException ex)
        {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
            } catch(IOException ex1)
            {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
   
    private void textToAlmacenJ()
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(f+"\\loginsJ.txt","rw");
            numeroLineas("C:\\BUSCAMINAS\\note\\loginsJ.txt");
            for(int i =0; i<(ln-1); i+=8)
            {
                Jugador jdr = new Jugador(
                 raf.readLine().substring(8),
                 raf.readLine().substring(11)
                );
                Estadisticas sts = new Estadisticas (
                 Integer.parseInt(raf.readLine().substring(17)),
                 Integer.parseInt(raf.readLine().substring(17)),
                 Integer.parseInt( raf.readLine().substring(18)),
                 Integer.parseInt(raf.readLine().substring(14)),
                 Integer.parseInt(raf.readLine().substring(16))
                );
                
                jdr.setStats(sts);
                Buscaminas.main.listaJ.add(jdr);
                if (i ==(ln-8)-i/8)
                {
                   break;
                }
                for(int k=1; k<=2;k++)
                {
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void getJugador(String name,String psw,String Usuario,String Contrasena)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(f+"\\loginsJ.txt","rw");
            for(int i =0; i<(ln-1); i+=8){
                Usuario = raf.readLine().substring(8);
                Contrasena = raf.readLine().substring(11);
                if(name.equals(Usuario)& psw.equals(Contrasena))
                {
                    int aux = i/8;
                   /**
                    Jugador mJUGADOR = new Jugador(aux);
                    mJUGADOR.setVisible(true);
                    this.setVisible(false);
                    */
                    break;
                }else if (i==(ln-8)-i/8)
                {
                   JOptionPane.showMessageDialog(null, "Usuario/Contraseña erroneo");
                   break;
                }
                for(int k=1; k<=7;k++)
                {
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
    void getAdmin(String name,String psw,String Usuario,String Contrasena)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(f+"\\loginsA.txt","rw");
            for(int i =0; i<(ln-1); i+=3){
                Usuario = raf.readLine().substring(8);
                Contrasena = raf.readLine().substring(11);
                if(name.equals(Usuario) && psw.equals(Contrasena))
                {
                    Interfaces.Administrador mADMIN = new Interfaces.Administrador();
                    mADMIN.setVisible(true);
                    //this.setVisible(false);  
                    break;
                }if(i==(ln-3)-i/3){
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña erroneo");
                break;
                }
                for(int k=1; k<=2;k++)
                {
                    raf.readLine();
                }
            }
            

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        
    private void numeroLineas(String adress)
    {
        try
        {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(adress,"rw");
            for(int i=0; raf.readLine()!= null; i++)
            {
                ln++;
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
