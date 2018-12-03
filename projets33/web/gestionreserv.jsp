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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <center>
        <br></br>
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
    
        <form action="reserserv" method="post">
          <fieldset>
              <label for="cin">Cin </label>
                <input type="text" name="cin" id="cin" value="<%=cin%>" />
           
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
            <th width="25%">idlivre</th>
            <th width="25%">titre</th>
            <th width="25%">auteur</th>
            <th width="25%">idbib</th>
            <th width="25%">edition</th>
            <th width="25%">Reserver</th>
        
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
                            <button type="submit" name="operation" value="Reserver">Reserver</button>
                        </form>
                    </td>


                     
                </tr>
            </c:forEach>
                      </table>
                 <br></br>
                 <td><button type="submit" name="operation" value="Annuler">Afficher liste reservation</button></td>
            <%}catch(Exception e){out.print(e);}%>
          </fieldset>
        </form>
    </center>
    </body>
</html>
         
  