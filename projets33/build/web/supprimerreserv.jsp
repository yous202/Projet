<%-- 
    Document   : recherche2
    Created on : 21 janv. 2018, 10:53:10
    Author     : yousra
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
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
      
      <li><a href="profil.jsp">Rechercher livre</a>
        <ul>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="last"><a href="#"></a></li>
        </ul>
      </li>
         <li class="active"><a href="supprimerreserv.jsp">Liste des reservations</a>
      <li ><a href="Modifiercompte.jsp">Modifier compte</a>
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
     <center>
    <h2>Vos réservations</h2>
        <form action="reserserv" method="post">
          <fieldset>
              
                <input type="hidden" name="cin" id="cin" value="<%=cin%>" />
           
             <br></br>
            
                
         
               <table border="5" width="70%" align="center">
            <tr>
            <th width="15%">numlivre</th>
            <th width="15%">titre livre</th>
            <th width="15%">auteur livre</th>
            <th width="15%">idreserv</th>
            <th width="15%">Annuler</th>
            </tr>
            <c:forEach  items="${requestScope.list}" var="reservation">
                <tr>
                    
                    <td><input type="text" name="numlivre" value="<c:out value="${reservation[2]}"/>"></td>
                    <td><input type="text" name="titre" value="<c:out value="${reservation[3]}"/>"></td>
                    <td><input type="text" name="auteur" value="<c:out value="${reservation[4]}"/>"></td>
                    <td><input type="text" name="idreserv" value="<c:out value="${reservation[1]}"/>"></td>
                  
                    
                     <td> 
                             <form action="reserserv" method="post">
                          <input type="hidden" name="numlivrehi" value="<c:out value="${reservation[2]}"/>">
                          <input type="hidden" name="idreservhi" value="<c:out value="${reservation[1]}"/>">
                          <center><button type="submit" name="operation" value="Annuler2">Annuler</button></td></center>
                     </form>
                </tr>
            </c:forEach>
                      </table>
            <%}catch(Exception e){out.print(e);}%>
          </fieldset>
        </form>
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
   
   
         
  