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
      <li><a href="profil1.jsp">Ajout Livre</a>
        <ul>
          <li class="active"><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li><a href="recherchelivre.jsp">Rechercher livre et editer</a>
        <ul>
          <li><a href="recherchelivre.jsp">par id </a></li>
          <li><a href="recherche2.jsp">par titre et auteur</a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
      <li class="active"><a href="rechercheadh.jsp">Gestion adherent</a>
       <ul>
          <li><a href="rechercheadh.jsp">Par nom</a></li>
          <li><a href="tous.jsp">Tous les adherents</a></li>
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
        <form action="rechercheadh" method="post">
          <fieldset>
         <label for="nom">nom </label>
                <input type="text" name="nom" value="${adherent.nom}" />
           
             <br></br>
            <label for="prenom">prenom</label>
              <input type="text" name="prenom"  value="${adherent.prenom}" />
               <button type="submit" name="operation" value="adh">chercher</button>
               </form>
                 <br></br>
                 
               <table border="5" width="70%" align="center">
            <tr>
            <th width="20%">Cin</th>
            <th width="25%">Nom</th>
            <th width="25%">Prenom</th>
            <th width="25%">Addresse</th>
             <th width="25%">Telephone</th>
              <th width="25%">Supprimer</th>
            </tr>
            <c:forEach  items="${requestScope.list}" var="adherent">
                <tr></td>
                    <td><input type="text" name="cin" value="<c:out value="${adherent.cin}"/>" ></td>
                    <td><c:out value="${adherent.nom}"/>
                     <td><c:out value="${adherent.prenom}"/></td>
                      <td><c:out value="${adherent.addresse}"/></td>
                       <td><c:out value="${adherent.telephone}"/></td>
                       <td><form action="rechercheadh" method="post">
                          <input type="hidden" name="cinhi" value="<c:out value="${adherent.cin}"/>">
                       
                         <button type="submit" name="operation" value="supprimer">Supprimer</button></td>
                     </form>
                </tr>
            </c:forEach>
                      </table>
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
