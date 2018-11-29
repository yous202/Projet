<%-- 
    Document   : inscription
    Created on : 17 déc. 2017, 16:45:05
    Author     : yousra
--%>

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
        <li class="right" id="toggle"><a id="slideit" href="inscription.jsp">Deconnexion</a><a id="closeit" style="display: none;" href="#slidepanel">Fermer</a></li>
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
      <li class="active"><a href="profil2.jsp">Reservation et Ajout emprunt</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="mosupemprunt.jsp">Gestion emprunt</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
     
        <li><a href="adhpenal.jsp">Temps depassé</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="supprimerpenalite.jsp">Supprimer pénalité</a></li>
   
       <li><a href="modifiercompte2.jsp"> Modifier compte</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div class="wrapper col4">
  <div id="container">
      
     <form action="Empruntgest" method="post">
          <fieldset>
         <label for="cin">Cin </label>
                <input type="text" name="cin"  />
           
             <br></br>
             <input type="hidden" name="email" value="<%=session.getAttribute("email").toString()%>" />
               <button type="submit" name="operation" value="affichereservation" >chercher</button>
               </form>
                 <br></br>
              
               <table border="5" width="70%" align="center">
            <tr>
              <th width="15%">numlivre</th>
            <th width="15%">titre livre</th>
            <th width="15%">auteur livre</th>
            <th width="15%">idreserv</th>
            
             <th width="15%">Ajouter emprunt</th>
            </tr>
            <c:forEach  items="${requestScope.list}" var="reservation">
               <tr>
                    
                    <td><input type="text" name="numlivre" value="<c:out value="${reservation[2]}"/>"></td>
                    <td><input type="text" name="titre" value="<c:out value="${reservation[3]}"/>"></td>
                    <td><input type="text" name="auteur" value="<c:out value="${reservation[4]}"/>"></td>
                    <td><input type="text" name="idreserv" value="<c:out value="${reservation[1]}"/>"></td>
                     
                    
                     <td> 
                             <form action="Empruntgest" method="post">
                               
                          <input type="hidden" name="numlivrehi" value="<c:out value="${reservation[2]}"/>">
                          <input type="hidden" name="idreservhi" value="<c:out value="${reservation[1]}"/>">
                           <label for="datedebut">Date Début</label>
                          <input type="date" name="datedebut" >
                               <label for="datefin">Date fin </label>
                          <input type="date" name="datefin" >
                           
                      
                              <center><button type="submit" name="operation" value="Ajouter">Ajouteremprunt</button></center></td>
                     </form>
                </tr>
            </c:forEach>
                      </table>
                 </form>
           
          </fieldset>
        
   
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