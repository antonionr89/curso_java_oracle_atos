/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import modelo.Persona;
import modelo.logica.*;

/**
 *
 * @author USUARIO
 */
public class FicheroPersona implements IPersonaDAO{
    public static final String fichero = "C:/Users/USUARIO/Desktop";
    
    
    private static final  FicheroPersona instance = new FicheroPersona();
    private FicheroPersona(){
        
    }
    public static FicheroPersona getInstance(){
        return instance;
    }
    
    @Override
    public boolean guardarPersona(Persona persona){
        try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero + "/persona.dat"));
        oos.writeObject(persona);
        oos.close();
        return true;
        }catch(Exception e){
        return false;
        }
    }
    
    @Override
    public Persona leerPersona(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero + "/persona.dat"));
            Persona p = (Persona) ois.readObject();
            ois.close();
            return p;
        }catch(Exception e){
            return null;
        }
    }
    
}
