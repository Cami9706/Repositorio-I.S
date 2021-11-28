/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Date;


/**
 *
 * @author Acer
 */
public class Jugador {
    
    private int idJugador;
    private int num_documento;
    private String nombres;
    private String apellidos;
    private float telefono;
    private String idposicion;
    private int estatura;
    private int peso;
    private int tiempoContrato;
    private float precioMercado;

    public Jugador() {
    }

    public Jugador(int idJugador, int num_documento, String nombres, String apellidos, float telefono, String idposicion, int estatura, int peso, int tiempoContrato, float precioMercado) {
        this.idJugador = idJugador;
        this.num_documento = num_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.idposicion = idposicion;
        this.estatura = estatura;
        this.peso = peso;
        this.tiempoContrato = tiempoContrato;
        this.precioMercado = precioMercado;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(String idposicion) {
        this.idposicion = idposicion;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public float getPrecioMercado() {
        return precioMercado;
    }

    public void setPrecioMercado(int precioMercado) {
        this.precioMercado = precioMercado;
    }
    
    
    
}
