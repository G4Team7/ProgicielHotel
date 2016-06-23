/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rechad
 */
public class Reservation {
    public IntegerProperty id = new SimpleIntegerProperty(this, "id");
    public IntegerProperty idProperty() {
        return id ;
    }
    public final Integer getId() {
        return idProperty().get();
    }
    public final void setId(Integer id) {
        idProperty().set(id);
    }

    public IntegerProperty nbPersonnes = new SimpleIntegerProperty(this, "nbpersonnes");
    public IntegerProperty nbPersonnesProperty() {
        return nbPersonnes ;
    }
    public final Integer getNbPersonnes() {
        return nbPersonnesProperty().get();
    }
    public final void setNbPersonnes(Integer nbPersonnes) {
        nbPersonnesProperty().set(nbPersonnes);
    }
    
    public IntegerProperty idClient = new SimpleIntegerProperty(this, "idClient");
    public IntegerProperty idClientProperty() {
        return idClient ;
    }
    public final Integer getIdClient() {
        return idClientProperty().get();
    }
    public final void setIdClient(Integer idClient) {
        idClientProperty().set(idClient);
    }
    
    public IntegerProperty idChambre = new SimpleIntegerProperty(this, "idChambre");
    public IntegerProperty idChambreProperty() {
        return idChambre ;
    }
    public final Integer getIdChambre() {
        return idChambreProperty().get();
    }
    public final void setIdChambre(Integer idChambre) {
        idChambreProperty().set(idChambre);
    }
    
    public SimpleDateFormat dateDebut = new SimpleDateFormat("dd/MM/yyyy");
    public SimpleDateFormat dateDebutProperty() {
        return dateDebut ;
    }
    public final SimpleDateFormat getDateDebut() {
        return dateDebutProperty();
    }
    public final void setDateDebut(SimpleDateFormat dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public SimpleDateFormat dateFin = new SimpleDateFormat("dd/MM/yyyy");
    public SimpleDateFormat dateFinProperty() {
        return dateFin ;
    }
    public final SimpleDateFormat getDateFin() {
        return dateFinProperty();
    }
    public final void setDateFin(SimpleDateFormat dateFin) {
        this.dateFin = dateFin;
    }
    
    
    

    public Reservation() {}

    public Reservation(Integer id, Integer nbpersonnes, Date datedebut, Date datefin, Integer idClient, Integer idChambre ) {
        setId(id);
        setNbPersonnes(nbpersonnes);
        setIdClient(idClient);
        setIdChambre(idChambre);
    }

    
    public void deleteUser(){
          
    }
}
