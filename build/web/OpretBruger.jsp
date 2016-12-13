<%-- 
    Document   : OpretBruger
    Created on : 07-11-2016, 13:48:23
    Author     : Rune
--%>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="2" || LoginType=="3" || LoginType==null){
    response.sendRedirect("index.html");
}   
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret Bruger</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
             <h2>Opret bruger</h2>
             <hr class="colorgraph"/>
            
        <form method = "post" action="CreateUser">
            <p>Postnummer:             <input class="form-control"  type ="text" name ="zipID"/><br/><p/>
            <p>Bruger type:       
            <select class="form-control" name="usertype">
            <option value="1">Polygon</option>
            <option value="2">Bruger</option>
            <option value="3">3.Part</option>
            </select><p/>
            <p>Fornavn:       <input class="form-control" type ="text" name ="ContactFirstName"/><br/><p/>
            <p>Efternavn:       <input class="form-control" type ="text" name ="ContactLastName"/><br/><p/>
            <p>Firmanavn:       <input class="form-control" type ="text" name ="firmName"/><br/><p/>
            <p>Gade:       <input class="form-control" type ="text" name ="gade"/><br/><p/>
            <p>CVR:       <input class="form-control" type ="text" name ="cvr"/><br/><p/>
            <p>Telefon:       <input class="form-control" type ="text" name ="telefon"/><br/><p/>
            <p>e-Mail:       <input class="form-control" type ="text" name ="mail"/><br/><p/>
            <p>password:<input class="form-control"  type ="text" name ="password"/><br/><p/>
            
            <input type="hidden" name="userid" value="0">
             
             
            <input class="btn btn-primary btn-block"  type ="Submit" name ="ret" value = "Opret"/>
          
        </form>
                      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
            </div>
    </body>
</html>