/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rechad
 */
public class Client {
    public StringProperty nom = new SimpleStringProperty(this, "nom");
    public StringProperty nomProperty() {
        return nom ;
    }
    public final String getNom() {
        return nomProperty().get();
    }
    public final void setNom(String nom) {
        nomProperty().set(nom);
    }

    public StringProperty prenom = new SimpleStringProperty(this, "prenom");
    public StringProperty prenomProperty() {
        return prenom ;
    }
    public final String getPrenom() {
        return prenomProperty().get();
    }
    public final void setPrenom(String prenom) {
        prenomProperty().set(prenom);
    }
    
    
    public StringProperty adresse = new SimpleStringProperty(this, "addresse");
    public StringProperty adresseProperty() {
        return adresse ;
    }
    public final String getAdresse() {
        return adresseProperty().get();
    }
    public final void setAdresse(String addresse) {
        adresseProperty().set(addresse);
    }
    
    

    public Client() {}

    public Client(String nom, String prenom, String adresse) {
        setNom(nom);
        setPrenom(prenom);
        setAdresse(adresse);
    }

    
    public void deleteUser(){
          
    }
}
