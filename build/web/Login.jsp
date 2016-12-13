<%-- 
    Document   : Login
    Created on : 02-12-2016, 17:25:47
    Author     : Runej
--%>
<%
request.getSession().setAttribute("user_type", null);
//session.invalidate();  
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Polygon Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
     
    
     
        <div class="container">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form method = "post" action = "Login">
			<fieldset>
				<h2>Please Sign In</h2>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="text" name="Username" class="form-control input-lg" placeholder="Brugernavn">
				</div>
				<div class="form-group">
                    <input type="password" name="password"  class="form-control input-lg" placeholder="Adgangskode">
				</div>
<div class="row" align="center">
<img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" alt="www.polygongroup.com/da-DK/">
</div>
				<span class="button-checkbox">
				
				</span>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <p><a class="btn btn-lg btn-primary btn-block" href="Forespørgelse.jsp">Send forespørgelse</a></p>
                                        </div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
</div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>
