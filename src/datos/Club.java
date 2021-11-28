/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Acer
 */
public class Club {
    
    private int idClub;
    private Jugador jugadores[];
    private String nombre;
    private String Historia;

    public Club() {
    }

    public Club(int idClub, Jugador[] jugadores, String nombre, String Historia) {
        this.idClub = idClub;
        this.jugadores = jugadores;
        this.nombre = nombre;
        this.Historia = Historia;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return Historia;
    }

    public void setHistoria(String Historia) {
        this.Historia = Historia;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }
    
}
