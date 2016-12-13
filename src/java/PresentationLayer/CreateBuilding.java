/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLag.BuildingMapper;
import LogikLag.Entities.Building;
import LogikLag.PolygonException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author JonasSchack
 */
@MultipartConfig
@WebServlet(name = "CreateBuilding", urlPatterns = {"/CreateBuilding"})
public class CreateBuilding extends HttpServlet {

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
    
    
//        String BuildingID = request.getParameter("buildingid");
//        request.getSession().setAttribute("BuildingId", BuildingID);
//        forward(request, response, "/VisRapport.jsp");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, PolygonException {
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
        
        String LoginType = (String) request.getSession().getAttribute("user_type");
        String BuildingID = request.getParameter("buildingid");
        request.getSession().setAttribute("BuildingId", BuildingID);
        try {
        
        String Valg = request.getParameter("valg");
            System.out.println(Valg);
        switch (Valg) {
            case "add":
                storeBuilding(request);
                if ("2".equals(LoginType)) {
                request.getRequestDispatcher("/VisBygningUser.jsp").forward(request, response);
                }else{
                request.getRequestDispatcher("/VisBygningPoly.jsp").forward(request, response);  
                }
                break;
            case "vis":
                request.getRequestDispatcher("/VisRapport.jsp").forward(request, response);
                break;
            case "visRapport":
                request.getRequestDispatcher("/VisRapport.jsp").forward(request, response);
                break;
            case "ret":
                request.getRequestDispatcher("/RetBygning.jsp").forward(request, response);
                break;
            case "rettet":
                updateBuilding(request, response);
                if ("2".equals(LoginType)) {
                request.getRequestDispatcher("/VisBygningUser.jsp").forward(request, response);
                }else{
                request.getRequestDispatcher("/VisBygningPoly.jsp").forward(request, response);  
                }
                break;
            case "slet":
                sletBygning(request, response);
                if ("2".equals(LoginType)) {
                request.getRequestDispatcher("/VisBygningUser.jsp").forward(request, response);
                }else{
                request.getRequestDispatcher("/VisBygningPoly.jsp").forward(request, response);  
                }
                break;
            default:
                request.getRequestDispatcher("/index.html").forward(request, response);
                break;
        }
        } catch (ClassNotFoundException | SQLException | PolygonException ex) {
            forward(request, response, "/Exception.jsp");
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

    private void storeBuilding(HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException, ServletException {
        int UserId = (Integer) request.getSession().getAttribute("user_id");
        Part filePart = request.getPart("Blobfile");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        System.out.println("Gik i Store createBuilding");
        System.out.println("UserID = " + UserId);
        int userID = UserId;
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String street = (String) request.getParameter("street");
        int m2 = Integer.parseInt(request.getParameter("m2"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        InputStream floorplan = filePart.getInputStream();
        Building b = new Building(userID, zipID, street, m2, floors, floorplan);
        BuildingMapper.createBuilding(b);
    }
    
     private void sletBygning(HttpServletRequest req, HttpServletResponse response) throws PolygonException, ClassNotFoundException {
        System.out.println("Gik i SletBygning");
        int id = Integer.parseInt(req.getParameter("buildingid"));
        BuildingMapper.removeBuilding(id);
    }

    private void updateBuilding(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException, SQLException {
        
        Part filePart = request.getPart("Blobfile");
        
        if (filePart.getSize() < 1) { 
        //uden blob
        int id = Integer.parseInt(request.getParameter("bID"));
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String street = (String) request.getParameter("street");
        int m2 = Integer.parseInt(request.getParameter("kvadratmeter"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        Building b = new Building( zipID, street, m2, floors);
        BuildingMapper.updateBuilding(b, id);
    }else{
        //med blob
        int id = Integer.parseInt(request.getParameter("bID"));
        int zipID = Integer.parseInt(request.getParameter("zipID"));
        String street = (String) request.getParameter("street");
        int m2 = Integer.parseInt(request.getParameter("kvadratmeter"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        InputStream floorplan = filePart.getInputStream();
        Building b = new Building( zipID, street, m2, floors, floorplan);
        BuildingMapper.updateBuildingBlob(b, id);
    }
}
}