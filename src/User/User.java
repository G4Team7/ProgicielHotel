/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import javafx.beans.property.StringProperty ;
import javafx.beans.property.SimpleStringProperty ;
/**
 *
 * @author Rechad
 */
public class User {
    
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

    public User() {}

    public User(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
    }

    
    public void deleteUser(){
          
    }
}
