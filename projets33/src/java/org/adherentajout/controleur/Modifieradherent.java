/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adherentajout.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.adherent.dao.AdherentDb;
import org.adherent.entites.Adherent;

/**
 *
 * @author yousra
 */
public class Modifieradherent extends HttpServlet {

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
        System.out.println("success post ");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             //String cin = request.getParameter("cin");
           String nom = request.getParameter("nom");
           System.out.println("success nom "  + nom );
           String prenom = request.getParameter("prenom");
           System.out.println("success prenom " + prenom );
           String addresse = request.getParameter("addresse");
           System.out.println("success adresse ");
           String telephone = request.getParameter("telephone");
           System.out.println("success telephone ");
           String email = request.getParameter("email");
           System.out.println("success email " + email );
           //String motdepasse = request.getParameter("motdepasse");
           //String operation = request.getParameter("operation");
           int status=10000 ;
          

                        Adherent adherent = new Adherent();
                       // adherent.setCin(cin);
                        adherent.setNom(nom);
                        adherent.setPrenom(prenom);
                        adherent.setEmail(email);
                        adherent.setAddresse(addresse);
                        adherent.setTelephone(telephone);
                        
                        System.out.println("success new nom " + adherent.getNom());
                        //adherent.setMotdepasse(motdepasse);
           
          
                status=AdherentDb.editer(adherent);
            
                        request.getRequestDispatcher("Modifiercompte.jsp").forward(request, response);
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
