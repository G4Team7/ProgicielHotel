/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Client.Client;
import Reservation.Reservation;
import Reservation.ReservationRestaurant;
import java.sql.Connection ;

import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;

import java.util.List ;
import java.util.ArrayList ;
import java.util.Calendar;

/**
 *
 * @author Rechad
 */
public class DataAccessor {
    private Connection connection ;

    public DataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        try{
            connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
    }
        
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    public boolean checkUser(String username, String password) throws SQLException {
        boolean exist = false;
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from utilisateur where '"+username+"' = pseudo && '"+password+"' = mot_de_passe");
        ){
            List<Reservation> reservationList = new ArrayList<>();
            while (rs.next()) {
                exist = true;
            }
            return exist ;
        } 
    }
    
    public Integer getDailyRecetteReservations(String date) throws SQLException {
        Integer recette = 0;
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT SUM(c.tarif) AS recette FROM chambre c INNER JOIN (SELECT id_chambre FROM reservation WHERE '"+ date +"' BETWEEN dateDebut and dateFin GROUP BY id_chambre) AS rs ON c.numeros = rs.id_chambre");
                
        ){
            
            while (rs.next()) {
                recette +=  rs.getInt("recette");;
            }
            return recette ;
        } 
    }
    
    public int getMonthlyRecetteReservations(String year, String month, String date) throws SQLException {
        int recette = 0;
        int yearnb = Integer.parseInt(year);
        int monthnb = Integer.parseInt(month);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, yearnb);
        calendar.set(Calendar.MONTH, monthnb);
        int numDays = calendar.getActualMaximum(Calendar.DATE);
        String day;
        
        for (int i = 1; i<=numDays; i++){
            day = String.format("%02d", i);
            
            date = year+"-"+month+"-"+day;
            try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT SUM(c.tarif) AS recette FROM chambre c INNER JOIN (SELECT id_chambre FROM reservation WHERE '"+ date +"' BETWEEN dateDebut and dateFin GROUP BY id_chambre) AS rs ON c.numeros = rs.id_chambre");
                
            ){

                while (rs.next()) {
                    recette +=  rs.getInt("recette");;
                }

            } 
        }
        return recette ;
    }
    
    public int getDureeMoyenneSejour(String year, String month) throws SQLException, ParseException {
        int dureeSejour = 0;
        int yearnb = Integer.parseInt(year);
        int monthnb = Integer.parseInt(month);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, yearnb);
        calendar.set(Calendar.MONTH, monthnb);
        int numDays = calendar.getActualMaximum(Calendar.DATE);
        int nbReservations = 0;
        
        String dateDebut = year+"-"+month+"-01";
        String dateFin = year+"-"+month+"-"+numDays;
        List<Integer> ListDureeReservation = new ArrayList<>();
        
        java.util.Date date1 = new java.util.Date();
        java.util.Date date2 = new java.util.Date();
        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        int diffInDays;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (
        Statement stmnt = connection.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT dateDebut, dateFin FROM reservation WHERE dateDebut BETWEEN '"+dateDebut+"' and '"+dateFin+"' OR dateFin BETWEEN '"+dateDebut+"' and '"+dateFin+"'");

        ){

            while (rs.next()) {
                dateDebut =  rs.getString("dateDebut");
                dateFin =  rs.getString("dateFin");
                
                date1 = sdf.parse(dateDebut);
                date2 = sdf.parse(dateFin);
                diffInDays = (int) ((date2.getTime() - date1.getTime())/ DAY_IN_MILLIS );
                ListDureeReservation.add(diffInDays);
                nbReservations++;
            }

           if(nbReservations > 0){
               for(int i = 0; i<ListDureeReservation.size(); i++){
                   dureeSejour += ListDureeReservation.get(i);
               }
               dureeSejour = dureeSejour/nbReservations;
           }
        }
        return dureeSejour ;
    }
    
    
    public List<Reservation> getReservationList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from reservation");
        ){
            List<Reservation> reservationList = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer nbpersonne = rs.getInt("nbPersonnes");
                Date datedebut = rs.getDate("dateDebut");
                Date datefin = rs.getDate("dateFin");
                Integer id_client = rs.getInt("id_client");
                Integer id_chambre = rs.getInt("id_chambre");
                Reservation reservation = new Reservation(id, nbpersonne, datedebut, datefin, id_client, id_chambre);
                reservationList.add(reservation);
            }
            return reservationList ;
        } 
    }
    /*
    public int getReservationRestaurant() throws SQLException {
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT COUNT(res.id), SUM(tarif) "
                                        + "FROM reservation r inner join chambre c on r.id_chambre = c.id inner join reservation_restaurant res on res.id = r.id_reservation_restaurant "
                                        + "WHERE dateReservation = CURRENT_DATE()"); 
            
            
            List<ReservationRestaurant> reservationRestaurant = new ArrayList<>();
            while (rs.next()) {
               int reservation = intParseint(rs);
               return reservation;
            }
            
        }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }

        return 0;
    }
    */
    
    public int getRecetteRestaurant(String date) throws SQLException {
       
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT SUM(tarif) as recette"
                                        + "FROM reservation_restaurant "
                                        + "WHERE dateReservation = '"+date+"'"); 
            
            
            while (rs.next()) {
               int recette = rs.getInt("recette");
               return recette;  
            }
            
            
            
        }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }

        return 0;
    }
    
    public int getNbReservationRestaurant(String date) throws SQLException {
       
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT COUNT(*) as nbReservationRestaurant "
                                        + "FROM reservation_restaurant "
                                        + "WHERE dateReservation = '"+date+"'");             
            
            while (rs.next()) {
               int reservation = rs.getInt("nbReservationRestaurant");
               return reservation;  
            }
            
            
            
        }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }

        return 0;
    }
    
    public int getNbDejeunerRestaurant(String date) throws SQLException {
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT COUNT(*) as nbReservationRestaurant"
                                        + "FROM reservation_restaurant "
                                        + "WHERE dateReservation = '"+date+"' AND service='midi'"); 
            
            while (rs.next()) {
               int reservation = rs.getInt("nbReservationRestaurant");
               return reservation;  
            }
        }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }

        return 0;
    }
    
    public int getNbDinerRestaurant(String date) throws SQLException {
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT COUNT(*) as nbReservationRestaurant"
                                        + "FROM reservation_restaurant "
                                        + "WHERE dateReservation = '"+date+"' AND service='soir'"); 
            
            while (rs.next()) {
               int reservation = rs.getInt("nbReservationRestaurant");
               return reservation;  
            }
        }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }

        return 0;
    }
    
    
    public int getNbPetitDejeuner(String year, String month, String day) throws SQLException {

        int daynb = Integer.parseInt(day);
        String veille = String.format("%02d", (daynb-1));
        
        String date = year+"-"+month+"-"+veille;
        try (
            
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT count(*) as nbPetitDej FROM reservation WHERE '"+ date +"' BETWEEN dateDebut and dateFin");
        ){
            
            while (rs.next()) {
                
                int nbPetitDej = rs.getInt("nbPetitDej");
                return nbPetitDej ;
            }
            
        } 
        return 0;
    }
    
    public List<Client> getClientList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from client");
        ){
            List<Client> clientList = new ArrayList<>();
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                Client client = new Client(nom, prenom, adresse);
                clientList.add(client);
            }
            return clientList ;
        } 
    }

}
