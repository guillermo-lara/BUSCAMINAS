/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Movimientos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

/**
 *
 * @author g.lara.2022
 */
public class VerPartida extends javax.swing.JFrame {

    int numFilas=16;
    int numColumnas=16;
    JButton[][] botonesTablero;    
    private Clases.Partida p;
    
    public VerPartida(Clases.Partida partida) 
    {
        this.p = partida;
        this.setResizable(false);        
        String aux1= cargarMovimientos(this.p.getMoves(),this.p.getJugador_1().getNombre());
        String aux2= cargarMovimientos(this.p.getMoves(),this.p.getJugador_2().getNombre());
        initComponents();
        this.jLabel1.setText(this.p.getJugador_2().getNombre()+" "+this.p.getMarcador().getPuntos_J1());
        this.jLabel2.setText(this.p.getJugador_1().getNombre()+" "+this.p.getMarcador().getPuntos_J2());
        this.jTextArea1.setText(aux1);
        this.jTextArea2.setText(aux2);
        cargarControles();
    }
    
    private String cargarMovimientos(ArrayList<Movimientos> lista, String jugador)
    {
        String resultado = "";
        for(int i = 0; i < lista.size(); i++)
        {
            if (!jugador.equals(lista.get(i).getNombre_jugador()))
            {
                resultado = resultado+ String.valueOf(i+1)+"º "+String.valueOf(lista.get(i).getCoordenadaY()+1)+ " "+ String.valueOf(lista.get(i).getCoordenadaX()+1)+ "\n";
            }
        }
        return resultado;
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
                comprobarMovimiento(i,j);
                getContentPane().add(botonesTablero[i][j]);
            }
        }
    }
    
    
    private void comprobarMovimiento(int x, int y)
    {

        
          if(comprobarMina(x,y) == true)
          {
              botonesTablero[x][y].setBackground(Color.red);
          }
          if(comprobarAdyacente(x,y)==true)
          {
            mostrarAdyacentes(x,y);
          }
          if(comprobarBlanco(x,y)==true)
          {
            botonesTablero[x][y].setBackground(Color.GRAY);
          }
    }        
         
    private int toPosicion(int x, int y)
    {
        return (x*16+y);
    } 


    private boolean comprobarMina(int x, int y)
    {
        if("MINA".equals(this.p.getTablero().getLista().get(toPosicion(x,y)).getSimbolo_oculto()))
        {

            return true;
        }
            return false;
    }
    
    private boolean comprobarAdyacente(int x, int y)
    {
        return "ADYACENTE".equals(this.p.getTablero().getLista().get(toPosicion(x,y)).getSimbolo_oculto());
    }   
    
    private void mostrarAdyacentes(int x, int y)
    {
        if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==1)
            {
                botonesTablero[x][y].setBackground(Color.red);
                botonesTablero[x][y].setText("1");
            }
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==2)
            {
                botonesTablero[x][y].setBackground(Color.yellow);
                botonesTablero[x][y].setText("2");
            }    
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==3)
            {
                botonesTablero[x][y].setBackground(Color.green);
                botonesTablero[x][y].setText("3");
            }          
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==4)
            {
                botonesTablero[x][y].setBackground(Color.blue);
                botonesTablero[x][y].setText("4");
            }          
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==5)
            {
                botonesTablero[x][y].setBackground(Color.MAGENTA);
                botonesTablero[x][y].setText("5");
            }
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==6)
            {
                botonesTablero[x][y].setBackground(Color.ORANGE);
                botonesTablero[x][y].setText("6");
            }
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==7)
            {
                botonesTablero[x][y].setBackground(Color.black);
                botonesTablero[x][y].setText("7");
            }
            if(this.p.getTablero().getLista().get(toPosicion(x,y)).getContador()==8)
            {
                botonesTablero[x][y].setBackground(Color.gray);
                botonesTablero[x][y].setText("8");
            }

    }
    
    
    private boolean comprobarBlanco(int x, int y)
    {
            return "BLANCO".equals(this.p.getTablero().getLista().get(toPosicion(x,y)).getSimbolo_oculto());
    }     
    
    
    private VerPartida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(858, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(520, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Interfaces.Administrador mADMIN = new Interfaces.Administrador();
        mADMIN.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VerPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
