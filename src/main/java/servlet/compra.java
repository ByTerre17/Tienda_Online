package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
@WebServlet(urlPatterns = {"/compra"})
public class compra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String paso = request.getParameter("paso");

            if(paso==null){
                Cookie cookies[] = request.getCookies();
                paso=cookies[0].getName();
                cookies[0].setMaxAge(0);
                if(paso.equalsIgnoreCase("0")){
                   Cookie Cookie = new Cookie("paso", paso);
                   response.addCookie(Cookie);
                   response.sendRedirect("index.jsp");
                }
                else if( paso.equals("1") || paso.equals("2") || paso.equals("3") || paso.equals("4")){
                    Cookie Cookie = new Cookie("paso", paso);
                    response.addCookie(Cookie);
                    response.sendRedirect("paso"+paso+".html");
                }
                else{
                    paso="1";
                    Cookie Cookie = new Cookie("paso", paso);
                    response.addCookie(Cookie);
                    response.sendRedirect("paso"+paso+".html");
                }
            }
            else{
                Cookie Cookie = new Cookie("paso", paso);
                response.addCookie(Cookie);
                response.sendRedirect("paso"+paso+".html");
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet compra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet compra at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
