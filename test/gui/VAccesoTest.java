/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class VAccesoTest {
    
    public VAccesoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of iniciarSesion method, of class VAcceso.
     */
    @Test
    public void testIniciarSesion() throws Exception {
        System.out.println("iniciarSesion");
        VAcceso instance = new VAcceso();
        instance.iniciarSesion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarUsuario method, of class VAcceso.
     */
    @Test
    public void testValidarUsuario() throws Exception {
        System.out.println("validarUsuario");
        String usuario = "camilo";
        String contrasena = "12345";
        VAcceso instance = new VAcceso();
        boolean expResult = false;
        boolean result = instance.validarUsuario(usuario, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarSQL method, of class VAcceso.
     */
    @Test
    public void testEjecutarSQL() throws Exception {
        System.out.println("ejecutarSQL");
        String sql = "SELECT * FROM usuario";
        VAcceso instance = new VAcceso();
        ResultSet expResult = null;
        ResultSet result = instance.ejecutarSQL(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}
