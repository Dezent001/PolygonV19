/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import LogikLag.DomainFacade;
import LogikLag.Entities.User;
import LogikLag.PolygonException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    RequestDispatcher rd = null;
    List<User> users;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, List<User> users) throws ServletException, IOException{
        String firmName = request.getParameter("Username");
        String password = request.getParameter("password");
        String user_type = "";
        System.out.println("tjekker for brugeren");
        
        if (firmName.length() > 0 && password.length() > 0) {
            for (User user : users) {
                if (user.getFirmName().equals(firmName) && user.getPassword().equals(password)) {
                    user_type = user.getUsertype();
                    request.getSession().setAttribute("firm_name", firmName);
                    request.getSession().setAttribute("user_type", user.getUsertype());
                    request.getSession().setAttribute("user_id", user.getUserID());
                    System.out.println("Test0");
                    break;
                }
            }
        }
        System.out.println("Test1");
        switch (user_type) {
            case "1":
                request.getRequestDispatcher("/PolyPage.jsp").forward(request, response);
                break;
            case "2":
                request.getRequestDispatcher("/UserPage.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/index.html").forward(request, response);
                break;
        }
 
    }

   
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Test2");
        response.sendRedirect("/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("gik i try (login)");
            users = DomainFacade.getUsers();
            processRequest(request, response, users);
        } catch (PolygonException | ServletException | IOException ex) {
            System.out.println("gik i catch (login)");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


