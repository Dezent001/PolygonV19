<%@page import="LogikLag.Entities.User"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="LogikLag.Entities.Building"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
String LoginType = (String) request.getSession().getAttribute("user_type");
String buildingID = (String) request.getSession().getAttribute("BuildingId");
if (LoginType=="3" || LoginType==null){
    response.sendRedirect("index.html");
}   
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ret Bygning</title>
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
        <% 
        List<Building> buildings = ((ArrayList<Building>)DomainFacade.getBuildings()); 
        for (int i = 0; i < buildings.size(); i++) {
        int bID = Integer.parseInt(buildingID);
            if (bID == buildings.get(i).getBuildingID()){
                
                List<User> users = ((ArrayList<User>)DomainFacade.getUsers());
                    for( int u = 0; u<users.size(); u++){
                                    
                        int uID = buildings.get(i).getUserID();
                                
                            if(uID == users.get(u).getUserID()){
        %>
        <form method = "post" action="CreateBuilding" enctype="multipart/form-data">

            <h2> <%out.print(users.get(i).getFirmName());%></h2>
            <table cellspacing="10" cellpadding="10" style="border-collapse: collapse;">
                         <tr>
                             <td>Adresse:</td>
                             <td><input class="form-control" type ="text" name ="street" value="<%out.print(buildings.get(i).getStreet());%>"/></td>
                         </tr>
                         <tr>
                             <td>Postnummer:</td>
                             <td><input class="form-control" type ="text" name ="zipID" value="<%out.print(buildings.get(i).getzipID());%>"/></td>
                         </tr>
                         <tr>
                             <td>Kvadratmeter: </td>
                             <td><input class="form-control" type ="text" name ="kvadratmeter" value="<%out.print(buildings.get(i).getM2());%>"/></td>
                         </tr>
                         <tr>
                             <td>Antal etager: </td>
                             <td><input class="form-control" type ="text" name ="floors" value="<%out.print(buildings.get(i).getFloors());;%>"/></td>
                         </tr>
                         <tr>
                             <td>Plantegning: </td>
                             <td><input class="form-control" type ="file" name ="Blobfile"/></td>
                         </tr>
                       
                     </table>
            <input  class="btn btn-primary" type ="Submit" name ="Opret" value = "Ret bygning"/>
            <input type="hidden" name="bID" value="<%out.print(buildings.get(i).getBuildingID());%>"/>
            <input type="hidden" name="valg" value="rettet"/>
        </form>
            </div>
        </div>
              </div>
            </div>
        </div>    
        <%}}}}%>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>