/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.livre.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.livre.dao.LivreDb;
import org.livre.entites.Livre;

/**
 *
 * @author yousra
 */
public class AjouterLivre extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           String numlivre = request.getParameter("numlivre");
           String titre = request.getParameter("titre");
           String auteur = request.getParameter("auteur");
           String genre = request.getParameter("genre");
           String edition = request.getParameter("edition");
           String idbib = request.getParameter("idbib");
           String nbrexemplaire = request.getParameter("nbrexemplaire");
                        Livre livre = new Livre();
                        
                        livre.setTitre(titre);
                        livre.setAuteur(auteur);
                        livre.setGenre(genre);
                        livre.setEdition(Integer.parseInt(edition));
                        livre.setIdbib(Integer.parseInt(idbib));
                        livre.setNbrexemplaire(Integer.parseInt(nbrexemplaire));
                        LivreDb.ajouterlivre(livre);
                        out.println("livre ajouté avec succés");
                         request.getRequestDispatcher("profil1.jsp").forward(request, response);
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
