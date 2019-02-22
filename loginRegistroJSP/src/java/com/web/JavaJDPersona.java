/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.apache.*;

/**
 *
 * @author USUARIO
 */
public class JavaJDPersona {
        
  /*  public JavaJDPersona() {
        try{
            Class.forName("org.apache.derby.jdbc.clientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            
        }catch(Exception e){
                
                }
    }
    

    @Override
    public boolean guardarPersona(Persona persona) {
        
        
        try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB","usuario","pass");){
        String query = "INSERT INTO persona VALUES('"+ persona.getNombre()+"'," + persona.getEdad() + ");";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        return true;
        }catch(Exception e){
            return false;
        }          
    }

    @Override
    public Persona leerPersona() {
        try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonasDB","usuario","pass");){
            String query = "SELECT nombre,edad FROM persona;";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if(res.next()){
                String nombre = res.getString("nombre");
                int edad = res.getInt("edad");
                return new Persona(nombre, edad);
            }
            return null;
        }catch(Exception e){
            return null;
        }
   }*/
    
}
