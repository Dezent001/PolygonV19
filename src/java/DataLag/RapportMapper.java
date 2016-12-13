package DataLag;


import LogikLag.PolygonException;
import LogikLag.Entities.Rapport;
import LogikLag.Entities.RapportImg;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


/**
 *
 * @author JonasSchack
 */
public class RapportMapper {
    
    public static boolean removeRapport(int id) throws PolygonException, ClassNotFoundException {
        String sql = "DELETE FROM report WHERE reportID = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette rapport";
            throw new PolygonException(msg);
        }
        return true;
    }

    // Laver en rapport ud fra input
    public static List <Rapport> getRapport() throws ClassNotFoundException{
       List <Rapport> rapports = new ArrayList ();
       String sql = "SELECT * FROM report;";
       
       try{
           Connector DB = Connector.getInstance();
           Statement stmt = DB.getConnection().createStatement();
           ResultSet res = stmt.executeQuery(sql);
           
       while(res.next()){
            int reportID = res.getInt("reportID");
            int buildingID = res.getInt("buildingID");
            String dato = res.getString("dato");
            String kommentar = res.getString("kommentar");
            String skadestype = res.getString("skadestype");
            int skadesomfang = res.getInt("skadesomfang");
            String skadeslokalition = res.getString("skadeslokalition");
            String floor = res.getString("floor");
            String udført = res.getString("udført");
         rapports.add(new Rapport(reportID, buildingID,dato,kommentar,skadestype,skadesomfang, skadeslokalition, floor, udført));
          
           
       }
     System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return rapports;
    //Husk at lave remove report baseret på id
    }
  public static void createRapport(Rapport r) throws ClassNotFoundException, SQLException {
        int buildingID = r.getBuildingID();
        String dato = r.getDato();
        String kommentar = r.getKommentar();
        String skadestype = r.getSkadestype();
        int skadesomfang = r.getSkadesomfang();
        String skadeslokalition = r.getSkadeslokalition();
        String floor = r.getFloor();
        InputStream pic = r.getPic();
        String udført = r.getUdført();
        String sql = "INSERT INTO report ( buildingID, dato, kommentar, skadestype, skadesomfang, skadeslokalition, floor, pic,udført) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setInt(1, buildingID);
        stmt.setString(2, dato);
        stmt.setString(3, kommentar);
        stmt.setString(4, skadestype);
        stmt.setInt(5, skadesomfang);
        stmt.setString(6, skadeslokalition);
        stmt.setString(7, floor);
        stmt.setBlob(8, pic);
        stmt.setString(9, udført);
              

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rapport added");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("I broke somewhere SQLExeception " + ex.getMessage());
        }
    }

    public static void updateRapportBlob(Rapport r, int id) throws ClassNotFoundException, SQLException {
        String dato = r.getDato();
        String kommentar = r.getKommentar();
        String skadestype = r.getSkadestype();
        int skadesomfang = r.getSkadesomfang();
        String skadeslokalition = r.getSkadeslokalition();
        String floor = r.getFloor();
        InputStream pic = r.getPic();
        String udført = r.getUdført();
        String sql = "UPDATE report SET dato=?, kommentar=?, skadestype=?, skadesomfang=?, skadeslokalition=?, floor=?, pic=?, udført=? WHERE reportID = '" + id + "';";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setString(1, dato);
        stmt.setString(2, kommentar);
        stmt.setString(3, skadestype);
        stmt.setInt(4, skadesomfang);
        stmt.setString(5, skadeslokalition);
        stmt.setString(6, floor);
        stmt.setBlob(7, pic);
        stmt.setString(8, udført);

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }

        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
   }
    
    public static void updateRapport(Rapport r, int id) throws ClassNotFoundException, SQLException {
        String dato = r.getDato();
        String kommentar = r.getKommentar();
        String skadestype = r.getSkadestype();
        int skadesomfang = r.getSkadesomfang();
        String skadeslokalition = r.getSkadeslokalition();
        String floor = r.getFloor();
        String udført = r.getUdført();
        String sql = "UPDATE report SET dato=?, kommentar=?, skadestype=?, skadesomfang=?, skadeslokalition=?, floor=?, udført=? WHERE reportID = '" + id + "';";
        PreparedStatement stmt = Connector.prepare(sql);
        stmt.setString(1, dato);
        stmt.setString(2, kommentar);
        stmt.setString(3, skadestype);
        stmt.setInt(4, skadesomfang);
        stmt.setString(5, skadeslokalition);
        stmt.setString(6, floor);
        stmt.setString(7, udført);

        System.out.println(sql);
        try {
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }

        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
   }
    
    public static List<RapportImg> getRimgs() throws SQLException, ClassNotFoundException {
        List<RapportImg> rimgs = new ArrayList();
        String sql = "SELECT pic, reportID FROM report;";

        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                    int reportID = res.getInt("reportID");
                    Blob pic = res.getBlob("pic");
                rimgs.add(new RapportImg(pic, reportID));
                
                 
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return rimgs;
    }
}

    




