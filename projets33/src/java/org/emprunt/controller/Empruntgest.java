/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emprunt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.emprunt.dao.EmpruntDb;
import org.emprunt.entites.Emprunt;
import org.penalite.dao.PenaliteDb;
import org.penalite.entites.Penalite;
import org.reserv.dao.ReservDb;

/**
 *
 * @author yousra
 */
public class Empruntgest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        String operation = request.getParameter("operation");
          if(operation.equalsIgnoreCase("affichereservation")) {
          String cin = request.getParameter("cin");
          String emailhidd = request.getParameter("email");
          System.out.print(emailhidd);
          List list = EmpruntDb.getListRes(cin,emailhidd);
          request.setAttribute("list", list);
          request.getRequestDispatcher("profil2.jsp").forward(request, response);
           }
          else if(operation.equalsIgnoreCase("Ajouter")){
              
           String idreservhi = request.getParameter("idreservhi");
            String datedebut = request.getParameter("datedebut");
           String datefin = request.getParameter("datefin");
           System.out.println("success idreserv "  + idreservhi );
            System.out.println("success idreserv "  + datedebut );
           
          
          
        int status=1000;
  
          
                 try{
       
                        Emprunt emprunt = new Emprunt();
                       // adherent.setCin(cin);
                        
                        emprunt.setIdreserv(Integer.parseInt(idreservhi));
                       
                         java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datedebut);
                   
                         java.sql.Date date11 = new java.sql.Date(date1.getTime());
                         java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(datefin);
                   
                         java.sql.Date date22 = new java.sql.Date(date2.getTime());
                       
                
                        emprunt.setDatedebut(date11);
                        emprunt.setDatefin(date22);
                        emprunt.setRetour("0");
                        

                        
                       
                        //adherent.setMotdepasse(motdepasse);
           
          
          status=EmpruntDb.ajouter(emprunt);
            
                    request.getRequestDispatcher("profil2.jsp").forward(request, response);
    }
         catch (Exception ex ){
          System.out.println(ex);
       }
        }
            else if(operation.equalsIgnoreCase("afficheremprunt")){
                String cin = request.getParameter("cin");
                List list = EmpruntDb.getListEmp(cin);
          request.setAttribute("list", list);
          request.getRequestDispatcher("mosupemprunt.jsp").forward(request, response);
                
            }
          else if(operation.equalsIgnoreCase("supprimeremprunt")){
           String idemprunthi = request.getParameter("idemprunthi");
          System.out.println(idemprunthi);
          EmpruntDb.supprimeremprunt(idemprunthi);
             request.getRequestDispatcher("mosupemprunt.jsp").forward(request, response);
          }
          else if(operation.equalsIgnoreCase("modifieremprunt")){ 
               String idemprunthi = request.getParameter("idemprunthi");
              Emprunt emprunt = EmpruntDb.getEmprunt(idemprunthi);
              request.setAttribute("emprunt", emprunt);
             request.getRequestDispatcher("modifieremprunt.jsp").forward(request, response);
          }
          
          else if(operation.equalsIgnoreCase("modifieremprunt2")){ 
               String idemprunt = request.getParameter("idemprunt");
           
           String idreserv = request.getParameter("idreserv");
          
           String datedebut = request.getParameter("datedebut");
           
           String datefin = request.getParameter("datefin");
           String retour = request.getParameter("retour");
           
       
          
        int status=1000;
                     
   
  
          

                      try {
                        Emprunt emprunt = new Emprunt();
                       // adherent.setCin(cin);
                          emprunt.setIdemprunt(Integer.parseInt(idemprunt));
                        emprunt.setIdreserv(Integer.parseInt(idreserv));
                       
                         java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datedebut);
                   
                         java.sql.Date date11 = new java.sql.Date(date1.getTime());
                         java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(datefin);
                   
                         java.sql.Date date22 = new java.sql.Date(date2.getTime());
                       
                
                        emprunt.setDatedebut(date11);
                        emprunt.setDatefin(date22);
                          emprunt.setRetour(retour);
                        

                        System.out.println(idemprunt);
                        System.out.println(idreserv);
                        System.out.println(date11);
                        System.out.println(date22);
                          System.out.println(retour);
                       
                        //adherent.setMotdepasse(motdepasse);
           
          
           
          
          status=EmpruntDb.editeremprunt(emprunt);
            
                  
                           request.getRequestDispatcher("mosupemprunt.jsp").forward(request, response);
                      }
        catch (Exception ex ){
          System.out.println(ex);
       }
          }
            else if(operation.equalsIgnoreCase("ajouterpenalite")){ 
                
           String idemprunthi = request.getParameter("idemprunthi");
           String description = request.getParameter("desc");
          
                       Penalite penalite = new Penalite();
                        
                        penalite.setIdemprunt(Integer.parseInt(idemprunthi));
                        penalite.setDescription(description);
                      
                        PenaliteDb.ajouter(penalite);
                        request.getRequestDispatcher("mosupemprunt.jsp").forward(request, response);
                      
            }
          
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
