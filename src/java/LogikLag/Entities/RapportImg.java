/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag.Entities;

import java.sql.Blob;

/**
 *
 * @author Runej
 */
public class RapportImg {
    
private Blob pic;
private int reportID;

    public RapportImg(Blob pic, int reportID) {
        this.pic = pic;
        this.reportID = reportID;
    }

    public Blob getPic() {
        return pic;
    }

    public void setPic(Blob pic) {
        this.pic = pic;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

}
