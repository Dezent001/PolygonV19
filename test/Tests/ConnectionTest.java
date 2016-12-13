/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import DataLag.BuildingMapper;
import DataLag.RapportMapper;
import DataLag.UserMapper;
import DataLag.ZipMapper;
import LogikLag.Entities.Building;
import LogikLag.Entities.BuildingImg;
import LogikLag.Entities.Rapport;
import LogikLag.Entities.RapportImg;
import LogikLag.Entities.User;
import LogikLag.Entities.Zip;
import LogikLag.PolygonException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Runej
 */
public class ConnectionTest {

    List<Building> buildings;
    Building building;
    List<Rapport> reports;
    Rapport report;
    List<User> users;
    User user;
    List<Zip> zips;
    Zip zip;
    List<RapportImg> rimgs;
    RapportImg rapportimg;
    List<BuildingImg> bimgs;
    BuildingImg buildingimg;
    int i;
    int uID;
    String fID;

    public ConnectionTest() {
    }
//Get tests    

    @Test
    public void testGetRapport() throws PolygonException, SQLException, ClassNotFoundException {
        System.out.println("RapportMapper.GetRapport()");
        System.out.println("Rapports i DB:");
        reports = RapportMapper.getRapport();
        assertTrue(reports.size() > 0);
        for (Rapport rapport : reports) {
            assertTrue(rapport.getBuildingID() > 0);
            System.out.println("Get report buildingID: " + rapport.getBuildingID() + " rapportID: " + rapport.getReportID());
        }
    }

    @Test
    public void testGetBuilding() throws PolygonException, SQLException, ClassNotFoundException {
        System.out.println("BuildingMapper.GetBuilding()");
        System.out.println("Buildings i DB:");
        buildings = BuildingMapper.getBuildings();
        assertTrue(buildings.size() > 0);
        for (Building building : buildings) {
            assertTrue(building.getBuildingID() > 0);
            System.out.println("Get building buildingID: " + building.getBuildingID());
        }
    }

    @Test
    public void testGetUser() throws PolygonException, SQLException, ClassNotFoundException {
        System.out.println("UserMapper.GetUser()");
        System.out.println("Users i DB:");
        users = UserMapper.getUser();
        assertTrue(users.size() > 0);
        for (User user : users) {
            assertTrue(user.getUserID() > 0);
            System.out.println("Get user UserID: " + user.getUserID() + " firmname: " + user.getFirmName());
        }
    }

    @Test
    public void testGetZip() throws PolygonException, SQLException, ClassNotFoundException {
        System.out.println("ZipMapper.GetZip()");
        System.out.println("Zips i DB:");
        zips = ZipMapper.getZip();
        assertTrue(zips.size() > 0);
        for (Zip zip : zips) {
            assertTrue(zip.getCity().length() > 0 && zip.getZipcodes() > 500);
        }
        System.out.println("Get zip antal zips: " + zips.size());
    }

    @Test
    public void testGetRapportIMG() throws PolygonException, ClassNotFoundException, SQLException {
        System.out.println("RapportMapper.GetRapportImg()");
        System.out.println("rapporter i DB:");
        rimgs = RapportMapper.getRimgs();
        assertTrue(rimgs.size() > 0);
        for (RapportImg rapportImg : rimgs) {
            InputStream test = rapportImg.getPic().getBinaryStream();
            assertTrue(!test.equals(null));
            System.out.println("Get reportIMG reportID: " + rapportImg.getReportID());
        }
    }

    @Test
    public void testGetBuildingIMG() throws PolygonException, ClassNotFoundException, SQLException {
        System.out.println("BuildingMapper.GetBuildingImg()");
        System.out.println("Building i DB:");
        bimgs = BuildingMapper.getImgs();
        assertTrue(bimgs.size() > 0);
        for (BuildingImg buildingImg : bimgs) {
            assertTrue(!buildingImg.getFloorplan().equals(null));
            System.out.println("Get buildingIMG buildingID: " + buildingImg.getBuildingID());
        }
    }

    //Create tests
    @Test
    public void testCreateUser() throws PolygonException, ClassNotFoundException, SQLException {
        System.out.println("\nUserMapper.createUser()");
        users = UserMapper.getUser();
        i = users.size();
        System.out.println("Før: " + i);
        UserMapper.createUser(this.user);
        users = UserMapper.getUser();
        System.out.println("Efter: " + users.size());
        if (i == users.size()) {assertFalse(1==1);}
        else{ 
            for (int i = 0; i < users.size(); i++) {

                if ("88888888".equals(users.get(i).getTelefon())) {
                    uID = users.get(i).getUserID();
                    fID = users.get(i).getFirmName();
                    System.out.println("User oprettet med ID: " + uID + "\nUser oprettet med Firma: " + fID);
                }
            }

                    //Update Test
                    System.out.println("\nUserMapper.UpdateUser()");
                    User u = new User("1", "TestNavn", "TestEfterNavn", "NytFirma", 1000, "TestVej", 87654321, "88888888", "Test@mail.dk", "TestPassWord");
                    UserMapper.updateUser(u, uID);
                    if (!"NytFirma".equals(fID)) {

                        //Remove Test
                        System.out.println("\nUserMapper.RemoveUser()");
                        users = UserMapper.getUser();
                        i = users.size();
                        System.out.println("Før sletning: " + i);
                        UserMapper.removeUser(uID);
                        System.out.println("User slettet: " + uID);
                        users = UserMapper.getUser();
                        System.out.println("Efter: " + users.size());
                        assertFalse(users.size() == i);
                    }else{assertFalse(1==1);}
                }
            }



    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        users = new ArrayList<>();
        this.user = new User("1", "TestNavn", "TestEfterNavn", "TestFirma", 1000, "TestVej", 87654321, "88888888", "Test@mail.dk", "TestPassWord");
//        String toblob = "test1234";
//        byte[] byteContent = toblob.getBytes();
//        Blob blob = null; 
//        blob = new SerialBlob(byteContent);
//        InputStream test = blob.getBinaryStream();
//        buildings = new ArrayList<>();
//        this.building = new Building(uID, 1000, "TestVej", 42, 3, test);
//        reports = new ArrayList<>();
//        this.report = new Rapport(bID, rID, "11/11/11", "Hejsa", "slem", 3, "Iprogrammet", "1", test, "Nej");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
