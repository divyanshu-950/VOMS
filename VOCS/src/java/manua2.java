/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class manua2 extends HttpServlet {

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
                String Vname = request.getParameter("vehicle");
            int totalweight = Integer.parseInt(request.getParameter("totalweight"));
            int gvw =0;
            
           if(Vname.equals("") || totalweight == 0 ){
                out.println("<html><body><script>window.confirm('Some Information Fields are empty')</script></body></html>");  
             
            request.getRequestDispatcher("manual").include(request, response);
            
       }
            else{
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/div1","root","");
                Statement stmnt = con.createStatement();
                 ResultSet rs;
                rs = stmnt.executeQuery("SELECT `GVW` FROM `vehicle_data` WHERE `vehicle` = '"+Vname+"'");
                while(rs.next()){
                   gvw = Integer.parseInt(rs.getString(1));
             }
                   if(totalweight > gvw){
                    out.println("<html><body><script>window.confirm('Your Vehicle is Overoaded By : "+(totalweight - gvw)+" KG');</script></body></html>");
                    request.getRequestDispatcher("manual").include(request, response);
               
                   }
                   else if( totalweight == gvw){
                        out.println("<html><body><script>window.confirm('Your Vehicle is at Limit');</script></body></html>");
                    request.getRequestDispatcher("manual").include(request, response);
               
                   }
                   else{
                    out.println("<html><body><script>window.confirm('Your Vehicle is at Underlimit');</script></body></html>");
                   request.getRequestDispatcher("manual").include(request, response);
               
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
