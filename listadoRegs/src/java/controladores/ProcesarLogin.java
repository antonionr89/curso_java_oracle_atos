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
import javax.servlet.http.HttpSession;
import modelo.Persona;
import modelo.persistencia.JavaJDPersona;

/**
 *
 * @author USUARIO
 */
public class ProcesarLogin extends HttpServlet {
    
    JavaJDPersona db = new JavaJDPersona();
    

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
        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Persona p = db.leerP(user, pass);
        if(p != null){
            session.setAttribute("nombre",p);
             request.getRequestDispatcher("exitoLogin.jsp").forward(request, response);
             
        }else{
            request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
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
