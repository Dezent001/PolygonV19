<%-- 
    Document   : VisBygningPoly
    Created on : 09-11-2016, 22:58:08
    Author     : JonasSchack
--%>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="2" || LoginType==null) {
    response.sendRedirect("index.html");
}
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@page import="java.util.HashMap"%>
<%@page import="LogikLag.Entities.Zip"%>
<%@page import="LogikLag.Entities.Building"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="LogikLag.Entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLag.BuildingMapper"%>
<%@page import="DataLag.UserMapper"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body><div class="container">
        
        <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
        
        <div class="row">
            <div class="col-md-4"><h2>Bygnings oversigt</h2></div>
            <div class="col-md-5"><img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="width:304px;height:75px;"></div>
            <div class="col-md-3"><h3><a class="btn btn-success btn-block"href="OpretBygning.jsp">Opret Bygning</a></h3></div>
        </div>
        <hr class="colorgraph"/>
    <div class="row" align="center">
        
         
        <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
            <tr>
                <th>Bygningen</th>
                <th>Firma</th>
                <th>Adresse</th>
                <th>By</th>
                <th>Kvadratmeter</th>
                <th>Antal etager</th>
                <th>Muligheder</th>
                <th>Godkend</th>
            </tr>
<% 
List<Building> buildings = ((ArrayList<Building>)DomainFacade.getBuildings()); 
    for (int i = 0; i < buildings.size(); i++) {
                                    
                int uID = buildings.get(i).getUserID();
                                
List<User> users = ((ArrayList<User>)DomainFacade.getUsers());
    for( int u = 0; u<users.size(); u++){
    
                if(uID == users.get(u).getUserID()){
                                        
                    int id = buildings.get(i).getzipID();                
                    HashMap<Integer, Zip> zip = (DomainFacade.getZips());
%>
              
                <tr>
                <form method = "post" action="CreateBuilding">
                    <td>
                    <a href="BimgHandler?id=<%=buildings.get(i).getBuildingID()%>"><img src="BimgHandler?id=<%out.print(buildings.get(i).getBuildingID());%>" height="160" width="160"/></a>
                    </td>
                    <td><b><%out.print(users.get(u).getFirmName());%></b></td>
                    <td><%out.print(buildings.get(i).getStreet());%></td>
                    <td><%=zip.get(id).getCity()%><br><%=zip.get(id).getZipcodes()%></td>
                    <td><%out.print(buildings.get(i).getM2());%></td>
                    <td><%out.print(buildings.get(i).getFloors());%></td>
                    <td><select name="valg">
                    <option value="vis">Vis rapport</option>
                    <option value="ret">Ret Bygning</option>
                    <option value="slet">Slet bygning</option>
                        </select></td>
                    <td><input class="btn btn-primary btn-block" type="Submit" name ="" value ="Vælg"></td>
                    <input type="hidden" name ="buildingid" value ="<%out.print(buildings.get(i).getBuildingID());%>">
        </form>
                </tr>
                
            <%}}}%>
               
        </table>
    </div>
            </div>
        </div>
                </<div>
                          </div>
            </div>
        </div>  
                </div>
                <div class="col-md-11"><a href="HelpDesk.jsp">help</a>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>

