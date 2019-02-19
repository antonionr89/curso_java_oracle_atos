/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class registro extends HttpServlet {
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
            out.println("<title>Formulario Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Introduce tus datos</h1>");
            out.println("<form name='form1' method='post' action='http://localhost:8084/01WebServlet/registro'>");
            out.println("<table border='1'>");
            out.println("<tr><td>Nombre:</td><td>");
            out.println("<input type='text' name='nom' id='nom' size='25' value=''/></td></tr>");
            out.println("<tr><td>Edad:</td><td>");
            out.println("<input type='number' name='eda' id='eda' size='25' value=''/></td></tr>");
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
        if(Integer.parseInt(request.getParameter("eda")) < 18){
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"#CCBBAA\">");
            out.println("<h1>Servlet ParamServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Eres menor de 18 años</p>");
            out.println("</body>");
            out.println("</html>");
        }
        }else{
           listaRegistros.getInstance().getArray().add(request.getParameter("use")+request.getParameter("pas"));
           response.setContentType("text/html;charset=UTF-8");
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Completado</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"#CCBBAA\">");
            out.println("<p>Te has registrado con exito</p>");
            for(int i=0;i<listaRegistros.getInstance().getArray().size();i++){
                out.println("<p>"+listaRegistros.getInstance().getArray().get(i)+"</p>");
            }
            out.println("<form>");
            out.println("<a href='index.html'><input type='button' value='Atras!'/></a>");
            out.println("</form>");
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
