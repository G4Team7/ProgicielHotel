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
    public String nom;
    public String prenom;
    
    public void addUser(String nom, String prenom, Integer profil, Integer secteur){
          
    }
    
    public User getUser(Integer id){
        User user = new User();
          // Réccupérer utilisateur dans BDD et assigner ses attributs à user
        return user;
    }
    
    public void setUser(){
          
    }
    
    public void deleteUser(){
          
    }
}
