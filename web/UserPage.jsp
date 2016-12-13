<%-- 
    Document   : UserPage
    Created on : 09-11-2016, 22:24:29
    Author     : JonasSchack
--%>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="1" || LoginType=="3" || LoginType==null){
    response.sendRedirect("index.html");
}   
String msg = "";
if(request.getAttribute("")!=null){
    msg = request.getAttribute("").toString();
}
%>
<%@page import="LogikLag.Entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLag.UserMapper"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
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
                            
                            <div><h2>         Velkommen <%String UserName = (String) request.getSession().getAttribute("firm_name"); out.print(UserName);%> </h2></div>
				<hr class="colorgraph">
				<div class="form-group">
                   <p><a class="btn btn-primary btn-block" href="VisBygningUser.jsp">Bygninger og rapporter</a></p>
				</div>
			
				<span class="button-checkbox">
				
				</span>
			
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                      
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
