/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progicielhotel;

import database.DataAccessor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            java.util.Date today = Calendar.getInstance().getTime();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(today);   
            int recetteJour;
            recetteJour = dataAccessor.getRecetteRestaurant(date);
            recetteRestauJour.setText(recetteJour + " €");
        } catch (SQLException ex) {
            Logger.getLogger(DirecteurRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  } 
  

    
}
