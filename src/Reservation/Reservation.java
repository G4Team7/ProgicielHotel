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
public class Reservation {
    private String nom;
    private String prenom;
    private int numChambre;
    private int nbPersonnes;
    private Date dateDebut;
    private Date dateFin;
    
    public Reservation(String nomRes, String prenomRes, int numChambreRes, int nbPersonnesRes, Date dateDebutRes, Date dateFinRes){
        this.nom = nomRes;
        this.prenom = prenomRes;
        this.numChambre = numChambreRes;
        this.nbPersonnes = nbPersonnesRes;
        this.dateDebut = dateDebutRes;
        this.dateFin = dateFinRes;
        
    }
    
}
