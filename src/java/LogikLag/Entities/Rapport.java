/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag.Entities;

import java.io.InputStream;

/**
 *
 * @author JonasSchack
 */
public class Rapport {
    
    
    private int reportID;
    private int buildingID;
    private String dato;
    private String kommentar;
    private String skadestype;
    private int skadesomfang;
    private String skadeslokalition;
    private String floor;
    private InputStream pic;
    private String udført;

    public Rapport(int reportID, int buildingID, String dato, String kommentar, String skadestype, int skadesomfang, String skadeslokalition, String floor, String udført) {
        this.reportID = reportID;
        this.buildingID = buildingID;
        this.dato = dato;
        this.kommentar = kommentar;
        this.skadestype = skadestype;
        this.skadesomfang = skadesomfang;
        this.skadeslokalition = skadeslokalition;
        this.floor = floor;
        this.udført = udført;
    }

    public Rapport(int buildingID, String dato, String kommentar, String skadestype, int skadesomfang, String skadeslokalition, String floor, InputStream pic,String udført) {
        this.buildingID = buildingID;
        this.dato = dato;
        this.kommentar = kommentar;
        this.skadestype = skadestype;
        this.skadesomfang = skadesomfang;
        this.skadeslokalition = skadeslokalition;
        this.floor = floor;
        this.pic = pic;
        this.udført = udført;
    }

    public Rapport(String dato, String kommentar, String skadesType, String skadesLokalition, String floor, String udført) {
        this.dato = dato;
        this.kommentar = kommentar;
        this.skadestype = skadesType;
        this.skadeslokalition = skadesLokalition;
        this.floor = floor;
        this.udført = udført;
    }

    public Rapport(String dato, String kommentar, String skadesType, String skadesLokalition, String floor, InputStream pic, String udført) {
        this.dato = dato;
        this.kommentar = kommentar;
        this.skadestype = skadesType;
        this.skadeslokalition = skadesLokalition;
        this.floor = floor;
        this.pic = pic;
        this.udført = udført;
    }

    public Rapport(int reportID, int buildingID, String dato, String kommentar, String skadestype, int skadesomfang, String skadeslokalition, String floor, InputStream pic, String udført) {
        this.reportID = reportID;
        this.buildingID = buildingID;
        this.dato = dato;
        this.kommentar = kommentar;
        this.skadestype = skadestype;
        this.skadesomfang = skadesomfang;
        this.skadeslokalition = skadeslokalition;
        this.floor = floor;
        this.pic = pic;
        this.udført = udført;
    }

    public InputStream getPic() {
        return pic;
    }

    public void setPic(InputStream pic) {
        this.pic = pic;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }


    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getSkadestype() {
        return skadestype;
    }

    public void setSkadestype(String skadestype) {
        this.skadestype = skadestype;
    }

    public int getSkadesomfang() {
        return skadesomfang;
    }

    public void setSkadesomfang(int skadesomfang) {
        this.skadesomfang = skadesomfang;
    }

    public String getSkadeslokalition() {
        return skadeslokalition;
    }

    public void setSkadeslokalition(String skadeslokalition) {
        this.skadeslokalition = skadeslokalition;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getUdført() {
        return udført;
    }

    public void setUdført(String udført) {
        this.udført = udført;
    }
}
