/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLag.RapportMapper;
import LogikLag.PolygonException;
import LogikLag.Entities.Rapport;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CreateRapport", urlPatterns = {"/CreateRapport"})
public class CreateRapport extends HttpServlet {
    
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
        String RapportID = request.getParameter("rapportID");
        request.getSession().setAttribute("RapportId", RapportID);
        
        try {
        
        String Valg = request.getParameter("valg");
            System.out.println(Valg);
        switch (Valg) {
            case "add":
                storeRapport(request, response);
                forward(request, response, "/VisRapport.jsp");
                break;
            case "vis":
                request.getRequestDispatcher("/VisDetaljeRapport.jsp").forward(request, response);
                break;
            case "ret":
                request.getRequestDispatcher("/RetRapport.jsp").forward(request, response);
                break;
            case "rettet":
                updateRapport(request, response);
                request.getRequestDispatcher("/VisRapport.jsp").forward(request, response);
                break;
            case "slet":
                sletRapport(request, response);
                request.getRequestDispatcher("/VisRapport.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/index.html").forward(request, response);
                break;
        }
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException | PolygonException ex) {
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

    private void storeRapport(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
        int BuildingID = Integer.parseInt((String) request.getSession().getAttribute("BuildingId"));
        Part filePart = request.getPart("Blobfile");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        
        System.out.println("Gik i Store createRapport");
        int buildingID = BuildingID;
        System.out.println(buildingID);
        String dato = (String) request.getParameter("dato");
        String kommentar = (String) request.getParameter("kommentar");
        String skadestype = (String) request.getParameter("skadestype");
        int skadesomfang = Integer.parseInt(request.getParameter("skadesomfang"));
        String skadeslokalition = (String) request.getParameter("skadeslokalition");
        String floor = (String) request.getParameter("floor");
        InputStream pic = filePart.getInputStream();
        String udført = (String) request.getParameter("udfort");
        Rapport r = new Rapport(buildingID, dato, kommentar, skadestype, skadesomfang, skadeslokalition, floor, pic,udført);
        RapportMapper.createRapport(r);
    }
    private void sletRapport(HttpServletRequest request, HttpServletResponse response) throws PolygonException, ClassNotFoundException {
        System.out.println("Gik i SletRapport");
        int id = Integer.parseInt(request.getParameter("rapportID"));
        RapportMapper.removeRapport(id);
    }
    
    private void updateRapport(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException, SQLException {
        
        Part filePart = request.getPart("Blobfile");
        
        if (filePart.getSize() < 1) {
        //Uden blob
        int id = Integer.parseInt(request.getParameter("rID"));
        String dato = (String) request.getParameter("dato");
        String kommentar= (String) request.getParameter("kommentar");
        String skadesType = (String) request.getParameter("skadesType");
        String skadesLokalition = (String) request.getParameter("skadesLokation");
        String floor = (String) request.getParameter("floor");
        String udført = (String) request.getParameter("udfort");
        Rapport r = new Rapport(dato, kommentar, skadesType, skadesLokalition, floor, udført);
        RapportMapper.updateRapport(r, id);
        
    }else{
        //Med blob
        int id = Integer.parseInt(request.getParameter("rID"));
        String dato = (String) request.getParameter("dato");
        String kommentar= (String) request.getParameter("kommentar");
        String skadesType = (String) request.getParameter("skadesType");
        String skadesLokalition = (String) request.getParameter("skadesLokation");
        String floor = (String) request.getParameter("floor");
        InputStream pic = filePart.getInputStream();
        String udført = (String) request.getParameter("udfort");
        Rapport r = new Rapport(dato, kommentar, skadesType, skadesLokalition, floor, pic,udført);
        RapportMapper.updateRapportBlob(r, id);
        }
    }
}

