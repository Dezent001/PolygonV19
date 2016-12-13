<%-- 
    Document   : OpretRapport
    Created on : 09-11-2016, 13:48:23
    Author     : JonasSchack
--%>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="2" || LoginType=="3"){
    response.sendRedirect("index.html");
}   
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret Rapport</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
             <hr class="colorgraph"/>
    
        <h1>Opret rapport</h1>
        <form method = "post" action="CreateRapport" enctype="multipart/form-data">
            <p>Dato:       <input class="form-control" type ="text" name ="dato"/><br/><p/>
            <p>Kommentar:       <input class="form-control" type ="text" name ="kommentar"/><br/><p/>
            <p>Skadens type:       <input class="form-control" type ="text" name ="skadestype"/><br/><p/>
            <p>Skadens omfang:
            <select class="form-control" name="skadesomfang">
            <option value="1">1 - Skaden er underordnet</option>
            <option value="2">2 - Skaden er mindre</option>
            <option value="3">3 - Skaden er normal</option>
            <option value="4">4 - Skaden er betydelig</option>
            <option value="5">5 - Skaden er akut</option>
            </select><p/>
            <p>Skadens lokation:       <input class="form-control" type ="text" name ="skadeslokalition"/><br/><p/>
            <p>Hvilken sal skaden er på:       <input class="form-control" type ="text" name ="floor"/><br/><p/>
            <p>Billede af skaden:       <input class="form-control" type ="file" name ="Blobfile"/><br/><p/>
            <p>Er sagen behandlet?:</p>       
            <select class="form-control" name="udfort">
            <option value="Nej">Nej</option>
            <option value="Ja">Ja</option>
            </select>
            <br>
            <input  class="btn btn-primary btn-block" type ="Submit" name ="Opret" value = "Opret"/>
            <input type="hidden" name="valg" value="add"/>
        </form>
            </div>
             </div>
         </div>
        </div>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>