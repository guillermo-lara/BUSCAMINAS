/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Buscaminas.main;
import static Buscaminas.main.FJ;
import static Buscaminas.main.FP;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class Tablero extends javax.swing.JFrame 
{
    int jugadorJugando;
    int jugadorEsperando;
    int jugador1;
    int jugador2;
    int minasEncontradas = 0;
    Clases.Marcador marcador = new Clases.Marcador();
    ArrayList<Clases.Movimientos> movimientos = new ArrayList<>();
    int numFilas=16;
    int numColumnas=16;
    JButton[][] botonesTablero;
    Clases.Tablero tablero;
    
    

    
    
    public Tablero(int jugador1, int jugador2)
    {
        this.setResizable(false);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorJugando =jugador1;
        this.jugadorEsperando = jugador2;
        this.marcador.setPuntos_J1(0);
        this.marcador.setPuntos_J2(0);
        crearTablero();
        initComponents();
        cargarControles();
        jLabel3.setText(Buscaminas.main.listaJ.get(jugador1).getNombre());
        jLabel2.setText(Buscaminas.main.listaJ.get(jugador2).getNombre());
        jLabel4.setText("0");
        jLabel5.setText("0");
    }
    
    
    
    public Tablero() 
    {
        crearTablero();
        initComponents();
        cargarControles();
    }

    public int getJugadorJugando() {
        return jugadorJugando;
    }

    public void setJugadorJugando(int jugadorJugando) {
        this.jugadorJugando = jugadorJugando;
    }

    public int getJugadorEsperando() {
        return jugadorEsperando;
    }

    public void setJugadorEsperando(int jugadorEsperando) {
        this.jugadorEsperando = jugadorEsperando;
    }

    public int getJugador1() {
        return jugador1;
    }

    public void setJugador1(int jugador1) {
        this.jugador1 = jugador1;
    }

    public int getJugador2() {
        return jugador2;
    }

    public void setJugador2(int jugador2) {
        this.jugador2 = jugador2;
    }

    public int getMinasEncontradas() {
        return minasEncontradas;
    }
    
    
    
// x = i = columna ; y = j = fila
    
    
    
    private void crearTablero()
    {
        tablero = new Clases.Tablero();
    }
 
        private void cargarControles()
    {
        int X=200;
        int Y=250;
        int ancho=30;
        int alto=30;
        
        botonesTablero = new JButton[numFilas][numColumnas];
        for(int i = 0; i < botonesTablero.length; i++)
        {
            for(int j = 0; j < botonesTablero.length; j++)
            {
                botonesTablero[i][j] = new JButton();
                botonesTablero[i][j].setName(i+"."+j);
                botonesTablero[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));

                if(i==0 && j==0)
                {
                    botonesTablero[i][j].setBounds(X,Y,ancho,alto);
                }
                else if (i==0 && j!=0)
                {
                    
                     botonesTablero[i][j].setBounds(botonesTablero[i][j-1].getX()+botonesTablero[i][j-1].getWidth(),Y,ancho,alto );
                }
                else
                {
                     botonesTablero[i][j].setBounds(botonesTablero[i-1][j].getX(),botonesTablero[i-1][j].getY()+botonesTablero[i-1][j].getHeight(),ancho,alto);
                }
                
                botonesTablero[i][j].addActionListener(listener);
                getContentPane().add(botonesTablero[i][j]);
            }
        }
    }
     
        
        
    ActionListener listener = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    btnClick(e);
                } catch (IOException ex) {
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
         
         
         
        private void btnClick(ActionEvent e) throws IOException
     {
        JButton btn = (JButton)e.getSource();
        String[] coordenada = btn.getName().split("\\.");
        int posY = (int) Integer.parseInt(coordenada[1]);
        int posX = (int) Integer.parseInt(coordenada[0]);
        
        comprobarMovimiento(posX,posY);
        
        for(int i = 0; i < botonesTablero.length; i++) //Actualizo el Tablero
        {
        jLabel4.setText(Integer.toString(marcador.getPuntos_J1()));
        jLabel5.setText(Integer.toString(marcador.getPuntos_J2()));
        for(int j = 0; j < botonesTablero.length; j++)
            {     
                getContentPane().add(botonesTablero[i][j]);
            }
        }
        comprobarFinPartida();
     }
    

        
    private void comprobarMovimiento(int x, int y)
    {
        Clases.Movimientos aux = new Clases.Movimientos(x,y,Buscaminas.main.listaJ.get(jugadorJugando).getNombre());
        movimientos.add(aux);
        
          if(comprobarMina(x,y) == true)
          {
              botonesTablero[x][y].setBackground(Color.red);
              this.minasEncontradas++;
          }
          if(comprobarAdyacente(x,y)==true)
          {
            mostrarAdyacentes(x,y);
            cambiarJugador();
          }
          if(comprobarBlanco(x,y)==true)
          {
            botonesTablero[x][y].setBackground(Color.GRAY);
            mostrarBlancos(x,y);
            cambiarJugador();
          }
          botonesTablero[x][y].removeActionListener(listener);
    }        
        
     
    private int toPosicion(int x, int y)
    {
        return (x*16+y);
    } 


    private boolean comprobarMina(int x, int y)
    {
        if("MINA".equals(this.tablero.getLista().get(toPosicion(x,y)).getSimbolo_oculto()))
        {
            if(jugador1 == jugadorJugando)
            {
            marcador.addPuntos_J1();
            }
            else if(jugador2 == jugadorJugando)
            {
            marcador.addPuntos_J2();
            }
            
            return true;
        }
            return false;
    }
    
    private boolean comprobarAdyacente(int x, int y)
    {
        return "ADYACENTE".equals(this.tablero.getLista().get(toPosicion(x,y)).getSimbolo_oculto());
    }   
    
    private void mostrarAdyacentes(int x, int y)
    {
        if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==1)
            {
                botonesTablero[x][y].setBackground(Color.red);
                botonesTablero[x][y].setText("1");
            }
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==2)
            {
                botonesTablero[x][y].setBackground(Color.yellow);
                botonesTablero[x][y].setText("2");
            }    
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==3)
            {
                botonesTablero[x][y].setBackground(Color.green);
                botonesTablero[x][y].setText("3");
            }          
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==4)
            {
                botonesTablero[x][y].setBackground(Color.blue);
                botonesTablero[x][y].setText("4");
            }          
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==5)
            {
                botonesTablero[x][y].setBackground(Color.MAGENTA);
                botonesTablero[x][y].setText("5");
            }
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==6)
            {
                botonesTablero[x][y].setBackground(Color.ORANGE);
                botonesTablero[x][y].setText("6");
            }
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==7)
            {
                botonesTablero[x][y].setBackground(Color.black);
                botonesTablero[x][y].setText("7");
            }
            if(this.tablero.getLista().get(toPosicion(x,y)).getContador()==8)
            {
                botonesTablero[x][y].setBackground(Color.gray);
                botonesTablero[x][y].setText("8");
            }

    }
    
    
    private boolean comprobarBlanco(int x, int y)
    {
            return "BLANCO".equals(this.tablero.getLista().get(toPosicion(x,y)).getSimbolo_oculto());
    }     
    
    
    private void mostrarBlancos(int x, int y)
    {
        
        for(int i = 0; i<8; i++)
        {
        int colum = x;
        int fila = y;
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
            if(fila <= 15 && colum <= 15 && fila >=0 && colum >=0)
            {
                if(comprobarBlanco(colum,fila)==true && botonesTablero[colum][fila].getBackground() != Color.GRAY)
                {
                    botonesTablero[colum][fila].setBackground(Color.GRAY);
                    botonesTablero[colum][fila].removeActionListener(listener);
                    mostrarBlancos(colum,fila);
                }                
                else if(comprobarAdyacente(colum,fila)==true)
                {
                    mostrarAdyacentes(colum,fila);
                    botonesTablero[colum][fila].removeActionListener(listener);
                }
     
            }
        }
    }
    
    
  
    
    
  
    
    
    private void cambiarJugador()
    {
        int antiguoTemp = getJugadorJugando();
        int nuevoTemp = getJugadorEsperando();
        this.jugadorJugando = nuevoTemp;
        setJugadorJugando(nuevoTemp);
        setJugadorEsperando(antiguoTemp);
        if (main.listaJ.get(antiguoTemp).getNombre().equals(jLabel2.getText())== true)
        {
            jLabel2.setForeground(Color.red);
            jLabel3.setForeground(Color.black);
        }else{
        jLabel3.setForeground(Color.red);
        jLabel2.setForeground(Color.black);
        }
    }



    
    private void comprobarFinPartida() throws FileNotFoundException, IOException
    {
 
        if(getMinasEncontradas()==51)
        {
        Clases.Partida partida = new Clases.Partida(main.listaJ.get(this.jugador1), main.listaJ.get(this.jugador2), this.tablero, movimientos, marcador);
        Buscaminas.main.listaP.add(partida);
        FileWriter fichero = new FileWriter(Buscaminas.main.FP);
        PrintWriter pw = new PrintWriter(fichero);
        pw.write("");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Buscaminas.main.FP));
        
        for(int i = 0; i < main.listaP.size() ; i++)
        {
            oos.writeObject(main.listaP.get(i));
        }
            oos.close();
           
            if(marcador.getPuntos_J1()>marcador.getPuntos_J2()) //HA GANADO J2
            {
                Clases.Estadisticas aux2 = Buscaminas.main.listaJ.get(this.jugador1).getStats();
                Clases.Estadisticas aux1 = new Clases.Estadisticas(aux2.getJugadas()+1,aux2.getGanadas(), aux2.getPerdidas()+1,aux2.getMinas_a_favor() +marcador.getPuntos_J2(),aux2.getMinas_en_contra()+marcador.getPuntos_J1());
                Clases.Estadisticas aux3 = Buscaminas.main.listaJ.get(this.jugador2).getStats();
                Clases.Estadisticas aux4 = new Clases.Estadisticas(aux3.getJugadas()+1, aux3.getGanadas()+1, aux3.getPerdidas(),aux3.getMinas_a_favor() +marcador.getPuntos_J1(),aux3.getMinas_en_contra()+marcador.getPuntos_J2());
                Clases.Jugador jdr1 = main.listaJ.get(this.jugador1);
                Clases.Jugador jdr2 = main.listaJ.get(this.jugador2);
                jdr1.setStats(aux1);
                jdr2.setStats(aux4);
                main.listaJ.set(this.jugador1, jdr1);
                main.listaJ.set(this.jugador2, jdr2);
                JOptionPane.showMessageDialog(null, Buscaminas.main.listaJ.get(jugador2).getNombre()+" ha ganado", "FELICIDADES", 2);
            } else //HA GANADO J1
            {
                Clases.Estadisticas aux2 = Buscaminas.main.listaJ.get(this.jugador1).getStats();
                Clases.Estadisticas aux1 = new Clases.Estadisticas(aux2.getJugadas()+1,aux2.getGanadas()+1, aux2.getPerdidas(),aux2.getMinas_a_favor() +marcador.getPuntos_J2(),aux2.getMinas_en_contra()+marcador.getPuntos_J1());
                Clases.Estadisticas aux3 = Buscaminas.main.listaJ.get(this.jugador2).getStats();
                Clases.Estadisticas aux4 = new Clases.Estadisticas(aux3.getJugadas()+1, aux3.getGanadas(), aux3.getPerdidas()+1,aux3.getMinas_a_favor() +marcador.getPuntos_J1(),aux3.getMinas_en_contra()+marcador.getPuntos_J2());
                Clases.Jugador jdr1 = main.listaJ.get(this.jugador1);
                Clases.Jugador jdr2 = main.listaJ.get(this.jugador2);
                jdr1.setStats(aux1);
                jdr2.setStats(aux4);
                main.listaJ.set(this.jugador1, jdr1);
                main.listaJ.set(this.jugador2, jdr2);
                JOptionPane.showMessageDialog(null, Buscaminas.main.listaJ.get(jugador1).getNombre()+" ha ganado", "FELICIDADES", 2);
            }
            
            FileWriter ficheroju = new FileWriter(Buscaminas.main.FJ);
            PrintWriter pwj = new PrintWriter(ficheroju);
            pwj.write("");
            ObjectOutputStream oosj = new ObjectOutputStream(new FileOutputStream(FJ));
            for(int i = 0; i < main.listaJ.size() ; i++)
            {
                oosj.writeObject(main.listaJ.get(i));
            }
            oosj.close();
            this.setVisible(false);
                Interfaces.Jugador jgdr = new Interfaces.Jugador(this.jugador1);
                jgdr.setVisible(true);        }
    }
    
  
    
         
 /*   void setMovimiento(ArrayList<Clases.Movimientos> moves)
    {
        try {
            FileWriter fw = new FileWriter(f+"\\"+MAIN.listaJ.get(jugador1).getNombre()+MAIN.listaJ.get(jugador2).getNombre()+".txt");
            RandomAccessFile raf = new RandomAccessFile (f+"\\"+MAIN.listaJ.get(jugador1).getNombre()+MAIN.listaJ.get(jugador2).getNombre()+".txt", "rw");
            for(int i = 0; i <ln;i++)
            {
            raf.writeBytes(moves.get(i).getNombre_jugador()+moves.get(i).getCoordenadaX()+moves.get(i).getCoordenadaY()+"\r\n");
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
  */
     
     
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelMarcador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("BUSCAMINAS");

        jLabelMarcador.setText("MARCADOR:");

        jLabel2.setText("name_1");

        jLabel3.setText("name_2");

        jLabel4.setText("score_1");

        jLabel5.setText("score_2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMarcador)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMarcador)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addContainerGap(696, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelMarcador;
    // End of variables declaration//GEN-END:variables


}





