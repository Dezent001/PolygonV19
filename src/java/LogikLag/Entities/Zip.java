/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag.Entities;

/**
 *
 * @author JonasSchack
 */
public class Zip {
    int zipcodes;
    String city;

    public Zip(int zipcodes, String city) {
        this.zipcodes = zipcodes;
        this.city = city;
    }

    
    public int getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(int zipcodes) {
        this.zipcodes = zipcodes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
