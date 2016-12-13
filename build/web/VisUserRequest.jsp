<%-- 
    Document   : VisUserRequest
    Created on : 04-12-2016, 16:58:46
    Author     : JonasSchack
--%>
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
            <div class="col-md-4"><h2>Bruger forespørgelser</h2></div>
            <div class="col-md-5"><img src="http://www.polygongroup.com/UI/build/svg/polygon-logo.svg" style="width:304px;height:75px;"></div>
        </div>
        <hr class="colorgraph"/>
    <div class="row" align="center">
        
         
        <div class="col-md-12">
            <table class ="table table-bordered " border="1" cellpadding="5">
            <tr>
                <th>Firmanavn</th>
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
List<User> userrequest = ((ArrayList<User>)DomainFacade.getUserRequest()); 
for (int i = 0; i < userrequest.size(); i++) {
    

%>
                <tr>
        <form method = "post" action="CreateUser">
                    <td><%out.print(userrequest.get(i).getFirmName());%></td>
                    <td><%out.print(userrequest.get(i).getZipID());%></td>
                    <%if("2".equals(userrequest.get(i).getUsertype())){%>
                    <td>Bruger</td><%}else{%>
                    <td>3. Part</td><%}%>
                    <td><%out.print(userrequest.get(i).getContactFirstName());%></td>
                    <td><%out.print(userrequest.get(i).getContactLastName());%></td>
                    <td><%out.print(userrequest.get(i).getTelefon());%></td>
                    <td><%out.print(userrequest.get(i).getMail());%></td>
                    <td><%out.print(userrequest.get(i).getCvr());%></td>
                    <td><%out.print(userrequest.get(i).getGade());%></td>
                    
                    <input type="hidden" name="firmname" value="<%out.print(userrequest.get(i).getFirmName());%>">
                    <input type="hidden" name="zipID" value="<%out.print(userrequest.get(i).getZipID());%>">
                    <input type="hidden" name="usertype" value="<%out.print(userrequest.get(i).getUsertype());%>">
                    <input type="hidden" name="ContactFirstName" value="<%out.print(userrequest.get(i).getContactFirstName());%>">
                    <input type="hidden" name="ContactLastName" value="<%out.print(userrequest.get(i).getContactLastName());%>">
                    <input type="hidden" name="telefon" value="<%out.print(userrequest.get(i).getTelefon());%>">
                    <input type="hidden" name="mail" value="<%out.print(userrequest.get(i).getMail());%>">
                    <input type="hidden" name="cvr" value="<%out.print(userrequest.get(i).getCvr());%>">
                    <input type="hidden" name="gade" value="<%out.print(userrequest.get(i).getGade());%>">
                    <input type="hidden" name="password" value="<%out.print(userrequest.get(i).getPassword());%>">
                    <input type="hidden" name="userid" value="<%out.print(userrequest.get(i).getUserID());%>">
          
                    </select></td>
                    <td><input class="btn btn-primary btn-block" type="Submit" name ="ret" value ="Opret"></td>
                    <td><input class="btn btn-danger btn-block" type="Submit" name ="ret" value ="Slet"></td>
                    
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