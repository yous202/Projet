/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.penalite.controller;

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
public class penalite extends HttpServlet {

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
          if(operation.equalsIgnoreCase("afficherpenalite")) {
          String cin = request.getParameter("cin");
          List list = PenaliteDb.getListPen(cin);
          request.setAttribute("list", list);
          request.getRequestDispatcher("supprimerpenalite.jsp").forward(request, response);
           }
          
          
          else if(operation.equalsIgnoreCase("supprimer")){
           String idpenalitehi = request.getParameter("idpenalitehi");
          
          PenaliteDb.supprimerpenalite(idpenalitehi);
             request.getRequestDispatcher("supprimerpenalite.jsp").forward(request, response);
          }
           else if(operation.equalsIgnoreCase("adhpenal")) {
          
          List list = PenaliteDb.getList();
          request.setAttribute("list", list);
          request.getRequestDispatcher("adhpenal.jsp").forward(request, response);
           }
           else if(operation.equalsIgnoreCase("Ajouterpenal")){ 
                String idemprunthi = request.getParameter("idemprunthi");
                
          
                       Penalite penalite = new Penalite();
                        
                        penalite.setIdemprunt(Integer.parseInt(idemprunthi));
                        penalite.setDescription("Le temps est dépassé");
                      
                        PenaliteDb.ajouter(penalite);
                         request.getRequestDispatcher("adhpenal.jsp").forward(request, response);
                      
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
