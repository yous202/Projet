/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adherent.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.adherent.entites.Adherent;
import org.adherent.entites.Assiss;
import org.adherent.entites.Biblio;

/**
 *
 * @author yousra
 */
public class AdherentDb {
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
   public static int ajouter(Adherent adherent){
       int status=0;
       try{
           Connection conn = AdherentDb.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into adherent (nom, prenom, addresse, telephone, cin, email, motdepasse) values (?,?,?,?,?,?,?)");
         ps.setString(1,adherent.getNom());
         ps.setString(2,adherent.getPrenom());
         ps.setString(3,adherent.getAddresse());
         ps.setString(4,adherent.getTelephone());
         ps.setString(5,adherent.getCin());
         ps.setString(6,adherent.getEmail());
         ps.setString(7,adherent.getMotdepasse());
           status = ps.executeUpdate();
           conn.close();
       }
      catch(Exception e){System.out.println(e);}
       return status;
          
       }
   public static int editer(Adherent adherent){
       int status=0;
       try{
          
           Connection conn = AdherentDb.getConnection();
          
         PreparedStatement ps = conn.prepareStatement("UPDATE  adherent SET NOM= ? , PRENOM= ? , ADDRESSE= ? , TELEPHONE= ? where EMAIL= ? ");
          // PreparedStatement ps = conn.prepareStatement("insert into adherent (nom, prenom, addresse, telephone,  email) values (?,?,?,?,?)");
         ps.setString(1,adherent.getNom());
         ps.setString(2,adherent.getPrenom());
         ps.setString(3,adherent.getAddresse());
         ps.setString(4,adherent.getTelephone());
         ps.setString(5,adherent.getEmail());
          status = ps.executeUpdate();
         
           //status = statement.executeUpdate("UPDATE  adherent SET NOM='"+adherent.getNom()+"', PRENOM='"+adherent.getPrenom()+"', ADDRESSE='"+adherent.getAddresse()+"', TELEPHONE='"+adherent.getTelephone()+"' where EMAIL='"+adherent.getEmail()+"';");
           conn.close();
       }
      catch(Exception e){System.out.println(e);
     
       }
       return status;
          
       }
   public static ArrayList<Adherent> getListAdh(String nom, String prenom){
        ArrayList<Adherent> list = new ArrayList<Adherent>();
        
        
        
         try{
             Connection con1 = AdherentDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select cin, nom, prenom, addresse,telephone from adherent where nom='"+ nom +"' and prenom='"+prenom+"'");
           System.out.println(nom);
           System.out.println(prenom);
            while(rs.next()){
                 Adherent adherent = new Adherent();
   
                adherent.setNom(nom);
                adherent.setPrenom(prenom);
               
                adherent.setCin(rs.getString("cin"));
                adherent.setAddresse(rs.getString("addresse"));
                
                adherent.setTelephone(rs.getString("telephone"));
                
                
                list.add(adherent);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;}
        public static void supprimer(String cin){
            try{
           
          
             Connection con1 = AdherentDb.getConnection();
             
             Statement ps = con1.createStatement();
             ps.execute("delete from adherent where cin='"+cin+"'");}
            
        catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
    }
          public static int editera(Assiss assiss){
       int status=0;
       try{
          
           Connection conn = AdherentDb.getConnection();
          
         PreparedStatement ps = conn.prepareStatement("UPDATE  assisstant SET NOM= ? , PRENOM= ? , ADDRESSE= ? , TELEPHONE= ? where EMAIL= ? ");
          // PreparedStatement ps = conn.prepareStatement("insert into adherent (nom, prenom, addresse, telephone,  email) values (?,?,?,?,?)");
         ps.setString(1,assiss.getNom());
         ps.setString(2,assiss.getPrenom());
         ps.setString(3,assiss.getAddresse());
         ps.setString(4,assiss.getTelephone());
         ps.setString(5,assiss.getEmail());
          status = ps.executeUpdate();
         
           //status = statement.executeUpdate("UPDATE  adherent SET NOM='"+adherent.getNom()+"', PRENOM='"+adherent.getPrenom()+"', ADDRESSE='"+adherent.getAddresse()+"', TELEPHONE='"+adherent.getTelephone()+"' where EMAIL='"+adherent.getEmail()+"';");
           conn.close();
       }
      catch(Exception e){System.out.println(e);
     
       }
       return status;
          
       }
            public static int editerb(Biblio biblio){
       int status=0;
       try{
          
           Connection conn = AdherentDb.getConnection();
          
         PreparedStatement ps = conn.prepareStatement("UPDATE bibliothecaire SET NOM= ? , PRENOM= ? , ADDRESSE= ? , TELEPHONE= ? where EMAIL= ? ");
          // PreparedStatement ps = conn.prepareStatement("insert into adherent (nom, prenom, addresse, telephone,  email) values (?,?,?,?,?)");
         ps.setString(1,biblio.getNom());
         ps.setString(2,biblio.getPrenom());
         ps.setString(3,biblio.getAddresse());
         ps.setString(4,biblio.getTelephone());
         ps.setString(5,biblio.getEmail());
          status = ps.executeUpdate();
         
           //status = statement.executeUpdate("UPDATE  adherent SET NOM='"+adherent.getNom()+"', PRENOM='"+adherent.getPrenom()+"', ADDRESSE='"+adherent.getAddresse()+"', TELEPHONE='"+adherent.getTelephone()+"' where EMAIL='"+adherent.getEmail()+"';");
           conn.close();
       }
      catch(Exception e){System.out.println(e);
     
       }
       return status;
          
       }
             public static ArrayList<Adherent> getListAdherent(){
        ArrayList<Adherent> list = new ArrayList<Adherent>();
        
        
        
         try{
             Connection con1 = AdherentDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select cin, nom, prenom, addresse,telephone from adherent");
          
            while(rs.next()){
                 Adherent adherent = new Adherent();
   
                adherent.setNom(rs.getString("nom"));
                adherent.setPrenom(rs.getString("prenom"));
               
                adherent.setCin(rs.getString("cin"));
                adherent.setAddresse(rs.getString("addresse"));
                
                adherent.setTelephone(rs.getString("telephone"));
                
                
                list.add(adherent);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;}
       
   }
    
