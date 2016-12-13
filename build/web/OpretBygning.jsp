<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="1" || LoginType=="3" || LoginType==null){
    response.sendRedirect("index.html");
}   
String msg;
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret Bygning</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body><div class="container">
        
        <div class="col-md-11"><a href="UserPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
        
        <div class="row">
            <div class="col-md-10"><h2>Bygnings oversigt</h2></div>
            
            <div class="col-md-2"><h3><a class="btn btn-success btn-block"href="OpretBygning.jsp">Opret Bygning</a></h3></div>
        </div>
        <hr class="colorgraph"/>
    <div class="row" align="center">
        
         
        <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
      
        
        <form method = "post" action="CreateBuilding" enctype="multipart/form-data">
            <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
            <p>Adresse:             <input  class="form-control" type ="text" name ="street"/><br/><p/>
            <p>Postnummer:       <input class="form-control" type ="text" name ="zipID"/><br/><p/>
            <p>Kvadratmeter:       <input class="form-control" type ="text" name ="m2"/><br/><p/>
            <p>Antal etager:       <input class="form-control" type ="text" name ="floors"/><br/><p/>
            <p>Plantegning:       <input class="form-control" type ="file" name ="Blobfile"/><br/><p/>
            <td><input class="btn btn-primary btn-block" type="Submit" name ="Opret" value ="Opret"></td>
            <input type="hidden" name="valg" value="add"/>
        </form>
            </div>
        </div>  
            </<div>
                 </<div>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>