/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datos.Club;
import datos.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ConexionSQLServer;

/**
 *
 * @author Camilo Andres Riaño
 */
public class VVentas extends javax.swing.JFrame {

    PreparedStatement sentenciaPreparada;
    ResultSet resultado;
    DefaultComboBoxModel comboClubes = new DefaultComboBoxModel();
    DefaultComboBoxModel ComboClubesVenta = new DefaultComboBoxModel();
    DefaultComboBoxModel comboVentas = new DefaultComboBoxModel();
    DefaultComboBoxModel comboJugadores = new DefaultComboBoxModel();
    ArrayList<Jugador> jugadores = new ArrayList();

    public VVentas() throws SQLException {
        initComponents();
        inicializarComponentes();
    }

    void inicializarComponentes() throws SQLException {
        inicializarClubes();
        inicializarClubesTransferencia();
        inicializarTipoventa();
        seleccionarJugadores();
    }

    void inicializarClubes() throws SQLException {
        String sql = "SELECT * FROM club ORDER BY nombreClub ASC";
        ResultSet resultado = ejecutarSQL(sql);
        comboClubes.addElement("Seleccionar");
        while (resultado.next()) {
            comboClubes.addElement(resultado.getString("nombreClub"));
        }
        boxClub.setModel(comboClubes);
    }

    void inicializarTipoventa() {
        comboVentas.removeAllElements();
        comboVentas.addElement("Seleccionar");
        comboVentas.addElement("Precio Neto");
        comboVentas.addElement("Intercambio");
        boxVenta.setModel(comboVentas);
    }

    void inicializarClubesTransferencia() throws SQLException {
        String sql = "SELECT * FROM club ORDER BY nombreClub ASC";
        ResultSet resultado = ejecutarSQL(sql);
        ComboClubesVenta.addElement("Seleccionar");
        while (resultado.next()) {
            ComboClubesVenta.addElement(resultado.getString("nombreClub"));
        }
        boxClubVenta.setModel(ComboClubesVenta);
    }

    ResultSet ejecutarSQL(String sql) throws SQLException {
        Connection conexion;
        conexion = ConexionSQLServer.conectar();
        sentenciaPreparada = conexion.prepareStatement(sql);
        resultado = sentenciaPreparada.executeQuery();

        return resultado;
    }

    void seleccionarJugadores() throws SQLException {
        String nombreClub = (String) boxClub.getSelectedItem();
        Club club = buscarClubNombre(nombreClub);
        String sql = "SELECT j.* FROM jugador j WHERE j.idClub = " + club.getIdClub();
        ResultSet resultado = ejecutarSQL(sql);
        while (resultado.next()) {
            int idJugador = Integer.parseInt(resultado.getString("idjugador"));
            int num_documento = Integer.parseInt(resultado.getString("num_documento"));
            String nombres = resultado.getString("nombres");
            String apellidos = resultado.getString("apellidos");
            float telefono = Float.parseFloat(resultado.getString("telefono"));
            String idposicion = resultado.getString("idposicion");
            int estatura = Integer.parseInt(resultado.getString("estatura"));
            int peso = Integer.parseInt(resultado.getString("peso"));
            int tiempoContrato = Integer.parseInt(resultado.getString("tiempoContrato"));
            float precioMercado = Float.parseFloat(resultado.getString("precioMercado"));
            Jugador jugador = new Jugador(idJugador, num_documento, nombres, apellidos, telefono, idposicion, estatura, peso, tiempoContrato, precioMercado);
            jugadores.add(jugador);
        }
        for (Jugador jug : jugadores) {
            System.out.println(jug.getNombres());
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Posición");
        modelo.addColumn("Meses de contrato");
        modelo.addColumn("Precio del Jugador");
        tableJugadores.setModel(modelo);

        String datos[] = new String[4];
        for (int i = 0; i < jugadores.size(); i++) {
            datos[0] = String.valueOf(jugadores.get(i).getNombres());
            datos[1] = String.valueOf(jugadores.get(i).getIdposicion());
            datos[2] = String.valueOf(jugadores.get(i).getTiempoContrato());
            datos[3] = String.valueOf(jugadores.get(i).getPrecioMercado());
            modelo.addRow(datos);
        }
        tableJugadores.setModel(modelo);
    }

    void mostrarJugadores() throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Posición");
        modelo.addColumn("Meses de contrato");
        modelo.addColumn("Precio del Jugador");
        tableJugadores.setModel(modelo);

       
        String datos[] = new String[4];
        for (int i = 0; i < jugadores.size(); i++) {
            datos[0] = String.valueOf(jugadores.get(i).getNombres());
            datos[1] = String.valueOf(jugadores.get(i).getIdposicion());
            datos[2] = String.valueOf(jugadores.get(i).getTiempoContrato());
            datos[3] = String.valueOf(jugadores.get(i).getPrecioMercado());
            modelo.addRow(datos);
            
        }
        tableJugadores.setModel(modelo);                   
    }

    Club buscarClubNombre(String nombre) throws SQLException {
        Club club = new Club();
        String sql = "SELECT * FROM club WHERE nombreClub = '" + nombre + "'";
        ResultSet resultado = ejecutarSQL(sql);
        if (resultado.next()) {
            club.setIdClub(Integer.parseInt(resultado.getString("idClub")));
            club.setNombre(resultado.getString("nombreClub"));
            club.setHistoria(resultado.getString("historia"));
        }
        return club;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxClubVenta = new javax.swing.JComboBox<>();
        boxClub = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJugadores = new javax.swing.JTable();
        boxVenta = new javax.swing.JComboBox<>();
        btnTransferir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UsuarioA.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VENTAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        boxClubVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boxClubVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Club a transferir", "" }));
        boxClubVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClubVentaActionPerformed(evt);
            }
        });
        jPanel1.add(boxClubVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 240, -1));

        boxClub.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boxClub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Club" }));
        boxClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClubActionPerformed(evt);
            }
        });
        jPanel1.add(boxClub, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, -1));

        jScrollPane1.setViewportView(tableJugadores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 420, 170));

        boxVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boxVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIipo de venta", "" }));
        jPanel1.add(boxVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 240, -1));

        btnTransferir.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btnTransferir.setText("TRANSFERIR");
        jPanel1.add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 240, -1));

        btnVolver.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 240, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("que deseas transferir:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Selecciona el jugador:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("transferir el jugador:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Selecciona el club al cual pertenece el jugador");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Selecciona el club al cual deseas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon2.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 120, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon1.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 120, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f3.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VAdministrador va = new VAdministrador();
        this.setVisible(false);
        va.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void boxClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClubActionPerformed
        try {
            seleccionarJugadores();

        } catch (SQLException ex) {
            Logger.getLogger(VVentas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boxClubActionPerformed

    private void boxClubVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClubVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxClubVentaActionPerformed

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
            java.util.logging.Logger.getLogger(VVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VVentas().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(VVentas.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxClub;
    private javax.swing.JComboBox<String> boxClubVenta;
    private javax.swing.JComboBox<String> boxVenta;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJugadores;
    // End of variables declaration//GEN-END:variables
}
