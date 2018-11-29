/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.penalite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.penalite.entites.Penalite;

/**
 *
 * @author yousra
 */
public class PenaliteDb {
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
      public static int ajouter(Penalite penalite){
       int status=0;
       try{
           Connection conn = PenaliteDb.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into penalite ( idemprunt, description) values (?,?)");
          
           ps.setInt(1,penalite.getIdemprunt());
           ps.setString(2,penalite.getDescription());
        
         
           status = ps.executeUpdate();
           conn.close();
       }
      catch(Exception e){System.out.println(e);}
       return status;
          
       }
      public static ArrayList<Penalite> getListPen(String cin){
        ArrayList<Penalite> list = new ArrayList<Penalite>();
        
        
        
         try{
           Connection con1 = PenaliteDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select * from penalite, emprunt, reservation  where penalite.idemprunt=emprunt.idemprunt and emprunt.idreserv=reservation.idreserv and reservation.cin='"+ cin +"'");
           System.out.println(cin);
          
            while(rs.next()){
                
                Penalite penalite = new Penalite();
                penalite.setIdpenalite(Integer.parseInt(rs.getString("idpenalite")));
                penalite.setIdemprunt(Integer.parseInt(rs.getString("idemprunt")));
                penalite.setDescription(rs.getString("description"));
           
                
               
                
                
                list.add(penalite);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;
    } 
       public static void supprimerpenalite(String idpenalite){
            try{
           
          
             Connection con1 = PenaliteDb.getConnection();
             
             Statement ps = con1.createStatement();
             ps.execute("delete from penalite where idpenalite="+ Integer.parseInt(idpenalite) +"");}
            
        catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
    }
      public static ArrayList<String[]> getList(){
        //ArrayList<Reservation> list = new ArrayList<Reservation>();
        
        //List<List<String>> MesReserv = new ArrayList<>();
        ArrayList<String[]> MesRetards = new ArrayList<String[]>();
        

        
        
         try{
             Connection con1 = PenaliteDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select * from emprunt , reservation where emprunt.IDRESERV=reservation.IDRESERV and emprunt.retour='0' and emprunt.datefin < current_date");
          
          
            while(rs.next()){
                
                //Reservation reservation = new Reservation();
                //reservation.setCin(cin);
                //reservation.setIdreserv(Integer.parseInt(rs.getString("idreserv")));
                //reservation.setNumlivre(Integer.parseInt(rs.getString("idlivre")));
                String[] myString1= {rs.getString("cin"),rs.getString("idemprunt"),rs.getString("idlivre")};
                MesRetards.add(myString1);
                
               
                
                
                //list.add(reservation);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return MesRetards;
    }  
}
