/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progicielhotel;

import database.DataAccessor;
import java.sql.SQLException;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/**
 *
 * @author yaniv
 */
public class DirecteurRestaurantController {
    private DataAccessor dataAccessor ;
    @FXML private Text recetteRestauJour;
    
    //@FXML private Label  sessionLabel;
  public void initialize() {
      try {
      int recetteJour = dataAccessor.getReservationRestaurant();
      recetteRestauJour.setText(recetteJour + " €");
      }
        catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        }
  }
  

    
}
