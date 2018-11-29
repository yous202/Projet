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
      <li><a href="profil1.jsp">Ajout Livre</a>
        <ul>
          <li class="active"><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li  class="active"><a href="recherchelivre.jsp">Rechercher livre et editer</a>
        <ul>
          <li><a href="recherchelivre.jsp">par id </a></li>
          <li><a href="recherche2.jsp">par titre et auteur</a></li>
          <li class="last"><a href="touslivres.jsp">Tous les livres</a></li>
        </ul>
      </li>
      <li><a href="rechercheadh.jsp">Gestion adherent</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="modifiiercompte1.jsp">Modifier compte</a></li>
      <li class="last"><a href="#"></a></li>
    </ul>
  </div>
</div>
</div>
<!-- ####################################################################################################### -->
<!-- ####################################################################################################### -->
<div class="wrapper col4">
  <div id="container">
      
        <form action="getlivre" method="post">
          <fieldset>
            <label for="numlivre">Num livre:  </label>
                <input type="text" name="numlivre" value="${livre.numlivre}" />
                 <button type="submit" name="operation" value="Rechercher" >chercher</button>
           
             <br></br>
            <label for="titre">titre </label>
                <input type="text" name="titre" value="${livre.titre}" />
           
             <br></br>
            <label for="auteur">auteur</label>
              <input type="text" name="auteur"  value="${livre.auteur}" />
         
              <br></br>
            <label for="genre">genre</label>
              <input type="text" name="genre" value="${livre.genre}" />
            
               <br></br>
            <label for="edition">edition</label>
              <input type="text" name="edition"  value="${livre.edition}" />
     
                <br></br>
                 <br></br>
            <label for="idbib">biblio</label>
              <input type="text" name="idbib"  value="${livre.idbib}" />
          
            
                <br></br>
                 <br></br>
            <label for="nbrexemplaire">nbre</label>
              <input type="text" name="nbrexemplaire"  value="${livre.nbrexemplaire}" />
               <button type="submit" name="operation" value="Editer">Editer</button>
          
            
                <br></br>
              
       
          
              
             
              
           
          </fieldset>
            </center>
        </form>
                </fieldset>
        
    </center>
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