/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Persona;
import modelo.persistencia.JavaJDPersona;


/**
 *
 * @author USUARIO
 */
public class GestionPersona {
    
    private static GestionPersona instance;
    
    private JavaJDPersona javaDB = new JavaJDPersona();
    private GestionPersona(){
        
    }
    public static GestionPersona getInstance(){
        if(instance == null) instance = new GestionPersona();
        return instance;
    }
    
    public enum TipoResultado{OK,SIN_VALORES,EDAD_MAL,ERROR_IO};
    
    public TipoResultado guardarPersona(String nombre,String edad,String user,String pass){
        if(validarDatosPersona(nombre, edad)){
            if(validarEdad(edad)){
                int iEdad = Integer.parseInt(edad);
                if(javaDB.guardarPersona(new Persona(nombre, iEdad,user,pass))){
                return TipoResultado.OK;
                }else{
                    return TipoResultado.ERROR_IO;
                } 
            }else{
                return TipoResultado.EDAD_MAL;
            }
        }else{
            return TipoResultado.SIN_VALORES;
        }
    }
   public Persona getPersona(){
        return javaDB.leerPersona();
    }
    public boolean validarDatosPersona(String nombre,String edad){
           return ! nombre.isEmpty() && ! edad.isEmpty();
    }
    
    public boolean validarEdad(String edad){
        if(Integer.parseInt(edad) > 17){
        return true;
        }
        else{
            return false;
        }

    }
    
    
}
