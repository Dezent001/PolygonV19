
package DataLag;

import LogikLag.Entities.Building;
import LogikLag.Entities.BuildingImg;
import LogikLag.PolygonException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Rune
 */
public class BuildingMapper {
    
    public static boolean removeBuilding(int id) throws PolygonException, ClassNotFoundException {
        String sql = "DELETE FROM building WHERE buildingID = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette bygning";
            throw new PolygonException(msg);
        }
        
        String sql1 = "DELETE FROM report WHERE buildingID = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql1)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette rapport";
            throw new PolygonException(msg);
        }
        return true;
    }

    public static List<BuildingImg> getImgs() throws SQLException, ClassNotFoundException {
        List<BuildingImg> imgs = new ArrayList();
        String sql = "SELECT floorplan, buildingID FROM building;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                    Blob blob = res.getBlob("floorplan");
                    int buildingID = res.getInt("buildingID");
                    InputStream floorplan = blob.getBinaryStream();
                imgs.add(new BuildingImg(floorplan, buildingID));
                
                 
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return imgs;
    }
    
    public static List<Building> getBuildings() throws SQLException, ClassNotFoundException {
        List<Building> buildings = new ArrayList();
        String sql = "SELECT * FROM building;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int userID = res.getInt("userID");
                int buildingID = res.getInt("buildingID");
                int zipID = res.getInt("zipID");
                String street = res.getString("street");
                int m2 = res.getInt("m2");
                int floors = res.getInt("floors");
                buildings.add(new Building(userID, buildingID, zipID, street, m2, floors));
                
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return buildings;
    }
    public static void createBuilding(Building b) throws ClassNotFoundException, SQLException, IOException {
        int userID = b.getUserID();
        int zipID = b.getzipID();
        String street = b.getStreet();
        int m2 = b.getM2();
        int floors = b.getFloors();
        InputStream floorplan = b.getFloorplan();
        String sql = "INSERT INTO building (userID, zipID, street, m2, floors, floorplan) values (?,?,?,?,?,?)";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setInt(1, userID);
        stmt.setInt(2, zipID);
        stmt.setString(3, street);
        stmt.setInt(4, m2);
        stmt.setInt(5, floors);
        stmt.setBlob(6, floorplan);

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Building added");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("I broke somewhere SQLExeception " + ex.getMessage());
        }
    }


    public static void updateBuilding(Building b, int id) throws ClassNotFoundException, SQLException {
        String street = b.getStreet();
        int m2 = b.getM2();
        int zipID = b.getzipID();
        int floors = b.getFloors();
        String sql = "UPDATE building SET street=?, m2=?, zipID=?, floors=?  WHERE buildingID = '" + id + "';";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setString(1, street);
        stmt.setInt(2, m2);
        stmt.setInt(3, zipID);
        stmt.setInt(4, floors);
      

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change in updateBuilding");
            }

        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
   }
    public static void updateBuildingBlob(Building b, int id) throws ClassNotFoundException, SQLException {
            String street = b.getStreet();
        int m2 = b.getM2();
        int zipID = b.getzipID();
        int floors = b.getFloors();
        InputStream floorplan = b.getFloorplan();
        String sql = "UPDATE building SET street=?, m2=?, zipID=?, floors=?, floorplan=? WHERE buildingID = '" + id + "';";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setString(1, street);
        stmt.setInt(2, m2);
        stmt.setInt(3, zipID);
        stmt.setInt(4, floors);
        stmt.setBlob(5, floorplan);

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change in updateBuilding");
            }

        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
   }

}