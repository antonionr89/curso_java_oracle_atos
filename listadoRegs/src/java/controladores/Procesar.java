/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.logica.GestionPersona;

/**
 *
 * @author USUARIO
 */
public class Procesar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        GestionPersona.TipoResultado gestion = GestionPersona.getInstance().guardarPersona(nombre,edad,user,pass);
      switch(gestion){
          case OK:
          request.getRequestDispatcher("exito.jsp").forward(request, response);
          //request.getSession().setAttribute("persona1", GestionPersona.getInstance().getPersona());
          break;
          case SIN_VALORES:
          request.getRequestDispatcher("errornumero.jsp").forward(request, response);
          //request.getSession().setAttribute("persona1", GestionPersona.getInstance().getPersona());
          break;
          case EDAD_MAL:
          request.getRequestDispatcher("error.jsp").forward(request, response);
          //request.getSession().setAttribute("persona1", GestionPersona.getInstance().getPersona());
          break;
          case ERROR_IO:
          request.getRequestDispatcher("errorio.jsp").forward(request, response);
          //request.getSession().setAttribute("persona1", GestionPersona.getInstance().getPersona());
      }
    }

   
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
