/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLag.UserMapper;
import LogikLag.PolygonException;
import LogikLag.Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateUser", urlPatterns = {"/CreateUser"})
public class CreateUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RequestDispatcher rd = null;

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
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
        System.out.println("test");
        String UserID = request.getParameter("UserId");
        request.getSession().setAttribute("UserId", UserID);
        
        try {
        
        String Valg = request.getParameter("ret");
            System.out.println(Valg);
        switch (Valg) {
            case "Opret":
                storeUser(request, response);
                forward(request, response, "/VisUser.jsp");
                break;
            case "request":
                storeRequest(request, response);
                request.getRequestDispatcher("/index.html").forward(request, response);
                break;
            case "rediger":
                request.getRequestDispatcher("/EditUser.jsp").forward(request, response);
                break;
            case "redigeret":
                updateUser(request, response);
                request.getRequestDispatcher("/VisUser.jsp").forward(request, response);
                break;
            case "Slettet":
                sletUser(request, response);   
                request.getRequestDispatcher("/VisUser.jsp").forward(request, response);
                break;
            case "Slet":
                sletUserRequest(request, response);   
                request.getRequestDispatcher("/VisUserRequest.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/Exception.jsp").forward(request, response);
                break;
           
        }
        } catch (ClassNotFoundException | PolygonException | SQLException ex) {
            request.getRequestDispatcher("/Exception.jsp").forward(request, response);
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

       
    
    private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/" + path);
        rd.forward(req, res);
    }

    private void storeUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, PolygonException {

        System.out.println("Gik i Store createUser");
        String usertype = (String) request.getParameter("usertype");
        String ContactFirstName = (String) request.getParameter("ContactFirstName");
        String ContactLastName = (String) request.getParameter("ContactLastName");
        String firmName = (String) request.getParameter("firmname");
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String gade = (String) request.getParameter("gade");
        int cvr = Integer.parseInt(request.getParameter("cvr"));
        String telefon = (String) request.getParameter("telefon");
        String mail = (String) request.getParameter("mail");
        String password = (String) request.getParameter("password");
        User u = new User( zipID, usertype, firmName, ContactFirstName, ContactLastName, telefon, mail, cvr, gade, password);
        UserMapper.createUser(u);
        int id = Integer.parseInt(request.getParameter("userid"));
        if (id >= 1){
        UserMapper.removeUserRequest(id);
        }
    }
    
        private void sletUser(HttpServletRequest request, HttpServletResponse response) throws PolygonException, ClassNotFoundException {
        System.out.println("Gik i SletUser");
        int id = Integer.parseInt(request.getParameter("uID"));
        UserMapper.removeUser(id);
    }
    
        private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        
        int id = Integer.parseInt(request.getParameter("uID"));
        String  usertype = (String) request.getParameter("usertype");
        String ContactFirstName = (String) request.getParameter("Fornavn");
        String ContactLastName = (String) request.getParameter("Efternavn");
        String firmName = (String) request.getParameter("firmName");
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String gade = (String) request.getParameter("Gade");
        int cvr = Integer.parseInt(request.getParameter("cvr"));
        String telefon = (String) request.getParameter("Telefon");
        String mail = (String) request.getParameter("Mail");
        String password = (String) request.getParameter("Password");
        User u = new User( usertype,ContactFirstName, ContactLastName,firmName,zipID, gade, cvr, telefon, mail, password);
        UserMapper.updateUser(u, id);
    }

        private void storeRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, PolygonException {
        
        System.out.println("Gik i Store UserRequest");
        String usertype = (String) request.getParameter("usertype");
        String ContactFirstName = (String) request.getParameter("ContactFirstName");
        String ContactLastName = (String) request.getParameter("ContactLastName");
        String firmName = (String) request.getParameter("firmName");
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String gade = (String) request.getParameter("gade");
        int cvr = Integer.parseInt(request.getParameter("cvr"));
        String telefon = (String) request.getParameter("telefon");
        String mail = (String) request.getParameter("mail");
        String password = (String) request.getParameter("password1");
        String password2 = (String) request.getParameter("password2");
        
        if (password.equals(password2)){
        User r = new User( zipID, usertype, firmName, ContactFirstName, ContactLastName, telefon, mail, cvr, gade, password);        
        UserMapper.requestUser(r);
        }else{
        request.getRequestDispatcher("/Forespørgelse.jsp").forward(request, response);
        }
    }

    private void sletUserRequest(HttpServletRequest request, HttpServletResponse response) throws PolygonException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("userid"));
        UserMapper.removeUserRequest(id);
    }
}
