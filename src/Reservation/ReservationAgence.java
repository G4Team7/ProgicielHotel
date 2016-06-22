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
public class ReservationAgence {
    private String nom;
    private String prenom;
    private int nbPersonnes;
    private Date dateDebut;
    private Date dateFin;
    
    public ReservationAgence(String nomResAgence, String prenomResAgence, int nbPersonnesResAgence, Date dateDebutResAgence, Date dateFinResAgence){
        this.nom = nomResAgence;
        this.prenom = prenomResAgence;
        this.nbPersonnes = nbPersonnesResAgence;
        this.dateDebut = dateDebutResAgence;
        this.dateFin = dateFinResAgence;
        
    }
}
