<%-- 
    Document   : Forespørgelse
    Created on : 04-12-2016, 15:42:06
    Author     : JonasSchack
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret Forespørgelse</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
        <div class="container">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
             <h2>Opret forespørgelse</h2>
             <hr class="colorgraph"/>
            
        <form method = "post" action="CreateUser">
            <p>Postnummer:<input class="form-control"  type ="text" name ="zipID"/><br/><p/>
            <p>Bruger type:       
            <select class="form-control" name="usertype">
            <option value="2">Bruger</option>
            <option value="3">3.Part</option>
            </select><p/>
            <p>Fornavn:<input class="form-control" type ="text" name ="ContactFirstName"/><br/><p/>
            <p>Efternavn:<input class="form-control" type ="text" name ="ContactLastName"/><br/><p/>
            <p>Firmanavn:<input class="form-control" type ="text" name ="firmName"/><br/><p/>
            <p>Gade:<input class="form-control" type ="text" name ="gade"/><br/><p/>
            <p>CVR:<input class="form-control" type ="text" name ="cvr"/><br/><p/>
            <p>Telefon:<input class="form-control" type ="text" name ="telefon"/><br/><p/>
            <p>e-Mail:<input class="form-control" type ="text" name ="mail"/><br/><p/>
            <p>Ønsket password:<input class="form-control"  type ="password" name ="password1"/><br/><p/>
            <p>Gentag password:<input class="form-control"  type ="password" name ="password2"/><br/><p/>
             
             
            <input class="btn btn-primary btn-block"  type ="Submit" name ="Opret" value = "Opret"/>
             <input  type="hidden" name="ret" value="request"/>
          
        </form>
                      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
            </div>
    </body>
</html>
