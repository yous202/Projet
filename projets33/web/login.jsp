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
        <h2>Avant de commencer</h2>
        <p>Si vous avez déjà un compte, veuillez vous connecter ! Sinon, Inscrivez-vous.</p>
        
      </div>
      <div class="topbox">
        <h2>Inscription</h2>
        <form action="AjouterAdherent" method="post">
          <fieldset>
            <legend>Veuillez insérer vos données ici : </legend>
            <label for="nom">Nom:
              <input type="text" name="nom" id="nom" value="" />
            </label>
            <label for="prenom">Prénom:
              <input type="text" name="prenom" id="prenom" value="" />
            </label>
             <label for="addresse">Addresse:
              <input type="text" name="addresse" id="addresse" value="" />
            </label>
             <label for="telephone">Télephone:
              <input type="text" name="telephone" id="telephone" value="" />
            </label>
            <label for="cin">CIN:
              <input type="text" name="cin" id="cin" value="" />
            </label>
            <label for="email">Email:
              <input type="email" name="email" id="email" value="" />
            </label>
            <label for="motdepasse">Mot-de-passe :
              <input type="password" name="motdepasse" id="motdepasse" value="" />
            </label>
            
            <p>
              <input type="submit" name="operation"  value="Envoyer"/>
             
            </p>
          </fieldset>
        </form>
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
               
                <br><br />
          
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
        <li class="right" id="toggle"><a id="slideit" href="#slidepanel">Connexion</a><a id="closeit" style="display: none;" href="#slidepanel">Fermer</a></li>
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
      <li class="active"><a href="inscription.jsp">Accueil</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="information.jsp">Information d'inscription</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
    
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
    
      <li class="last"><a href="#"></a></li>
    </ul>
  </div>
</div>
        <%@ page import ="java.sql.*" %>
<%
    String email = request.getParameter("email");    
    String motdepasse = request.getParameter("motdepasse");
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Connection con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/projet",
            "yousra", "1234");
    Statement st = con.createStatement();
    Statement st1 = con1.createStatement();
    Statement st2 = con2.createStatement();
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    rs = st.executeQuery("select * from adherent where email='" + email + "' and motdepasse='" + motdepasse + "'");
    rs2 = st1.executeQuery("select * from bibliothecaire where email='" + email + "' and motdepasse='" + motdepasse + "'");
    rs3 = st2.executeQuery("select * from assisstant where email='" + email + "' and motdepasse='" + motdepasse + "'");
    
     if (rs2.next()) 
    {
        session.setAttribute("email", email);
        response.sendRedirect("profil1.jsp?email="+email); 
        
    }
    else 
     {
         if (rs3.next()) 
        {
            session.setAttribute("email",email);
            response.sendRedirect("profil2.jsp?email="+email); 
            
        }
         else 
        {
            if (rs.next()) 
            {
               session.setAttribute("email", email);
               response.sendRedirect("profil.jsp?email="+email);  
               
            }
            else 
            {
                out.println(" <center><h2><a href='inscription.jsp'>Invalid email or password Try Again</a></h2></center>");
            }
        }
     }
 
%>
   <!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->

</body>
</html>
