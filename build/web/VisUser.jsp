<%
String LoginType = (String) request.getSession().getAttribute("user_type");

if (LoginType=="2" || LoginType=="3" || LoginType==null) {
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
<%@page import="LogikLag.Entities.Building"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="LogikLag.Entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLag.BuildingMapper"%>
<%@page import="DataLag.UserMapper"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title></title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body><div class="container">
            
        
        <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>

        
        <div class="row">
            <div class="col-md-4"><h2>Bruger oversigt</h2></div>
            <div class="col-md-5"><img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="width:304px;height:75px;"></div>
            <div class="col-md-3"><h3><a class="btn btn-success btn-block"href="OpretBruger.jsp">Opret Bruger</a></h3></div>
        </div>
        <hr class="colorgraph"/>
    <div class="row" align="center">
        
         
        <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
            <tr>
                <th>BrugerID</th>
                <th>Postnummer</th>
                <th>BrugerType</th>
                <th>Fornavn</th>
                <th>Efternavn</th>
                <th>Telefon</th>
                <th>Mail</th>
                <th>CVR</th>
                <th>Gade</th>
       
                
            </tr>
            
<% 
List<User> users = ((ArrayList<User>)DomainFacade.getUsers()); 
for (int i = 0; i < users.size(); i++) {
    

%>
                <tr>
        <form method = "post" action="CreateUser">
                    <td><%out.print(users.get(i).getUserID());%></td>
                    <td><%out.print(users.get(i).getZipID());%></td>
                    <%if("1".equals(users.get(i).getUsertype())){%>
                    <td>Polygon</td><%}else{%>
                    <td>Bruger</td><%}%>
                    <td><%out.print(users.get(i).getContactFirstName());%></td>
                    <td><%out.print(users.get(i).getContactLastName());%></td>
                    <td><%out.print(users.get(i).getTelefon());%></td>
                    <td><%out.print(users.get(i).getMail());%></td>
                    <td><%out.print(users.get(i).getCvr());%></td>
                    <td><%out.print(users.get(i).getGade());%></td>
                  
                    </select></td>
                    <td><input class="btn btn-primary btn-block" type="Submit" name ="" value ="Rediger"></td>
                    <input type="hidden" name ="UserId" value ="<%out.print(users.get(i).getUserID());%>">
                    <input type="hidden" name="ret" value="rediger"/>
                    
        </form>
                </tr>
            <%}%>
                <caption></caption>
        </table>
               
        </div>
    </div>
                <div/>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>