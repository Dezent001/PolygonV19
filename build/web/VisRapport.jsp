<%-- 
    Document   : VisRapportUser
    Created on : 11-11-2016, 12:54:32
    Author     : JonasSchack
--%>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType==null) {
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
<%@page import="LogikLag.Entities.Rapport"%>
<%@page import="LogikLag.Entities.Building"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="LogikLag.Entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLag.BuildingMapper"%>
<%@page import="DataLag.UserMapper"%>
<%@page import="DataLag.RapportMapper"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body><div class="container">
        
            <div class="col-md-11"><a<%if (LoginType.equals("1")){%> href="PolyPage.jsp"<%}else{%> href="UserPage.jsp"<%}%>>Tilbage til menu</a></div>
            <div class="col-md-1"><a href="index.html">logout</a></div>
        
        <div class="row">
            <div class="col-md-4"><h2>Rapport oversigt</h2></div>
            <div class="col-md-5"><img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="width:304px;height:75px;"></div>
            <div class="col-md-3"><h3><a class="btn btn-success btn-block"href="OpretRapport.jsp">Opret rapport</a></h3></div>
        </div>
        <hr class="colorgraph"/>
    <div class="row" align="center">
        
         
        <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
           
            <tr>
                <th>Billede</th>
                <th>dato</th>
                <th>kommentar</th>
                <th>skadestype</th>
                <th>skadesomfang</th>
                <th>skadeslokation</th>
                <th>Etage</th>
                <th>udført</th>
                <th>Handling</th>
                <th>Godkend</th>
            </tr>
            
    
<% 
String buildingID = (String) request.getSession().getAttribute("BuildingId");
List<Rapport> reports = ((ArrayList<Rapport>)DomainFacade.getReports()); 
for (int i = 0; i < reports.size(); i++) {
    int bID = Integer.parseInt(buildingID);
            if (bID == reports.get(i).getBuildingID()){
%>
                <tr>
        <form method = "post" action="CreateRapport">
                    <td><a href="RimgHandler?id=<%out.print(reports.get(i).getReportID());%>"><img src="RimgHandler?id=<%out.print(reports.get(i).getReportID());%>" height="160" width="160"/></a></td>
                    <td><%out.print(reports.get(i).getDato());%></td>
                    <td><%out.print(reports.get(i).getKommentar());%></td>
                    <td><%out.print(reports.get(i).getSkadestype());%></td>
                    <td><%out.print(reports.get(i).getSkadesomfang());%></td>
                    <td><%out.print(reports.get(i).getSkadeslokalition());%></td>
                    <td><%out.print(reports.get(i).getFloor());%></td>
                    <td><%out.print(reports.get(i).getUdført());%></td>
                    <td><select name="valg">
                    <option value="vis">Vis rapport</option>
                    <option value="ret">Rediger rapport</option>
                    <option value="slet">Slet rapport</option>
                    </select></td>
                     <td><input class="btn btn-primary btn-block" type="Submit" name ="" value ="Vælg"></td>
                    <input type="hidden" name ="rapportID" value ="<%out.print(reports.get(i).getReportID());%>">
        </form>
                </tr>
            <%}}%>
                
              
        </table>
    </div>
            </div>
              <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>