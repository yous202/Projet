/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emprunt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.emprunt.entites.Emprunt;
import org.reserv.entities.Reservation;

/**
 *
 * @author yousra
 */
public class EmpruntDb {
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
  
      
  
     public static int ajouter(Emprunt emprunt){
       int status=0;
       try{
           Connection conn = EmpruntDb.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into emprunt ( idreserv, datedebut, datefin, retour) values (?,?,?,?)");
          
           ps.setInt(1,emprunt.getIdreserv());
           ps.setDate(2,emprunt.getDatedebut());
           ps.setDate(3,emprunt.getDatefin());
           ps.setString(4,emprunt.getRetour());
         
           status = ps.executeUpdate();
           conn.close();
       }
      catch(Exception e){System.out.println(e);}
       return status;
          
       }
     public static ArrayList<Emprunt> getListEmp(String cin){
        ArrayList<Emprunt> list = new ArrayList<Emprunt>();
        
        
        
         try{
             Connection con1 = EmpruntDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select * from emprunt, reservation where emprunt.idreserv=reservation.idreserv and reservation.cin='"+ cin +"'");
           System.out.println(cin);
          
            while(rs.next()){
                
                Emprunt emprunt = new Emprunt();
                emprunt.setIdreserv(Integer.parseInt(rs.getString("idreserv")));
                emprunt.setIdemprunt(Integer.parseInt(rs.getString("idemprunt")));
                emprunt.setDatedebut(rs.getDate("datedebut"));
                emprunt.setDatefin(rs.getDate("datefin"));
                emprunt.setRetour(rs.getString("retour"));
                
                
               
                
                
                list.add(emprunt);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;
    } 
       public static void supprimeremprunt(String idemprunt){
            try{
           
          
             Connection con1 = EmpruntDb.getConnection();
             
             Statement ps = con1.createStatement();
             ps.execute("delete from emprunt where idemprunt="+ Integer.parseInt(idemprunt) +"");}
            
        catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
    }
       public static Emprunt getEmprunt(String idemprunt){
           Emprunt emprunt = new Emprunt();
           try {
           Connection con1 = EmpruntDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
          
           rs = ps.executeQuery("select * from emprunt where idemprunt =" + Integer.parseInt(idemprunt) + "");
            System.out.println(idemprunt);
            if(rs.next()){
                emprunt.setIdemprunt(Integer.parseInt(idemprunt));
                System.out.println(idemprunt);
                emprunt.setIdreserv(Integer.parseInt(rs.getString("idreserv")));
               
               emprunt.setDatedebut(rs.getDate("datedebut"));
               emprunt.setDatefin(rs.getDate("datefin"));
                emprunt.setRetour(rs.getString("retour"));
               
                        
            }
           }
           catch (Exception ex){
       System.err.println("hjfdsqz" + ex.getMessage());
    }
    return emprunt;  
           
       }
        public static int editeremprunt(Emprunt emprunt){
       int status=0;
       try{
          
           Connection conn = EmpruntDb.getConnection();
          
         PreparedStatement ps = conn.prepareStatement("UPDATE  emprunt SET datedebut= ? , datefin= ?,  retour= ?   where idemprunt= ? ");
         
         ps.setDate(1,emprunt.getDatedebut());
         ps.setDate(2,emprunt.getDatefin());
        ps.setString(3,emprunt.getRetour());
          ps.setInt(4,emprunt.getIdemprunt());
          
                System.out.println(emprunt.getRetour());
       
         status = ps.executeUpdate();
         
           //status = statement.executeUpdate("UPDATE  adherent SET NOM='"+adherent.getNom()+"', PRENOM='"+adherent.getPrenom()+"', ADDRESSE='"+adherent.getAddresse()+"', TELEPHONE='"+adherent.getTelephone()+"' where EMAIL='"+adherent.getEmail()+"';");
           conn.close();
       }
      catch(Exception e){System.out.println(e);
     
       }
       return status;
          
       }
         public static ArrayList<String[]> getListRes(String cin, String email ){
        //ArrayList<Reservation> list = new ArrayList<Reservation>();
        
        //List<List<String>> MesReserv = new ArrayList<>();
        ArrayList<String[]> MesReserv = new ArrayList<String[]>();
        

        
        
         try{
             Connection con1 = EmpruntDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select reservation.idreserv, reservation.idlivre , livre.titre , livre.auteur from livre, assisstant , reservation left join emprunt on reservation.IDRESERV = emprunt.IDRESERV where emprunt.IDRESERV is null and reservation.IDLIVRE=livre.NUMLIVRE and livre.IDBIB=assisstant.IDBIB and assisstant.email='"+ email +"'and reservation.cin='"+ cin +"'");
           System.out.println(cin);
          
            while(rs.next()){
                
                //Reservation reservation = new Reservation();
                //reservation.setCin(cin);
                //reservation.setIdreserv(Integer.parseInt(rs.getString("idreserv")));
                //reservation.setNumlivre(Integer.parseInt(rs.getString("idlivre")));
                String[] myString1= {cin,rs.getString("idreserv"),rs.getString("idlivre"),rs.getString("titre"),rs.getString("auteur")};
                MesReserv.add(myString1);
                
               
                
                
                //list.add(reservation);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return MesReserv;
    }  
}
    

