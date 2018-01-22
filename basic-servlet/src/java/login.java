/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author BALAJI
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
            String n=request.getParameter("userName");  
String p=request.getParameter("passWord"); 
String s = null,pas = null;
try
{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sample","root",""); 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select email,password from register where email='"+n+"'");
while(rs.next())
{
s=rs.getString(1);
pas=rs.getString(2);
}
con.close();  

}
catch(Exception ee)
{
}
           if(s==null)
           {
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</h1>INVALID LOGIN<h1>");
            out.println("</body>");
            out.println("</html>");

           }
           else if(pas.equals(p))
           {
               ResultSet rs;
               try
{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sample","root",""); 
Statement stmt=con.createStatement();  
 rs=stmt.executeQuery("select *from register");
ResultSetMetaData rsmd = rs.getMetaData();

int numberOfColumns = rsmd.getColumnCount();



  out.println("<table border=1>");
out.println("<tbody>");
out.println("<tr>");
for (int i = 1; i <= numberOfColumns; i++) {
        
            
        String columnName = rsmd.getColumnName(i);
        out.println("<td>"+columnName+"</td>");
      }
out.println("</tr>");

 while (rs.next()) 
 {
     out.println("<tr>");
 
        for (int i = 1; i <= numberOfColumns; i++)
        {
            String columnValue = rs.getString(i);
            out.println("<td>"+columnValue+"</td>");
        }


out.println("</tr>");
 }


out.println("</tbody>");
out.println("</table>");
     
con.close();  

}
catch(Exception ee)
{
}
               
               

               
           }
           else
           {
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</h1>INVALID PASSWORD<h1>");
            out.println("</body>");
            out.println("</html>");
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
