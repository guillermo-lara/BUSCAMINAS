/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BUSCAMINAS;

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

/**
 *
 * @author g.lara.2022
 */
public class DEFAULT extends javax.swing.JFrame 
{
    File f = new File("C:\\BUSCAMINAS\\note");
    int ln=0;
    String Usuario, Contrasena;
    
    
    
    
    public DEFAULT()
    {
        textToAlmacenJ();
        initComponents();
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
                System.out.println("ARCHIVO CREADO");
            } catch(IOException ex1)
            {
                Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex1);
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
                MAIN.listaJ.add(jdr);
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
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void getJugador(String name,String psw)
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
                    PLAYER mJUGADOR = new PLAYER(aux);
                    mJUGADOR.setVisible(true);
                    this.setVisible(false);  
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
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
    void getAdmin(String name,String psw)
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile(f+"\\loginsA.txt","rw");
            for(int i =0; i<(ln-1); i+=3){
                Usuario = raf.readLine().substring(8);
                Contrasena = raf.readLine().substring(11);
                if(name.equals(Usuario) && psw.equals(Contrasena))
                {
                    ADMIN mADMIN = new ADMIN();
                    mADMIN.setVisible(true);
                    this.setVisible(false);  
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
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("BUSCAMINAS 2.0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("CONTRASEÑA:");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONA", "ADMIN", "JUGADOR" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        void setJugador(Jugador jgdr)
    {
        try {
            RandomAccessFile raf = new RandomAccessFile (f+"\\loginsJ.txt", "rw");
            for(int i = 0; i <ln;i++)
            {
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Usuario:"+jgdr.getNombre()+"\r\n");
            raf.writeBytes("Contrasena:"+jgdr.getContraseña()+"\r\n");
            raf.writeBytes("Partidas Jugadas:"+jgdr.getStats().getJugadas()+"\r\n");
            raf.writeBytes("Partidas Ganadas:"+jgdr.getStats().getGanadas()+"\r\n");
            raf.writeBytes("Partidas Perdidas:"+jgdr.getStats().getPerdidas()+"\r\n");
            raf.writeBytes("Minas a favor:"+jgdr.getStats().getMinas_a_favor()+"\r\n");
            raf.writeBytes("Minas en contra:"+jgdr.getStats().getMinas_en_contra()+"\r\n");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setAdmin(Administrador admin)
    {
        try {
            RandomAccessFile raf = new RandomAccessFile (f+"\\loginsA.txt", "rw");
            for(int i = 0; i <ln;i++)
            {
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Usuario:"+admin.getNombre()+"\r\n");
            raf.writeBytes("Contrasena:"+admin.getContraseña()+"\r\n");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(DEFAULT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name = jTextField1.getText();
        String psw = jPasswordField1.getText();
        String option = jComboBox1.getSelectedItem().toString();
        
        if(name.equals("")||psw.equals("")||option.equals("SELECCIONA"))
        {
            JOptionPane.showMessageDialog(rootPane, "FALTAN CAMPOS POR RELLENAR", "ERROR", 2);
        }
        else if(option.equals("JUGADOR"))
        {
            crearCarpeta();
            numeroLineas("C:\\BUSCAMINAS\\note\\loginsJ.txt");
            getJugador(name,psw);
        }
        else if(option.equals("ADMIN"))
        {
            crearCarpeta();
            numeroLineas("C:\\BUSCAMINAS\\note\\loginsA.txt");
            getAdmin(name,psw);
        }
        
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
            java.util.logging.Logger.getLogger(DEFAULT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DEFAULT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DEFAULT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DEFAULT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DEFAULT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
