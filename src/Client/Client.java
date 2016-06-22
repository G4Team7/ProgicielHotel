/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Rechad
 */
public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    
    public Client(String nomClient, String prenomClient, String adresseClient){
        this.nom = nomClient;
        this.prenom = prenomClient;
        this.adresse = adresseClient;  
    }
}
