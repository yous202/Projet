<%-- 
    Document   : inscription
    Created on : 17 déc. 2017, 16:45:05
    Author     : yousra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
<title>Modifier Compte</title>
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
        <p>Si vous avez déjà un compte, veuillez vous connecter ! Sinon, Inscrivez-vous.</p>
        
      </div>
      
      <div class="topbox last">
        <h2>Connexion</h2>
        <form action="login.jsp" method="post">
          <fieldset>
            <legend>Se connecter</legend>
            <label for="email">Adresse email <span class="requis">*</span></label>
            <input type="email" id="email" name="email"/>
               
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" />
               
                <br />
          
            <p>
              <input type="submit" name="seconnecter"  value="Se connecter" />
              
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
      <li ><a href="profil2.jsp">R2servation et Ajout emprunt</a>
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
         <li><a href="supprimerpenalite.jsp">Supprimer pénalite</a></li>
     
       <li class="active"><a href="modifiercompte2.jsp">Modifier compte</a>
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
<div class="wrapper col3">
   
      </div>
<!-- ####################################################################################################### -->
<div class="wrapper col4">
  <div id="container">
       <% try{
       Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Statement st = con.createStatement();
    ResultSet rs;
    String nom="" ;
    String prenom="" ;
    String addresse="" ;
    String telephone="" ;
    String email = session.getAttribute("email").toString() ;
    
    rs = st.executeQuery("select * from assisstant where email='" + email + "'");
    if (rs.next()) 
    {
                 nom = rs.getString("nom");
                 prenom = rs.getString("prenom");
                 addresse = rs.getString("addresse");
                 telephone = rs.getString("telephone");
    }
                %>
   
        <br></br>
    <h2>Editer mon compte</h2>
    <br></br>
        <form  action="Modifierassiss" method="post">
          <fieldset>
            <legend>Veuillez insérer vos données ici : </legend>
             <legend><span class="number">1</span></legend>
            <label for="email">Email: </label>
                <input type="text" name="email" id="email" value="<%=email%>" />
           
             <br></br>
            <label for="nom">Nom: </label>
                <input type="text" name="nom" id="nom" value="<%=nom%>" />
           
             <br></br>
            <label for="prenom">Prénom:</label>
              <input type="text" name="prenom" id="prenom" value="<%=prenom%>" />
         
              <br></br>
            <label for="addresse">Addresse:</label>
              <input type="text" name="addresse" id="addresse" value="<%=addresse%>" />
            
               <br></br>
            <label for="telephone">telephone:  </label>
              <input type="text" name="telephone" id="telephone" value="<%=telephone%>" />
          
            
                <br></br>
              
            <%}catch(Exception e){out.print(e);}%>
          
              
              <button type="submit">Modifier compte</button>
              
           
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