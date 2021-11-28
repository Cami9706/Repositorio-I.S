/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import util.ConexionSQLServer;
import java.sql.Connection;
/**
 *
 * @author Acer
 */
public class Ejemplo {
    public static void  main(String[] args){
       
        
       System.out.println("Probando persistencia");
        ConexionSQLServer mc = new ConexionSQLServer();
        Connection mx = mc.conectar();
        System.out.println(mx);
    }
}
