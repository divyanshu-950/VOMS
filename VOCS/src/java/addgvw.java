/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class addgvw extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       HttpSession session = request.getSession(false);
            if(session!=null){
               
            String Vname = request.getParameter("vehicle_name");
            String gvw = request.getParameter("gvw");
            
           if(Vname.equals("") || gvw.equals("")){
                out.println("<html><body><script>window.confirm('Invalid! Information');</script></body></html>");
       
             request.getRequestDispatcher("addgvw.html").include(request, response);
            
       }
            else{
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/div1","root","");
                Statement stmnt = con.createStatement();
                stmnt.executeUpdate("INSERT INTO `vehicle_data` (`vehicle`, `GVW`) VALUES ('"+Vname+"','"+gvw+"')");
                request.getRequestDispatcher("addgvw.html").include(request, response);
                out.println("<html><body><script>alert('Added Successfuly');</script></body></html>");
                   con.close();
            }catch(Exception e){
           e.printStackTrace();
            }
       }
            }
            else{
                 out.println("<div Style='background-color: #248d00; padding: 10px;'><h3 style='margin-left:50px; color:red;'> You're Not Logged in!</div>");
            request.getRequestDispatcher("login.html").include(request, response);
            }
       
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
