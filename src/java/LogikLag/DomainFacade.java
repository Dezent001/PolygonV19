/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag;

import LogikLag.Entities.Zip;
import LogikLag.Entities.Building;
import LogikLag.Entities.Rapport;
import LogikLag.Entities.BuildingImg;
import LogikLag.Entities.RapportImg;
import LogikLag.Entities.User;
import DataLag.BuildingMapper;
import DataLag.RapportMapper;
import DataLag.UserMapper;
import DataLag.ZipMapper;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class DomainFacade {


    public static List<Building> getBuildings() throws PolygonException, SQLException, ClassNotFoundException {
        List<Building> buildings = BuildingMapper.getBuildings();

        if (buildings != null) {
            System.out.println("getBuilding virker");
        }
        return buildings;

    }

    public static HashMap<Integer, BuildingImg> getImgs() throws PolygonException{
        try {
            List<BuildingImg> imgs = BuildingMapper.getImgs();
            HashMap<Integer, BuildingImg> imgmap = new HashMap<>();
            for (BuildingImg img : imgs) {
                imgmap.put(img.getBuildingID(), img);
            }
            return imgmap;
        } catch (SQLException | ClassNotFoundException ex) {
            String msg = " Fejl i getBuildingImgs()";
            throw new PolygonException(msg);
        }

    }

    public static HashMap<Integer, RapportImg> getRimgs() throws PolygonException, SQLException, ClassNotFoundException {
        try {
            List<RapportImg> rimgs = RapportMapper.getRimgs();
            HashMap<Integer, RapportImg> imgmap = new HashMap<>();
            for (RapportImg rimg : rimgs) {
                imgmap.put(rimg.getReportID(), rimg);
            }
            return imgmap;
        } catch (SQLException | ClassNotFoundException ex) {
            String msg = " Fejl i getRapportImgs()";
            throw new PolygonException(msg);
        }

    }

    public static List<User> getUsers() throws PolygonException {

        List<User> users = null;
        try {
            users = UserMapper.getUser();
        } catch (Exception ex) {
            String msg = " Fejl i getUser()";
            throw new PolygonException(msg);
        }
        return users;
    }

    public static List<User> getUserRequest() throws PolygonException {

        List<User> userrequest = null;
        try {
            userrequest = UserMapper.getUserRequest();
        } catch (Exception ex) {
            String msg = " Fejl i getUserRequest()";
            throw new PolygonException(msg);
        }
        return userrequest;
    }

    public static List<Rapport> getReports() throws PolygonException, SQLException, ClassNotFoundException {

        List<Rapport> reports = RapportMapper.getRapport();
        if (reports != null) {
            System.out.println("getReport virker");
        }
        return reports;
    }

    public static HashMap<Integer, Zip> getZips() throws PolygonException, SQLException, ClassNotFoundException {
        try {
            List<Zip> zips = ZipMapper.getZip();
            HashMap<Integer, Zip> zip = new HashMap<>();
            for (Zip zipid : zips) {
                zip.put(zipid.getZipcodes(), zipid);
            }
            return zip;
        } catch (SQLException | ClassNotFoundException ex) {
            String msg = " Fejl i getZipcodes()";
            throw new PolygonException(msg);
        }

    }
}
