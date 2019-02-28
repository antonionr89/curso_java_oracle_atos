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
public class procesarBor extends HttpServlet {

    
       JavaJDPersona db = new JavaJDPersona();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
       Persona p = db.borrarDatos(user, pass);
        if(p != null){
             session.setAttribute("nombre",p);
             request.getRequestDispatcher("exitoBor.jsp").forward(request, response);
             session.invalidate();
             
        }else{
            request.getRequestDispatcher("errorBor.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
