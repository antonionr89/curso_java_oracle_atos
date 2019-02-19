/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class login extends HttpServlet {

   
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulario Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Introduce tus datos</h1>");
            out.println("<form name='form1' method='post' action='http://localhost:8084/01WebServlet/login'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Usuario:</td><td>");
            out.println("<input type='text' size='25' id='use' name='use' pattern='[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+' /></td></tr>");
            out.println("<tr><td>Contraseña:</td><td>");
            out.println("<input type='text' name='pas' id='pas' size='25' value=''/></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("use").isEmpty() || request.getParameter("pas").isEmpty()){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"#CCBBAA\">");
            out.println("<p>No puedes dejar ningun campo vacio</p>");
            out.println("</body>");
            out.println("</html>");
        }
            
    }else{
         boolean esUser = false;
         response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Te has logeado</title>");            
          out.println("</head>");
          out.println("<body bgcolor=\"#CCBBAA\">");
             System.out.println((request.getParameter("use")+request.getParameter("pas")));
         for(int i=0;i<listaRegistros.getInstance().getArray().size();i++){
             System.out.println(listaRegistros.getInstance().getArray().get(i));
             if((request.getParameter("use")+request.getParameter("pas")).equals(listaRegistros.getInstance().getArray().get(i))){
                 out.println("<p>"+listaRegistros.getInstance().getArray().get(i)+"</p>");
                 out.println("<p>Tu usuario es </p>"+request.getParameter("use"));
                 esUser = true;
                 
            }
            
             /*else if(!(request.getParameter("use")+request.getParameter("pas")).equals(listaRegistros.getInstance().getArray().get(i))){
             out.println("<p>Tu usuario no esta registrado</p>");
              }  */       
            }
            if(esUser == false){
               out.println("<p>Tu usuario no esta registrado</p>");
            }
           out.println("</body>");
           out.println("</html>");
          }
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
