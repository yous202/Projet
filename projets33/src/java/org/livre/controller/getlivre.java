/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.livre.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class getlivre extends HttpServlet {

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
      
      
      
      if(operation.equalsIgnoreCase("Rechercher")) {
      Livre livre = LivreDb.getLivre(numlivre);
      request.setAttribute("livre", livre);
      request.getRequestDispatcher("recherchelivre.jsp").forward(request, response);
      }
      else if(operation.equalsIgnoreCase("Editer")){
           String titre = request.getParameter("titre");
           
           String auteur = request.getParameter("auteur");
          
           String genre = request.getParameter("genre");
           
           String edition = request.getParameter("edition");
           
           String idbib = request.getParameter("idbib");
            String nbrexemplaire = request.getParameter("nbrexemplaire");
          
        int status=1000;
  
          

                        Livre livre = new Livre();
                       // adherent.setCin(cin);
                        livre.setTitre(titre);
                        livre.setAuteur(auteur);
                        livre.setGenre(genre);
                        livre.setEdition(Integer.parseInt(edition));
                        livre.setIdbib(Integer.parseInt(idbib));
                        livre.setNbrexemplaire(Integer.parseInt(nbrexemplaire));
                        livre.setNumlivre(Integer.parseInt(numlivre));
                        
                       
                        //adherent.setMotdepasse(motdepasse);
           
          
          status=LivreDb.editerlivre(livre);
            
                        System.out.println("Adherent ajouté avec succés" );
                         request.getRequestDispatcher("touslivres.jsp").forward(request, response);
        }
      else if(operation.equalsIgnoreCase("Rechercher2")){
           String emailhidd = request.getParameter("email");
          String titre = request.getParameter("titre");
          String auteur = request.getParameter("auteur");
          List list = LivreDb.getListlivre(titre,auteur,emailhidd);
          request.setAttribute("list", list);
          request.getRequestDispatcher("recherche2.jsp").forward(request, response);
      }
        else if(operation.equalsIgnoreCase("Recherchertous")){
           String emailhidd = request.getParameter("email");
        
          List list = LivreDb.getListlivres(emailhidd);
          request.setAttribute("list", list);
          request.getRequestDispatcher("touslivres.jsp").forward(request, response);
      }
      else if(operation.equalsIgnoreCase("supprimerlivre")){
           String numlivrehi = request.getParameter("numlivrehi");
        
          LivreDb.supprimer(numlivrehi);
         
          request.getRequestDispatcher("touslivres.jsp").forward(request, response);
      }
     else if(operation.equalsIgnoreCase("modifier1")){
          String numlivrehi = request.getParameter("numlivrehi");

           System.out.println(numlivrehi);
           Livre livre = LivreDb.getLivre(numlivrehi);
      request.setAttribute("livre", livre);
      request.getRequestDispatcher("recherchelivre.jsp").forward(request, response);
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
