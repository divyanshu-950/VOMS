/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String  user= request.getParameter("admin");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
          // out.println(user+" "+email+" "+password);
           
           if(user!=null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/div1","root","");
                ResultSet rs;
                Statement stmnt = con.createStatement();
                rs=stmnt.executeQuery("SELECT * FROM `login_data` WHERE `email` = '"+email+"' AND `password` = '"+password+"'");
                if(rs.next()){
                     HttpSession session = request.getSession();
                     session.setAttribute("name", email);
                request.getRequestDispatcher("admin_index.html").forward(request, response);
                }
                else{
                out.println("<div Style='background-color: #248d00; padding: 10px;'><h3 style='margin-left:50px; color:red;'> Invalid! Login Credentials</div>");
                 request.getRequestDispatcher("login.html").include(request, response);
               
                }
                con.close();
            }catch(Exception e){
           e.printStackTrace();
           out.println(e.getStackTrace());
            }
           }
           else{
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/div1","root","");
                ResultSet rs;
                Statement stmnt = con.createStatement();
                rs=stmnt.executeQuery("SELECT * FROM `worker_database` WHERE `email` = '"+email+"' AND `password` = '"+password+"'");
                if(rs.next()){
                     HttpSession session = request.getSession();
                     session.setAttribute("name", email);
                request.getRequestDispatcher("worker_index.html").forward(request, response);
                }
                else{
                out.println("<div Style='background-color: #268ab7; padding: 10px;'><h3 style='margin-left:50px; color:red;'> Invalid! Login Credentials</div>");
                 request.getRequestDispatcher("login.html").include(request, response);
               
                }
                con.close();
            }catch(Exception e){
           e.printStackTrace();
           out.println(e.getStackTrace());
            }
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
