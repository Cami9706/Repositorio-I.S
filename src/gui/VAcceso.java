/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.ConexionSQLServer;
import util.SQLMetodos;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class VAcceso extends javax.swing.JFrame {
    PreparedStatement sentenciaPreparada;
    ResultSet resultado;
    
    /**
     * Creates new form VAcceso
     */
    public VAcceso() {
        initComponents();
    }
    
    void iniciarSesion() throws SQLException{
        String usuario = txtUsuario.getText();
        String contrasena = txtContraseña.getText();
        
        if(usuario.length() < 1){
            JOptionPane.showMessageDialog(this, "El campo de Usuario no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(contrasena.length() < 1){
            JOptionPane.showMessageDialog(this, "El campo de Contraseña no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean band = validarUsuario(usuario,contrasena);
        System.out.println("Inicia el llamado");
        //metodos.buscarUsuario(usuario, contrasena);
        System.out.println("Finaliza el llamado");
        
    }
    
    boolean validarUsuario(String usuario, String contrasena) throws SQLException{       
        String usuarioDb="";
        String contrasenaDb="";
        String tipoPermiso="";
        
        String sql = "SELECT * FROM usuarios WHERE usuario='" + usuario + "'and contraseña ='" + contrasena + "'";
        ResultSet resultado = ejecutarSQL(sql);
        if (resultado.next()) {
                usuarioDb = resultado.getString("usuario");
                contrasenaDb = resultado.getString("contraseña");

                if (usuario != null && contrasena != null) {
                    tipoPermiso = resultado.getString("permisos");
                    switch(tipoPermiso){
                        case "administrador":
                            VAdministrador va = new VAdministrador();
                            this.setVisible(false);
                            va.setVisible(true);
                            System.out.println("Es administrador");
                            break;
                        case "visitante": 
                            //VenClub.setVisible(true);
                            System.out.println("Es visitante");
                            break;                         
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor valide usuario y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }    
    
    ResultSet ejecutarSQL(String sql) throws SQLException{
        Connection conexion;
        conexion = ConexionSQLServer.conectar();       
        sentenciaPreparada = conexion.prepareStatement(sql);
        resultado = sentenciaPreparada.executeQuery();
        
        return resultado;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UsuarioA.png"))); // NOI18N
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setForeground(new java.awt.Color(222, 0, 222));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f2.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 400, 500));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ob1 (1).jpg"))); // NOI18N
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("USUARIO");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("INICIAR SESIÓN");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setToolTipText("Ingrese el Usuario");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        bg.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 330, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CONTRASEÑA");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        bg.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 110, -1));

        btnIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        bg.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 110, -1));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        bg.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 330, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            iniciarSesion();
        } catch (SQLException ex) {
            Logger.getLogger(VAcceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
          this.salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(VAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


    private void salir() {
        System.exit(0);
    }
}
