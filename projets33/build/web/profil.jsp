<%-- 
    Document   : inscription
    Created on : 17 déc. 2017, 16:45:05
    Author     : yousra
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Educational
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Accueil</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<link rel="stylesheet" href="layout/css/style.css"/>
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.ui.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.tabs.setup.js"></script>
</head>
<body>
<div class="wrapper col0">
  <div id="topbar">
    <div id="slidepanel">
      <div class="topbox">
        <h2>Au revoir :) !</h2>
      
        
      </div>
      
      <div class="topbox last">
        <h2>Déconnexion</h2>
        <form action="inscription.jsp" method="post">
          <fieldset>
            <legend>Se déconnecter</legend>
           
          
            <p>
                <center><input type="submit" name="seconnecter"  value="Se deconnecter" /></center>
              
            </p>
               
          </fieldset>
        </form>
      </div>
      <br class="clear" />
    </div>
    <div id="loginpanel">
      <ul>
        <li class="left">par ici &raquo;</li>
        <li class="right" id="toggle"><a id="slideit" href="inscription.jsp">Déconnexion</a><a id="closeit" style="display: none;" href="#slidepanel">Fermer</a></li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col1">
  <div id="header">
    <div id="logo">
      <h1><a href="inscription.jsp"><img src="images/demo/l1.png" alt="" /></a></h1>
     
    </div>
    
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="topnav">
    <ul>
      
      <li class="active"><a href="profil.jsp">Rechercher livre</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
     
      <li><a href="Modifiercompte.jsp">Modifier compte</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="#"></a></li>
      <li class="last"><a href="#"></a></li>
    </ul>
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div class="wrapper col4">
  <div id="container">
     <% try{
       Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Statement st = con.createStatement();
    ResultSet rs;
    String cin="" ;
    String nom="" ;
    String prenom="" ;
    String addresse="" ;
    String telephone="" ;
    String email = session.getAttribute("email").toString() ;
    
    rs = st.executeQuery("select * from adherent where email='" + email + "'");
    if (rs.next()) 
    {
                 cin = rs.getString("cin");
                 nom = rs.getString("nom");
                 prenom = rs.getString("prenom");
                 addresse = rs.getString("addresse");
                 telephone = rs.getString("telephone");
                 
    }
                %>
    <h2></h2>
    <br></br>
    
        <h2>Chercher et réserver </h2>
        <form action="reserserv" method="post">
          <fieldset>
              
                <input type="hidden" name="cin" id="cin" value="<%=cin%>" />
           
             <br></br>
         <label for="titre">titre </label>
                <input type="text" name="titre" value="${livre.titre}" />
           
             <br></br>
            <label for="auteur">auteur</label>
              <input type="text" name="auteur"  value="${livre.auteur}" />
             <button type="submit" name="operation" value="Rechercher3" >chercher</button>
                 <br></br>
               <table border="5" width="70%" align="center">
            <tr>
            <th width="15%">idlivre</th>
            <th width="15%">titre</th>
            <th width="15%">auteur</th>
            <th width="15%">idbib</th>
            <th width="15%">edition</th>
            <th width="15%">Reserver</th>
        
            </tr>
            <c:forEach  items="${requestScope.list}" var="livre">
                <tr>
                    <td><input type="text" name="numlivre" value="<c:out value="${livre.numlivre}"/>"></td>
                    <td><c:out value="${livre.titre}"/></td>
                    <td><c:out value="${livre.auteur}"/></td>
                    <c:choose>
                      <c:when test="${livre.idbib == '2'}">
                         <td>Mediatheque</td>
                           
                      </c:when>   
                      <c:when test="${livre.idbib == '3'}">
                         <td>Nationale</td>
                           
                      </c:when>   
                      <c:otherwise>
                             <td>Uirbib</td>
                            
                       </c:otherwise>
                    </c:choose>
                    
                    
                    <td><c:out value="${livre.edition}"/></td>
                     <td>
                       <form action="reserserv" method="post">
                            <input type="hidden" name="cinhidd" id="cin" value="<%=cin%>" />
                            <input type="hidden" name="numlivrehidd" value="<c:out value="${livre.numlivre}"/>" >
                                <center><button type="submit" name="operation" value="Reserver">Reserver</button></center>
                        </form>
                    </td>


                     
                </tr>
            </c:forEach>
                      </table>
                 <br></br>
                  <button type="submit" name="operation" value="Annuler">Afficher liste reservation</button>
            <%}catch(Exception e){out.print(e);}%>
          </fieldset>
        </form>
   
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div class="wrapper col6">
  <div id="copyright">
      <center><p><a href="#">Copyright © UMI 2018 - Tous droits réservés.</a></p></center>
  
    <br class="clear" />
  </div>
</div>
</body>
</html>