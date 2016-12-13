/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLag;

import LogikLag.Entities.Zip;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonasSchack
 */
public class ZipMapper {
    
    public static List<Zip> getZip() throws SQLException, ClassNotFoundException {
        List<Zip> zips = new ArrayList();
        String sql;
        
                sql = "SELECT * FROM zip;";
        try {
            Connector DB = Connector.getInstance();
            Statement stmt = DB.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int zipcodes = res.getInt("zipcodes");
                String city = res.getString("city");
                zips.add(new Zip(zipcodes, city));
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return zips;
    }
}
