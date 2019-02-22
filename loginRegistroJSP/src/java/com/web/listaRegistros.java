/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author USUARIO
 */
public class listaRegistros {
    //public static ArrayList<String> list=new ArrayList<String>();
   

        private static listaRegistros mInstance;
        //JavaJDPersona javaDB = new JavaJDPersona();
        
        
        public static listaRegistros getInstance() {
            if(mInstance == null)
                mInstance = new listaRegistros();

            return mInstance;
        }
        public void guardarPersona(String nombre,int edad,String user,String pass){
            try
    {
      // create a java mysql database connection
      String myDriver = "org.apache.derby.jdbc.ClientDriver";
      String myUrl = "jdbc:derby://localhost:1527/loginRegistros";
      Class.forName(myDriver);
      DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      Connection conn = DriverManager.getConnection(myUrl, "user1", "pass");
    
      // create the java mysql update preparedstatement
      String query = "INSERT INTO registros VALUES( ? , ? , ? , ? )";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, nombre);
      stmt.setInt(2, edad);
      stmt.setString(3, user);
      stmt.setString(4, pass);
      
      stmt.executeUpdate();
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
      e.printStackTrace();
      
        }
       
    }
    public boolean isUser(String user,String pass){
      try{
      String myDriver = "org.apache.derby.jdbc.ClientDriver";
      String myUrl = "jdbc:derby://localhost:1527/loginRegistros";
      Class.forName(myDriver);
      DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      Connection conn = DriverManager.getConnection(myUrl, "user1", "pass");
      Statement stmt = conn.createStatement();
      String query = "SELECT usuario,pass FROM registros";
      ResultSet rs;
      rs = stmt.executeQuery(query);
      while ( rs.next() ) {
                String userDB = rs.getString("usuario");
                System.out.println(userDB);
                String passDB = rs.getString("pass");
                System.out.println(passDB);
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
        
}

