
package DataLag;


import LogikLag.PolygonException;
import LogikLag.Entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


/**
 *
 * @author Rune
 */
public class UserMapper {

    public static List <User> getUser(){
       List <User> users = new ArrayList ();
       String sql = "SELECT * from users;";
       
       try{
           System.out.println("");
           Connector DB = Connector.getInstance();
           try (Statement stmt = DB.getConnection().createStatement()) {
               ResultSet res = stmt.executeQuery(sql);
               
               while(res.next()){
                   int userID = res.getInt("userID");
                   int zipID = res.getInt("zipID");
                   String usertype = res.getString("usertype");
                   String firmName = res.getString("firmName");
                   String ContactFirstName = res.getString("ContactFirstName");
                   String ContactLastName = res.getString("ContactLastName");
                   String telefon = res.getString("telefon");
                   String mail = res.getString("mail");
                   int cvr = res.getInt("cvr");
                   String gade = res.getString("gade");
                   String password = res.getString("password");
                   User user = new User(userID,zipID,usertype,firmName,ContactFirstName,ContactLastName,telefon,mail,cvr,gade,password);
                   users.add(user);
                   
               }   }
       return users;
        
    } catch (SQLException | ClassNotFoundException ex){
        System.out.println("FEJL i getuser mapper");
       // String msg = "kunne ikke finde listen af bruger(e)";
        //throw new PolygonException(msg);
}
        return null;
    }

  public static void createUser(User u) throws ClassNotFoundException, SQLException {
        int zipID            = u.getZipID();
        String usertype      = u.getUsertype();
        String firmName      = u.getFirmName();
        String ContactFirstName   = u.getContactFirstName();
        String ContactLastName    = u.getContactLastName();
        String telefon       = u.getTelefon();
        String mail          = u.getMail();
        int cvr              = u.getCvr();
        String gade          = u.getGade();
        String password      = u.getPassword();
        String sql = "INSERT INTO users "
                + "(zipID, usertype, firmName, ContactFirstName, ContactLastName, telefon, mail, cvr, gade, password) "
                + "VALUES "
                + "("
                + zipID + ","
                + usertype + ","
                + "'" + firmName + "'" + ","
                + "'" + ContactFirstName + "'" + ","
                + "'" + ContactLastName + "'" + ","
                + "'" + telefon + "'" + ","
                + "'" + mail + "'" + ","
                + cvr + ","
                + "'" + gade + "'" + ","
                + "'" + password + "')";
              

        System.out.println(sql);
        try {
            PreparedStatement stmt = Connector.prepare(sql);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added");
                String msg = "Brugeren blev tilføjet";
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("I broke somewhere SQLExeception " + ex.getMessage());
        }
    }
  
  public static boolean removeUser(int id) throws PolygonException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE userID = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette user";
            throw new PolygonException(msg);
        }
        return true;
    }

    public static void updateUser(User u, int id) throws ClassNotFoundException {

        String usertype = u.getUsertype();
        String ContactFirstName = u.getContactFirstName();
        String ContactLastName = u.getContactLastName();
        String firmName = u.getFirmName();
        int zipID =  u.getZipID();
        String gade = u.getGade();
        int cvr = u.getCvr();
        String telefon = u.getTelefon();
        String mail = u.getMail();
        String password = u.getPassword();

        String sql = "UPDATE users SET usertype='" + usertype+ "',ContactFirstName='" + ContactFirstName + "',ContactLastName='" + ContactLastName + "',firmName='" + firmName + 
                "',zipID=" + zipID + ",gade='" + gade + "',cvr=" + cvr +  ",telefon='" + telefon + "',mail='" + mail + "',password='" + password +
                "' WHERE userID= '" + id + "';";
        try {
            PreparedStatement stmt = Connector.prepare(sql);
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
   public static void requestUser(User r) throws ClassNotFoundException, SQLException {
        int zipID            = r.getZipID();
        String usertype      = r.getUsertype();
        String firmName      = r.getFirmName();
        String ContactFirstName   = r.getContactFirstName();
        String ContactLastName    = r.getContactLastName();
        String telefon       = r.getTelefon();
        String mail          = r.getMail();
        int cvr              = r.getCvr();
        String gade          = r.getGade();
        String password      = r.getPassword();
        String sql = "INSERT INTO userrequest "
                + "(zipID, usertype, firmName, ContactFirstName, ContactLastName, telefon, mail, cvr, gade, password) "
                + "VALUES "
                + "("
                + zipID + ","
                + usertype + ","
                + "'" + firmName + "'" + ","
                + "'" + ContactFirstName + "'" + ","
                + "'" + ContactLastName + "'" + ","
                + "'" + telefon + "'" + ","
                + "'" + mail + "'" + ","
                + cvr + ","
                + "'" + gade + "'" + ","
                + "'" + password + "')";
              

        System.out.println(sql);
        try {
            PreparedStatement stmt = Connector.prepare(sql);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("UserRequest added");
                String msg = "Brugeren blev tilføjet i request DB";
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("I broke somewhere SQLExeception " + ex.getMessage());
        }
    }
   
       public static List <User> getUserRequest(){
       List <User> userrequest = new ArrayList ();
       String sql = "SELECT * from userrequest;";
       
       try{
           System.out.println("");
           Connector DB = Connector.getInstance();
           try (Statement stmt = DB.getConnection().createStatement()) {
               ResultSet res = stmt.executeQuery(sql);
               
               while(res.next()){
                   int userID = res.getInt("requestID");
                   int zipID = res.getInt("zipID");
                   String usertype = res.getString("usertype");
                   String firmName = res.getString("firmName");
                   String ContactFirstName = res.getString("ContactFirstName");
                   String ContactLastName = res.getString("ContactLastName");
                   String telefon = res.getString("telefon");
                   String mail = res.getString("mail");
                   int cvr = res.getInt("cvr");
                   String gade = res.getString("gade");
                   String password = res.getString("password");
                   User user = new User(userID,zipID,usertype,firmName,ContactFirstName,ContactLastName,telefon,mail,cvr,gade,password);
                   userrequest.add(user);
                   
               }   }
       return userrequest;
        
    } catch (SQLException | ClassNotFoundException ex){
        System.out.println("FEJL i getuser mapper");
       // String msg = "kunne ikke finde listen af bruger(e)";
        //throw new PolygonException(msg);
}
        return null;
    }
 
public static boolean removeUserRequest(int id) throws PolygonException, ClassNotFoundException {
        String sql = "DELETE FROM userrequest WHERE requestid = '" + id + "';";

        try (PreparedStatement ps = Connector.prepare(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            String msg = "kunne ikke slette userrequest";
            throw new PolygonException(msg);
        }
        return true;
    }
   
}

