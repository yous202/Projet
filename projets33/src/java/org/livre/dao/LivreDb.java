/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.livre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.livre.entites.Livre;

/**
 *
 * @author yousra
 */
public class LivreDb {
     public static Connection getConnection(){
        Connection conn= null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projet","yousra","1234");
            
            
        }
        catch(Exception e){ System.out.print(e);
    }
        return conn;
    }
      public static int ajouterlivre(Livre livre){
       int status=0;
       try{
           Connection conn = LivreDb.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into livre (titre, auteur, genre, edition, idbib, nbrexemplaire) values (?,?,?,?,?,?)");
         ps.setString(1,livre.getTitre());
         ps.setString(2,livre.getAuteur());
         ps.setString(3,livre.getGenre());
         ps.setInt(4,livre.getEdition());
         ps.setInt(5,livre.getIdbib());
         ps.setInt(6,livre.getNbrexemplaire());
     
           status = ps.executeUpdate();
           conn.close();
       }
      catch(Exception e){System.out.println(e);}
       return status;
          
       }
       public static Livre getLivre(String numlivre){
           Livre livre = new Livre();
           try {
           Connection con1 = LivreDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
          
           rs = ps.executeQuery("select * from livre where numlivre =" + Integer.parseInt(numlivre) + "");
            System.out.println(numlivre);
            if(rs.next()){
                livre.setNumlivre(Integer.parseInt(numlivre));
                System.out.println(numlivre);
                livre.setTitre(rs.getString("titre"));
                System.out.println(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setGenre(rs.getString("genre"));
                livre.setEdition(Integer.parseInt(rs.getString("edition")));
                livre.setIdbib(Integer.parseInt(rs.getString("idbib")));
                livre.setNbrexemplaire(Integer.parseInt(rs.getString("nbrexemplaire")));
                        
            }
           }
           catch (Exception ex){
       System.err.println("hjfdsqz" + ex.getMessage());
    }
    return livre;  
           
       }
       public static int editerlivre(Livre livre){
       int status=0;
       try{
          
           Connection conn = LivreDb.getConnection();
          
         PreparedStatement ps = conn.prepareStatement("UPDATE  livre SET titre= ? , auteur= ? , genre= ? , edition= ?, idbib= ?, nbrexemplaire=? where numlivre= ? ");
         
         ps.setString(1,livre.getTitre());
         ps.setString(2,livre.getAuteur());
         ps.setString(3,livre.getGenre());
         ps.setInt(4,livre.getEdition());
         ps.setInt(5,livre.getIdbib());
         ps.setInt(6,livre.getNbrexemplaire());
          ps.setInt(7,livre.getNumlivre());
         status = ps.executeUpdate();
         
           //status = statement.executeUpdate("UPDATE  adherent SET NOM='"+adherent.getNom()+"', PRENOM='"+adherent.getPrenom()+"', ADDRESSE='"+adherent.getAddresse()+"', TELEPHONE='"+adherent.getTelephone()+"' where EMAIL='"+adherent.getEmail()+"';");
           conn.close();
       }
      catch(Exception e){System.out.println(e);
     
       }
       return status;
          
       }
   
       
       
       
       public static ArrayList<Livre> getListlivre(String titre, String auteur, String email){
        ArrayList<Livre> list = new ArrayList<Livre>();
        
        
        
         try{
             Connection con1 = LivreDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           rs = ps.executeQuery("SELECT livre.numlivre, livre.edition, livre.idbib from livre , bibliothecaire where  livre.IDBIB=bibliothecaire.IDBIB and bibliothecaire.EMAIL='"+ email +"' and livre.titre='"+ titre +"' and livre.auteur='"+ auteur +"'");
          // rs = ps.executeQuery("select numlivre, edition, idbib from livre where titre='"+ titre +"' and auteur='"+auteur+"'");
           System.out.println(titre);
           System.out.println(auteur);
            while(rs.next()){
                 Livre livre = new Livre();
   
                livre.setAuteur(auteur);
                livre.setTitre(titre);
               
                livre.setNumlivre(Integer.parseInt(rs.getString("numlivre")));
                livre.setEdition(Integer.parseInt(rs.getString("edition")));
                livre.setIdbib(Integer.parseInt(rs.getString("idbib")));
                
                
                list.add(livre);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;
    }   
             
       public static ArrayList<Livre> getListlivres(String email){
        ArrayList<Livre> list = new ArrayList<Livre>();
        
        
        
         try{
             Connection con1 = LivreDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           rs = ps.executeQuery("SELECT livre.auteur, livre.titre, livre.numlivre, livre.edition, livre.idbib from livre , bibliothecaire where  livre.IDBIB=bibliothecaire.IDBIB and bibliothecaire.EMAIL='"+ email +"'");
          // rs = ps.executeQuery("select numlivre, edition, idbib from livre where titre='"+ titre +"' and auteur='"+auteur+"'");
         
            while(rs.next()){
                 Livre livre = new Livre();
   
                livre.setAuteur(rs.getString("auteur"));
                livre.setTitre(rs.getString("titre"));
               
                livre.setNumlivre(Integer.parseInt(rs.getString("numlivre")));
                livre.setEdition(Integer.parseInt(rs.getString("edition")));
                livre.setIdbib(Integer.parseInt(rs.getString("idbib")));
                
                
                list.add(livre);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;
    }   
        public static void supprimer(String numlivre){
            try{
           
          
             Connection con1 = LivreDb.getConnection();
             
             Statement ps = con1.createStatement();
             ps.execute("delete from livre where numlivre="+ Integer.parseInt(numlivre) +"  ");}
            
        catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
    }
}
