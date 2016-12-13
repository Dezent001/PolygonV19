<%-- 
    Document   : RetRapport
    Created on : 23-11-2016, 17:26:25
    Author     : Rune
--%>

<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="LogikLag.Entities.Rapport"%>
<%@page import="PresentationLayer.CreateRapport"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<%
String LoginType = (String) request.getSession().getAttribute("user_type");
String rapportID = (String) request.getSession().getAttribute("RapportId");
if (LoginType=="1" || LoginType=="3" || LoginType==null){
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
      <title>Rediger rapport</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
             <div class="row">
            <div class="col-md-6"><h2>Rediger rapport</h2></div>
            <div class="col-md-6"><img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="width:304px;height:75px;"></div>
        </div>
             <hr class="colorgraph"/>
        
        <% 
            
            List<Rapport> reports = ((ArrayList<Rapport>)DomainFacade.getReports());
            for( int i =0; i<reports.size(); i++){
            int rID = Integer.parseInt(rapportID);
            if(rID == reports.get(i).getReportID()){
                         
            %>
            
                 <form method = "post" action="CreateRapport" enctype="multipart/form-data">
                
                         <tr>
                             <td>dato</td>
                             <td><input class="form-control" type="text" name ="dato" value = "<% out.print(reports.get(i).getDato());%>"/><br><p/>
                         </tr>
                         <tr>
                             <td>kommentar</td>
                             <td><input class="form-control" type="text" name ="kommentar" value = "<% out.print(reports.get(i).getKommentar());%>"/><br><p/>
                         </tr>
                         <tr>
                             <td>skadesType</td>
                             <td><input class="form-control" type="text" name ="skadesType" value = "<% out.print(reports.get(i).getSkadestype());%>"/><br><p/>
                         </tr>
                         <tr>
                             <td>skadesLokation</td>
                             <td><input class="form-control" type="text" name ="skadesLokation" value = "<% out.print(reports.get(i).getSkadeslokalition());%>"/><br><p/>
                         </tr>
                           <tr>
                             <td>floor</td>
                             <td><input class="form-control" type="text" name ="floor" value = "<% out.print(reports.get(i).getFloor());%>"/><br><p/>
                         </tr>
                         <tr>
                             <td>Billede af skaden: </td>
                             <td><input class="form-control" type ="file" name ="Blobfile"/></td>
                         </tr>
            
             <p> Udført
              <select class="form-control" name="udfort">
              <%if ("Nej".equals(reports.get(i).getUdført())){%>
              <option class="form-control" value="Nej">Nej</option>
              <option class="form-control" value="Ja">Ja</option>
              <%}else{%>
              <option class="form-control" value="Ja">Ja</option>
              <option class="form-control"value="Nej">Nej</option>
              <%}%>
              </select><p/>
              <input  class="btn btn-primary btn-block" type ="Submit" name ="Opret" value = "Ret Rapport"/>     
              <input type="hidden" name="rID" value="<%out.print(reports.get(i).getReportID());%>"/>
              <input type="hidden" name="valg" value = "rettet"/> 
              <form/>
              <%}}%>    
            </div>
               <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
                </div>
             </div>
    </body>
</html>