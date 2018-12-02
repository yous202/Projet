<%-- 
    Document   : recherche2
    Created on : 21 janv. 2018, 10:53:10
    Author     : yousra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Emprunts</title>
    </head>
    <body>
     
         <center>
        <br></br>
    <h2></h2>
    <br></br>
       <form action="Empruntgest" method="post">
          <fieldset>
         <label for="cin">Cin </label>
                <input type="text" name="cin"  />
           
             <br></br>
             <input type="hidden" name="email" value="<%=session.getAttribute("email").toString()%>" />
               <button type="submit" name="operation" value="affichereservation" >Chercher</button>
               </form>
                 <br></br>
              
               <table border="5" width="70%" align="center">
            <tr>
            <th width="25%">Num du livre</th>
            <th width="25%">Num de la réservation</th>
            
             <th width="25%">Ajouter Emprunt</th>
            </tr>
            <c:forEach  items="${requestScope.list}" var="reservation">
               <tr>
                    
                    <td><input name="numlivre" value="<c:out value="${reservation.numlivre}"/>"></td>
                    <td><input name="idreserv" value="<c:out value="${reservation.idreserv}"/>"></td>
                     
                    
                     <td> 
                             <form action="Empruntgest" method="post">
                               
                          <input type="hidden" name="numlivrehi" value="<c:out value="${reservation.numlivre}"/>">
                          <input type="hidden" name="idreservhi" value="<c:out value="${reservation.idreserv}"/>">
                          <input type="date" name="datedebut" >
                          <input type="date" name="datefin" >
                           
                      
                        <button type="submit" name="operation" value="Ajouter">Ajouter emprunt</button></td>
                     </form>
                </tr>
            </c:forEach>
                      </table>
                 </form>
        </fieldset>
        
           
          </fieldset>
        
    </center>
    </body>
</html>
         
  