/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reserv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.livre.entites.Livre;
import org.reserv.entities.Reservation;

/**
 *
 * @author yousra
 */
public class ReservDb {
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
      public static int ajouter(Reservation reservation){
       int status=0;
       try{
           Connection conn = ReservDb.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into reservation (idlivre,cin) values (?,?)");
           ps.setInt(1,reservation.getNumlivre());
           ps.setString(2,reservation.getCin());
         
           status = ps.executeUpdate();
           conn.close();
       }
      catch(Exception e){System.out.println(e);}
       return status;
          
       }
      
      public static int checkclient( String cin ){
       
       try{
           Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select count(emprunt.IDEMPRUNT) as number from emprunt join reservation on emprunt.idreserv=reservation.IDRESERV where emprunt.DATEFIN > CURRENT_DATE and cin='"+ cin+"' ");
           if(rs.next()){ return Integer.parseInt(rs.getString("number")) ;}
           else { return 0 ;}
       }
      catch(Exception e){System.out.println(e);}
       { return 0 ;}
          
      }
      
       public static int checknbrexemp( String numlivre ){
       
       try{
           Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select count(reservation.IDLIVRE) as nbr from emprunt , reservation where emprunt.IDRESERV=reservation.IDRESERV and reservation.IDLIVRE="+Integer.parseInt(numlivre)+ " and  emprunt.RETOUR='0' ");
           if(rs.next()){ return Integer.parseInt(rs.getString("nbr")) ;}
           else { return 0 ;}
       }
      catch(Exception e){System.out.println(e);}
       { return 0 ;}
          
      }
       
       public static int checkpenal( String cin ){
       
       try{
           Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select * from penalite , emprunt , reservation where penalite.IDEMPRUNT=emprunt.IDEMPRUNT and emprunt.IDRESERV=reservation.IDRESERV and cin='"+cin+"'");
           if(rs.next()){ return 1 ;}
           
       }
      catch(Exception e){System.out.println(e);}
       { return 0 ;}
          
      }
       
       public static int cherchnbrexemp( String numlivre ){
       
       try{
           Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select nbrexemplaire as nbr from livre where numlivre="+Integer.parseInt(numlivre)+ "");
           if(rs.next()){ System.out.println("mparsia a khoya " + Integer.parseInt(rs.getString("nbr")));return Integer.parseInt(rs.getString("nbr")) ;}
           else { System.out.println("mparsia a khoya yos " );return 0 ;}
       }
      catch(Exception e){System.out.println(e);}
       {  System.out.println("mparsia a khoya yos " ); return 0 ;}
          
      }
      
      
       public static ArrayList<Livre> getListlivre(String titre, String auteur){
        ArrayList<Livre> list = new ArrayList<Livre>();
        
        
        
         try{
             Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select numlivre, titre, auteur, idbib, edition from livre where titre='"+ titre +"' and auteur='"+auteur+"'");
           System.out.println(titre);
           System.out.println(auteur);
            while(rs.next()){
                 Livre livre = new Livre();
                livre.setNumlivre(Integer.parseInt(rs.getString("numlivre")));
                livre.setTitre(titre);
                livre.setAuteur(auteur);
                 livre.setIdbib(Integer.parseInt(rs.getString("idbib")));
                livre.setEdition(Integer.parseInt(rs.getString("edition")));
               
                
                
                list.add(livre);
                        
            }
        }catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
         return list;
    }  
        public static void supprimerreserv(String idreserv){
            try{
           
          
             Connection con1 = ReservDb.getConnection();
             
             Statement ps = con1.createStatement();
             ps.execute("delete from reservation where idreserv="+ Integer.parseInt(idreserv) +"");}
            
        catch (SQLException ex){
       System.err.println("GS" + ex.getMessage());
    }
    }
       
         public static ArrayList<String[]> getListRes(String cin ){
        //ArrayList<Reservation> list = new ArrayList<Reservation>();
        
        //List<List<String>> MesReserv = new ArrayList<>();
        ArrayList<String[]> MesReserv = new ArrayList<String[]>();
        

        
        
         try{
             Connection con1 = ReservDb.getConnection();
           Statement ps = con1.createStatement();
           ResultSet rs;
           
           rs = ps.executeQuery("select reservation.idreserv, reservation.idlivre , livre.titre , livre.auteur from reservation , livre where reservation.IDLIVRE=livre.NUMLIVRE and cin='"+ cin +"'");
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

    

