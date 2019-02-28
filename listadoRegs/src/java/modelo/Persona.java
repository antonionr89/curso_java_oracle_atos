/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Persona {
    private String nombre;
    private String user;
    private String pass;
    private int edad;

    public Persona(String nombre, int edad,String user,String pass) {
        this.nombre = nombre;
        this.edad = edad;
        this.user = user;
        this.pass = pass;
    }
    public Persona(String user,String pass) {
        this.user = user;
        this.pass = pass;
    }

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUser() {
        return user;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
