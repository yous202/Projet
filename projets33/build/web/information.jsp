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
              <input type="text" name="nom" id="nom" value="" required/>
            </label>
            <label for="prenom">Prénom:
              <input type="text" name="prenom" id="prenom" value="" required />
            </label>
             <label for="addresse">Addresse:
              <input type="text" name="addresse" id="addresse" value="" required/>
            </label>
             <label for="telephone">Télephone:
              <input type="text" name="telephone" id="telephone" value="" required />
            </label>
            <label for="cin">CIN:
              <input type="text" name="cin" id="cin" value="" required />
            </label>
            <label for="email">Email:
              <input type="email" name="email" id="email" value="" placeholder="exemple@gmail.com" required />
            </label>
            <label for="motdepasse">Mot-de-passe :
              <input type="password" name="motdepasse"   min="8" id="motdepasse" value="" placeholder="plus de 8 caractère*" required  />
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
            <input type="email" id="email" name="email" required/>
               
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" required/>
               
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
      <li><a href="inscription.jsp">Accueil</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li class="active" ><a href="information.jsp">Informations générales </a>
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
<!-- ####################################################################################################### -->
<div class="wrapper col3">

<div id="container">
    <center>
<h3>Bienvenue !</h3></center>



  <h3>À propos de la BNRM</h3>
  <p>La Bibliothèque Nationale du Royaume du Maroc fête ses dix ans. Le bel édifice qui l’abrite traduit ses ambitions.</p>
  <p>A l’image de ses formes architecturales et de ses composantes, elle est une invitation à l’épanouissement culturel. Le grand dessein de la BNRM est de mettre le savoir à la disposition des lecteurs et particulièrement les jeunes.

    L’esplanade ouverte et accueillante, l’escalier public prolongé par un jardin historique, serein et raffiné et une vaste terrasse qui invite à l’admiration de cette belle ville de Rabat, sont de véritables symboles.</p>

  <h2>Addresse</h2>
  <p>Avenue Ibn Khaldoun, Rabat</p>

  <h3>À propos de la Médiathèque</h3>
  <p>La médiathèque s'ouvre sur le monde électronique
 Fidèle à sa politique de satisfaction des besoins de ses adhérents et dans la perspective de s’ouvrir sur le monde de l’information numérique, la Médiathèque de la Fondation Mohammed VI vous propose un nouveau service de qualité. </p>
  <p>
La Médiathèque offre à ses adhérents plusieurs services. Il s’agit principalement du:

prêt à domicile : Les abonnés peuvent emprunter des livres, des revues et des œuvres électroniques libres de droit. Les conditions d’emprunt sont précisées dans le règlement de la Médiathèque ;

la consultation in situ des collections de la médiathèque ;

 l’accès en ligne aux documents électroniques ;</p>
  <h2>Addresse</h2>
  <p>Avenue Allal Al Fassi, Rabat</p>



  <h3>À propos de la Bibliothèque universitaire</h3>
  <p>Une bibliothèque universitaire (BU) est une bibliothèque rattachée à une université. 
      Les documents et les services présents dans la bibliothèque universitaire peuvent ainsi servir à la double mission des universités, l'enseignement et la recherche.</p>
  <h2>Addresse</h2>
  <p>Présidence de l'Université Mohammed V de RABAT, Adresse</p>
  
</div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col4">
  
    
  
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