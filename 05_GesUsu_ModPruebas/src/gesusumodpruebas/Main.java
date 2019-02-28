/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gesusumodpruebas;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {

    static void mostrarResultado (ServicioUsuarios.Resultado res,String nombre){
        System.out.print("Prueba "+nombre+":");
        switch(res){
            case CamposMal:
                System.out.println("Erro campos mal");
                break;
            case ErrorDB:
                System.out.println("Error DB");
                break;
            case NoLogin:
                System.out.println("Error No login");
                break;
            case Ok:
                System.out.println("prueba correcta");
                break;
        }
    }
    static void listar(){
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().obtenerTodos();
        System.out.println("ServicioUsuarios.getInstancia().obtenerTodos()");
        todos.stream().forEach((u) -> {
            System.out.println(" -"+u.getId()+", "
            +u.getNombre()+", "
            +u.getEdad()+", "
            +u.getEmail()+", "
            +u.getPassword()+", ");
        });
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("probando modulo modelo:");
        System.out.println("datos no validos:");
        mostrarResultado(ServicioUsuarios.getInstancia().add("aaa", "10", "", ""),"Usuario no valido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("bbb", "19", "x@x", ""),"Usuario no valido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("aaa", "19", "x@x.com", "x@x.com"),"Usuario no valido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("aaa", "19", "x@x.com", ""),"Usuario no valido");
        System.out.println("Usuarios validos");
        mostrarResultado(ServicioUsuarios.getInstancia().add("aaa", "19", "x@x.com", "aaa"),"usuario valido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("bbb", "19", "a@a.com", "bbb"),"usuario valido");
        mostrarResultado(ServicioUsuarios.getInstancia().add("ccc", "19", "b@b.com", "ccc"),"usuario valido");
        //listar();
        mostrarResultado(ServicioUsuarios.getInstancia().add("aaa", "19", "b@b.com", "ccc"),"usuario repetido");
        //Usuario usu = ServicioUsuarios.getInstancia().obtenerUno("ccc@ccc.com");
        //mostrarResultado(ServicioUsuarios.getInstancia().modificar(1,"aaa", "19", "b@b.com", "ccc"), "modificar");
        mostrarResultado(ServicioUsuarios.getInstancia().eliminar("a@a.com"), "usuario repetido");
        mostrarResultado(ServicioUsuarios.getInstancia().validarLoginUsuario("b@b.com", "ccc") ,"validar");
        
    }
    
}
