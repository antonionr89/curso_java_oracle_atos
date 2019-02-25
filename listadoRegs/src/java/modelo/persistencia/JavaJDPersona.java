/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Persona;
import modelo.logica.IPersonaDAO;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author USUARIO
 */
public class JavaJDPersona implements IPersonaDAO{

    public String getUserDB() {
        return userDB;
    }

    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

    public String getPassDB() {
        return passDB;
    }

    public void setPassDB(String passDB) {
        this.passDB = passDB;
    }

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }

    public int getEdadDB() {
        return edadDB;
    }

    public void setEdadDB(int edadDB) {
        this.edadDB = edadDB;
    }
   String userDB;
   String passDB;
   String nameDB;
   int edadDB;
   
   
    public JavaJDPersona(){
        
    }
    public JavaJDPersona(String userDB, String passDB, String nameDB, int edadDB) {
        this.userDB = userDB;
        this.passDB = passDB;
        this.nameDB = nameDB;
        this.edadDB = edadDB;
    }
        
  
            
      
    

    @Override
    public boolean guardarPersona(Persona persona) {
        
        
        try{
      String myDriver = "org.apache.derby.jdbc.ClientDriver";
      String myUrl = "jdbc:derby://localhost:1527/loginRegistros";
      Class.forName(myDriver);
      DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      Connection conn = DriverManager.getConnection(myUrl, "user1", "pass");
    
      // create the java mysql update preparedstatement
      String query = "INSERT INTO registros VALUES( ? , ? , ? , ? )";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, persona.getNombre());
      stmt.setInt(2, persona.getEdad());
      stmt.setString(3, persona.getUser());
      stmt.setString(4, persona.getPass());
      
      stmt.executeUpdate();
      conn.close();
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
                
            }
            return null;
        }catch(Exception e){
            return null;
        }
    
}
    @Override
    public boolean leerPersonas(String user,String pass){
      try{
      String myDriver = "org.apache.derby.jdbc.ClientDriver";
      String myUrl = "jdbc:derby://localhost:1527/loginRegistros";
      Class.forName(myDriver);
      DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      Connection conn = DriverManager.getConnection(myUrl, "user1", "pass");
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM registros";
      ResultSet rs;
      rs = stmt.executeQuery(query);
      while ( rs.next() ) {
                userDB = rs.getString("usuario");
                System.out.println(userDB);
                passDB = rs.getString("pass");
                System.out.println(passDB);
                nameDB = rs.getString("nombre");
                System.out.println(nameDB);
                edadDB = rs.getInt("edad");
                System.out.println(edadDB);
                if(userDB.equals(user) && passDB.equals(pass)){
                    return true;
                }
                
            }
       
      conn.close();
      return false;
      }catch(Exception e){
         System.err.println("Got an exception! ");
         System.err.println(e.getMessage());
         e.printStackTrace(); 
         return false;
      }
    }
    public Persona leerP(String user,String pass){
      try{
      String myDriver = "org.apache.derby.jdbc.ClientDriver";
      String myUrl = "jdbc:derby://localhost:1527/loginRegistros";
      Class.forName(myDriver);
      DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      Connection conn = DriverManager.getConnection(myUrl, "user1", "pass");
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM registros";
      ResultSet rs;
      rs = stmt.executeQuery(query);
      if ( rs.next() ) {
                userDB = rs.getString("usuario");
                System.out.println(userDB);
                passDB = rs.getString("pass");
                System.out.println(passDB);
                nameDB = rs.getString("nombre");
                System.out.println(nameDB);
                edadDB = rs.getInt("edad");
                System.out.println(edadDB);
                Persona p = new Persona(nameDB, edadDB, userDB, passDB);
                return p;
            }
       
      conn.close();
      return null;
      }catch(Exception e){
         System.err.println("Got an exception! ");
         System.err.println(e.getMessage());
         e.printStackTrace(); 
         return null;
      }
    }
    }
