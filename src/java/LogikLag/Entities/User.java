/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikLag.Entities;

/**
 *
 * @author Rune
 */
public class User {
    private int userID;
    private int zipID;
    private String usertype;
    private String firmName;
    private String ContactFirstName;
    private String ContactLastName;
    private String telefon;
    private String mail;
    private int cvr;
    private String gade;
    private String password;

    /**
     * @param userID
     * @param zipID
     * @param usertype
     * @param firmName
     * @param ContactFirstName
     * @param ContactLastName
     * @param telefon
     * @param mail
     * @param cvr
     * @param gade
     * @param password
     */
    
    public User( int userID, int zipID, String usertype, String firmName, String ContactFirstName, String ContactLastName, String telefon, String mail, int cvr, String gade, String password) {
        this.userID = userID;
        this.zipID = zipID;
        this.usertype = usertype;
        this.firmName = firmName;
        this.ContactFirstName = ContactFirstName;
        this.ContactLastName = ContactLastName;
        this.telefon = telefon;
        this.mail = mail;
        this.cvr = cvr;
        this.gade = gade;
        this.password = password;
    }

    public User(int zipID, String usertype, String firmName, String ContactFirstName, String ContactLastName, String telefon, String mail, int cvr, String gade, String password) {
        this.zipID = zipID;
        this.usertype = usertype;
        this.firmName = firmName;
        this.ContactFirstName = ContactFirstName;
        this.ContactLastName = ContactLastName;
        this.telefon = telefon;
        this.mail = mail;
        this.cvr = cvr;
        this.gade = gade;
        this.password = password;
    }

 


    public User(String usertype, String ContactFirstName, String ContactLastName, String firmName, int zipID, String gade, int cvr, String telefon, String mail, String password) {
        this.zipID = zipID;
        this.usertype = usertype;
        this.firmName = firmName;
        this.ContactFirstName = ContactFirstName;
        this.ContactLastName = ContactLastName;
        this.telefon = telefon;
        this.mail = mail;
        this.cvr = cvr;
        this.gade = gade;
        this.password = password;
    }
    
    public User(int userID,String usertype, String ContactFirstName, String ContactLastName, String firmName, int zipID, String gade, int cvr, String telefon, String mail, String password) {
        this.userID = userID;
        this.zipID = zipID;
        this.usertype = usertype;
        this.firmName = firmName;
        this.ContactFirstName = ContactFirstName;
        this.ContactLastName = ContactLastName;
        this.telefon = telefon;
        this.mail = mail;
        this.cvr = cvr;
        this.gade = gade;
        this.password = password;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the zipID
     */
    public int getZipID() {
        return zipID;
    }

    /**
     * @param zipID the zipID to set
     */
    public void setZipID(int zipID) {
        this.zipID = zipID;
    }

    /**
     * @return the usertype
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * @return the firmName
     */
    public String getFirmName() {
        return firmName;
    }

    /**
     * @param firmName the firmName to set
     */
    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    /**
     * @return the ContactFirstName
     */
    public String getContactFirstName() {
        return ContactFirstName;
    }

    /**
     * @param ContactFirstName the ContactFirstName to set
     */
    public void setContactFirstName(String ContactFirstName) {
        this.ContactFirstName = ContactFirstName;
    }

    /**
     * @return the ContactLAstName
     */
    public String getContactLastName() {
        return ContactLastName;
    }

    /**
     * @param ContactLAstName the ContactLAstName to set
     */
    public void setContactLastName(String ContactLAstName) {
        this.ContactLastName = ContactLAstName;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the cvr
     */
    public int getCvr() {
        return cvr;
    }

    /**
     * @param cvr the cvr to set
     */
    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    /**
     * @return the gade
     */
    public String getGade() {
        return gade;
    }

    /**
     * @param gade the gade to set
     */
    public void setGade(String gade) {
        this.gade = gade;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    }

