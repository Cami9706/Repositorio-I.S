/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.VAcceso;
import gui.VAdministrador;
import gui.VClub;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class SQLMetodos {

    Connection conexion;
    PreparedStatement sentenciaPreparada;
    ResultSet resultado;
    String sql;
    VAdministrador VenAdministrador = new VAdministrador();
    VClub VenClub = new VClub();
    VAcceso VenAcceso= new VAcceso();
    
    public void buscarUsuario(String usuario, String contraseña) {

        String tipoPermiso;
        try {
            conexion = ConexionSQLServer.conectar();
            //sql= "SELECT usuario,contraseña FROM usuarios WHERE usuario='"+usuario+"'and contraseña ='"+contraseña+"'";
            sql = "SELECT * FROM usuarios WHERE usuario='" + usuario + "'and contraseña ='" + contraseña + "'";
            sentenciaPreparada = conexion.prepareStatement(sql);
            resultado = sentenciaPreparada.executeQuery();
            if (resultado.next()) {
                usuario = resultado.getString("usuario");
                contraseña = resultado.getString("contraseña");

                if (usuario != null && contraseña != null) {
                    tipoPermiso = resultado.getString("permisos");
                    switch(tipoPermiso){
                        case "administrador":
                            VenAdministrador.setVisible(true);    
                            break;
                        case "visitante": 
                            VenClub.setVisible(true);
                            break;                         
                    }
                }
                //VenAdministrador.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error en usuario o contraseña, por favor verificar");       
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
