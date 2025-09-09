/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Buscaminas;
import Interfaces.*;
import Clases.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class main 
{
    public static ArrayList<Clases.Jugador> listaJ = new ArrayList();
    public static ArrayList<Clases.Partida> listaP = new ArrayList();
   // public static int ln_J;
   // public static int[] ln_P;
    public static File archivo = new File("C:\\Buscaminas");
    public static File FJ = new File("C:\\Buscaminas\\lista_j");
    public static File FP = new File("C:\\Buscaminas\\lista_p");

    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        if (!archivo.exists()){
        archivo.mkdirs();
        }
        fileToListaJ();
        fileToListaP();
        Interfaces.InicioSesion Comienzo = new Interfaces.InicioSesion();
        Comienzo.setVisible(true);
    }
   
    public static void fileToListaJ() throws IOException, ClassNotFoundException { 
        try 
        {
            long aux2 = FJ.getTotalSpace();
            if (aux2 == 0)
            {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FJ));
                Clases.Estadisticas stats= new Clases.Estadisticas(0, 0, 0, 0, 0);
                Clases.Jugador jgdr = new Clases.Jugador("Antonio","1234",stats);
                oos.writeObject(jgdr);
                main.listaJ.add(0,jgdr);
            }
            else
            {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FJ));
                while (true) {
                try {
                    Clases.Jugador jgdr = (Clases.Jugador) ois.readObject();
                main.listaJ.add(0,jgdr);
                } catch (EOFException eof) {
                    break;
                }
            }
                ois.close();
                
            }
        } 
        catch (FileNotFoundException ex) 
        {
        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void fileToListaP() throws IOException, ClassNotFoundException { 
        try 
        {
            long aux2 = FP.getTotalSpace();
            BufferedReader br = new BufferedReader(new FileReader(FP));
            if (aux2 == 0)
            {
                FileWriter fichero = new FileWriter(Buscaminas.main.FP);
                PrintWriter pw = new PrintWriter(fichero);
                pw.write("");
            }
            else
            {
                 if (br.readLine() == null) 
                 {
                     
            }else{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FP));
                while (true) {
                try {
                Clases.Partida partida = (Clases.Partida) ois.readObject();
                main.listaP.add(partida);
                } catch (EOFException eof) {
                    break;
                }
            }
                ois.close();
                
            }
            }
        } 
        catch (FileNotFoundException ex) 
        {
        }
    } 
    
    
    
    
    
 /*   public static int numeroLineas(String adress)
    {
        int ln=1;
        try
        {
            RandomAccessFile raf = new RandomAccessFile(adress,"rw");
            for(int i=0; raf.readLine()!= null; i++)
            {
                ln++;
            }
            ln--;
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ln;
    }
*/    
    
    
    //PARA ABRIR:
    //TEAM -> GIT -> CLONE
    //PARA SUBIR:
    //TEAM -> COMMIT
    //TEAM -> PUSH
}
