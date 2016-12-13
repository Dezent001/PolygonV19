<%-- 
    Document   : VisDetaljeRapport
    Created on : 29-11-2016, 23:25:20
    Author     : Runej
--%>
<%@page import="LogikLag.Entities.Building"%>
<%@page import="LogikLag.Entities.Rapport"%>
<%@page import="java.util.HashMap"%>
<%@page import="LogikLag.Entities.Zip"%>
<%@page import="LogikLag.Entities.User"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
<div class="row" align="center">
<img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" alt="www.polygongroup.com/da-DK/">
</div>
<% 
String buildingID = (String) request.getSession().getAttribute("BuildingId");
String rapportID = (String) request.getSession().getAttribute("RapportId");
List<Building> buildings = ((ArrayList<Building>)DomainFacade.getBuildings()); 
for (int i = 0; i < buildings.size(); i++) {
    
    int bID = Integer.parseInt(buildingID);
    
        if(bID == buildings.get(i).getBuildingID()){
            
            List<Rapport> reports = ((ArrayList<Rapport>)DomainFacade.getReports());
                for( int e =0; e<reports.size(); e++){
                    
                    int rID = Integer.parseInt(rapportID);
            
                        if(rID == reports.get(e).getReportID()){    
                            
                            List<User> users = ((ArrayList<User>)DomainFacade.getUsers());
                                for( int u = 0; u<users.size(); u++){
                                    
                                    int uID = buildings.get(i).getUserID();
                                
                                    if(uID == users.get(u).getUserID()){
                                        
                                        int id = buildings.get(i).getzipID();                
                                        HashMap<Integer, Zip> zip = (DomainFacade.getZips());
        
%>
        <div class="container">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<fieldset>
		        <hr class="colorgraph">
                            <div class="row" align="center">
                            <h1><%out.print(users.get(u).getFirmName());%></h1>
                            </div>
                            <div class="col-md-6"><h4><b>Adresse:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(buildings.get(i).getStreet());%></h4></div>
                            <div class="col-md-6"><h4><b>Postnummer:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(buildings.get(i).getzipID());%></h4></div>
                            <div class="col-md-6"><h4><b>By:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(zip.get(id).getCity());%></h4></div>
                            <div class="col-md-6"><h4><b>Kontakt person:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(users.get(u).getContactFirstName());%> <%out.print(users.get(u).getContactLastName());%></h4></div>
                            <div class="col-md-6"><h4><b>Telefon:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(users.get(u).getTelefon());%></h4></div>
                            <div class="col-md-6"><h4><b>E-Mail:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(users.get(u).getMail());%></h4></div>
                            <div class="row" align="center"><h3><b>Kommentar:</b></h3></div>
                            <table class ="table table-bordered " border="1" cellpadding="5">
                                <th><div class="col-md-12"><h4><%out.print(reports.get(e).getKommentar());%></h4></div></th>
                            </table>
                            <div class="col-md-6"><h4><b>Skadens type:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(reports.get(e).getSkadestype());%></h4></div>
                            <div class="col-md-6"><h4><b>Skadens lokation:</b></h4></div>
                            <div class="col-md-6"><h4><%out.print(reports.get(e).getSkadeslokalition());%></h4></div>
                            <div class="col-md-2"><h4><b>Omfang:</b></h4></div>
                            <div class="col-md-2"><h4><%out.print(reports.get(e).getSkadesomfang());%></h4></div>
                            <div class="col-md-2"><h4><b>Sal:</b></h4></div>
                            <div class="col-md-2"><h4><%out.print(reports.get(e).getFloor());%></h4></div>
                            <div class="col-md-2"><h4><b>Udført?:</b></h4></div>
                            <div class="col-md-2"><h4><%out.print(reports.get(e).getUdført());%></h4></div>
                            
                            <div class="row" align="center">
                            <div class="row" align="center"><h3><b>Plantegning:</b></h3></div><br>
                            <img src="BimgHandler?id=<%out.print(buildings.get(i).getBuildingID());%>" width="600"/></a><br>
                            <div class="row" align="center"><h3><b>Billede af skaden:</b></h3></div><br>
                            <img src="RimgHandler?id=<%out.print(reports.get(e).getReportID());%>" width="600"/></a><br>
                            
                            <script>
                            function printPage() {
                            window.print();  
                            }
                            </script>
                            <form>
                                <div class="col-md-4"><h1></h1></div><div class="col-md-4"><input class="btn btn-primary btn-block" type="button" onClick="printPage()" value="Print"></div>
                            </form>
                            </div>
				</div>
			</fieldset>
                            
<%}}}}}}%>

	</div>
</div>
</div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>
