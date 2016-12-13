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
public class BuildingImg {
    
private InputStream floorplan;
private int buildingID;


    public BuildingImg(InputStream floorplan, int buildingID) {
        this.floorplan = floorplan;
        this.buildingID = buildingID;
    }

    public InputStream getFloorplan() {
        return floorplan;
    }

    public void setFloorplan(InputStream floorplan) {
        this.floorplan = floorplan;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }
    
}
