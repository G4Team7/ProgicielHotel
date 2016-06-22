/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation;

import java.util.Date;

/**
 *
 * @author Rechad
 */
public class ReservationService {
    private Date dateReservation;
    private int nbHeure;
    
    public ReservationService(Date dateReservationService, int nbHeureService){
        this.dateReservation = dateReservationService;
        this.nbHeure = nbHeureService;
    }
}
