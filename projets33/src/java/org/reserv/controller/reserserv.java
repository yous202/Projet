/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reserv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.livre.dao.LivreDb;
import org.livre.entites.Livre;
import org.reserv.dao.ReservDb;
import org.reserv.entities.Reservation;

/**
 *
 * @author yousra
 */
public class reserserv extends HttpServlet {

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
      String numlivre = request.getParameter("numlivre");
      

      if(operation.equalsIgnoreCase("Rechercher3")) {
           String titre = request.getParameter("titre");
          String auteur = request.getParameter("auteur");
          List list = ReservDb.getListlivre(titre,auteur);
          request.setAttribute("list", list);
          request.getRequestDispatcher("profil.jsp").forward(request, response);
           }
      else if(operation.equalsIgnoreCase("Reserver")){
            String numlivrehidd = request.getParameter("numlivrehidd");
            String cinhidd = request.getParameter("cinhidd");
            System.out.println("success numlivre "  + numlivrehidd );
            System.out.println("success cin "  + cinhidd );
            int status=1000;
            System.out.println( ReservDb.cherchnbrexemp(numlivrehidd) +" blqfh "+ ReservDb.checknbrexemp(numlivrehidd));
            if( ReservDb.checknbrexemp(numlivrehidd) < ReservDb.cherchnbrexemp(numlivrehidd) )
            {
                if (ReservDb.checkpenal(cinhidd)==0)    
                {    
                    if ( ReservDb.checkclient(cinhidd) <= 4 )
                    {
                        Reservation reservation = new Reservation();
                        // adherent.setCin(cin); 
                        reservation.setNumlivre(Integer.parseInt(numlivrehidd));
                        reservation.setCin(cinhidd);
                        status=ReservDb.ajouter(reservation);
                        request.getRequestDispatcher("profil.jsp").forward(request, response);
                    }
                    else {  request.getRequestDispatcher("nbredepasse.jsp").forward(request, response);
                        System.out.println("Vous avez dépassé le nombre permis de livre à emprunter ." ); }
                }else {  request.getRequestDispatcher("tempsemprunt.jsp").forward(request, response);
                    System.out.println("Vous etes penalisé au revoir :D ." );}
                    
            }
            else {  request.getRequestDispatcher("plusdelivre.jsp").forward(request, response);
                System.out.println("Plus de livres " );}
        }
      else if(operation.equalsIgnoreCase("Annuler")){
          String idreserv = request.getParameter("idreserv");
          String cin = request.getParameter("cin");
          List list = ReservDb.getListRes(cin );
          request.setAttribute("list", list);
          request.getRequestDispatcher("supprimerreserv.jsp").forward(request, response);
       
      }
       else if(operation.equalsIgnoreCase("Annuler2")){
          String idreservhi = request.getParameter("idreservhi");
          System.out.println(idreservhi);
          ReservDb.supprimerreserv(idreservhi);
           request.getRequestDispatcher("profil.jsp").forward(request, response);
       
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
