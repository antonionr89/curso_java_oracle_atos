/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;

import com.modelo.Registros;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IRegistrosDAO {
    boolean crear(Registros registros);
    ArrayList<Registros>  obtenerTodos();
    Registros obtenerUno(Long id);
    Registros obtenerUno(String email);
    boolean eliminar(String email);
    boolean modificar(Registros registros);
}
