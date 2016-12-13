<%-- 
    Document   : EditUser
    Created on : 27-11-2016, 01:19:45
    Author     : Runej
--%>

<%@page import="LogikLag.Entities.User"%>
<%@page import="LogikLag.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="LogikLag.Entities.Rapport"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%
String LoginType = (String) request.getSession().getAttribute("user_type");
String UserID = (String) request.getSession().getAttribute("UserId");
if (LoginType=="2" || LoginType=="3" || LoginType==null){
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
        <title>Rediger bruger</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="Css/colorgraph.css">
    </head>
    <body>
        <div class="container">
            <div class="col-md-11"><a href="PolyPage.jsp">Tilbage til menu</a></div><div class="col-md-1"><a href="index.html">logout</a></div>
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
             <h1>Rediger bruger</h1>
             <hr class="colorgraph"/>
            
               
        
        <% 
            
            List<User> users = ((ArrayList<User>)DomainFacade.getUsers());
            for( int i =0; i<users.size(); i++){
            int uID = Integer.parseInt(UserID);
            if(uID == users.get(i).getUserID()){
                         
            %>
            
                 <form method = "post" action="CreateUser">
                     
                     <table cellspacing="10" cellpadding="10" style="border-collapse: collapse;">

                         <tr>
                             <td>Postnummer</td>
                             <td><input class="form-control" type="text" name ="zipID" value = "<% out.print(users.get(i).getZipID());%>"/></td>
                         </tr>
                         <tr>
                             <td>BrugerType</td>
                             <td><input class="form-control" type="text" name ="usertype"             value = "<% out.print(users.get(i).getUsertype());%>"/></td>
                                   
            <select class="form-control" name="usertype">
            <option value="1">Polygon</option>
            <option value="2">Bruger</option>
            <option value="3">3.Part</option>
                             
                             
                             
                         </tr>
                          <tr>
                             <td>Firmanavn</td>
                             <td><input class="form-control" type="text" name ="firmName"             value = "<% out.print(users.get(i).getFirmName());%>"/></td>
                         </tr>
                         <tr>
                             <td>Fornavn</td>
                             <td><input class="form-control" type="text" name ="Fornavn"        value = "<% out.print(users.get(i).getContactFirstName());%>"/></td>
                         </tr>
                         <tr>
                             <td>Efternavn</td>
                             <td><input class="form-control" type="text" name ="Efternavn"       value = "<% out.print(users.get(i).getContactLastName());%>"/></td>
                         </tr>
                         <tr>
                             <td>Telefon</td>
                             <td> <input class="form-control" type="text" name ="Telefon"   value = "<% out.print(users.get(i).getTelefon());%>"/></td>
                         </tr>
                         <tr>
                             <td>Mail</td>
                             <td> <input class="form-control" type="text" name ="Mail"            value = "<% out.print(users.get(i).getMail());%>"/></td>
                         </tr>
                         <tr>
                             <td>CVR</td>
                             <td> <input class="form-control" type="text" name ="cvr"   value = "<% out.print(users.get(i).getCvr());%>"/></td>
                         </tr>
                         <tr>
                             <td>Gade</td>
                             <td><input class="form-control" type="text" name  ="Gade"            value = "<% out.print(users.get(i).getGade());%>"/></td>
                         </tr>
                         <tr>
                             <td>Password</td>
                             <td> <input class="form-control" type="text" name  ="Password"            value = "<% out.print(users.get(i).getPassword());%>"/></td>
                         </tr>
                     </table>
        
             
              <select class="form-control" name="ret">
              <option value="redigeret">Ret user</option>
              <option value="Slettet">Slet User</option>
              </select>
                         <br>
              <input  class="btn btn-primary btn-block" type ="Submit" name ="Opret" value = "Udfør"/>     
              <input type="hidden" name="uID" value="<%out.print(users.get(i).getUserID());%>"/>
                <form/>
                
              
              
              <%}}%>   
            </div>
            </div>
        </div>    
              
               <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
    </body>
</html>