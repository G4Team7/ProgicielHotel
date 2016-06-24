package progicielhotel;

import database.DataAccessor;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/** Controls the main application screen */
public class MainViewController {
  //@FXML private Button logoutButton;
  //@FXML private Label  sessionLabel;
  @FXML private Text textRecette;
  @FXML private Text textRecetteMonth;
  @FXML private Text textDureeSejour;
  @FXML private Text textNbRepasServis;
  @FXML private Text textNbPetitDejeuner;
  @FXML private Button btnDashboardRestau;
  private DataAccessor dataAccessor ;
  
  public void initialize() {}
  
  public void initSessionID(final LoginManager loginManager, String sessionID){
      
          //sessionLabel.setText(sessionID);
          /*logoutButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
          loginManager.logout();
          }
          });
          */
          btnDashboardRestau.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
              loginManager.showDirecteurRestau();
              }
           });
          
      try {   
          dataAccessor = new DataAccessor("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/gondor", "root", "");
          java.util.Date today = Calendar.getInstance().getTime();
          
          String date = new SimpleDateFormat("yyyy-MM-dd").format(today);         
          
          String year = new SimpleDateFormat("yyyy").format(today);
          String month = new SimpleDateFormat("MM").format(today);
          String day = new SimpleDateFormat("dd").format(today);
          
          Integer recette = dataAccessor.getDailyRecetteReservations(date);
          
          int recetteMonth = dataAccessor.getMonthlyRecetteReservations(year, month, date);
          
          int dureeSejour;
            try {
                dureeSejour = dataAccessor.getDureeMoyenneSejour(year, month);
                textDureeSejour.setText(dureeSejour + "");
            } catch (ParseException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
          int repasServis;
          repasServis = dataAccessor.getNbReservationRestaurant(date);
          textNbRepasServis.setText(repasServis + "");
          
          int nbPetitDej;
          nbPetitDej = dataAccessor.getNbPetitDejeuner(year, month, day);
          textNbPetitDejeuner.setText(nbPetitDej + "");
          
          System.out.println(recette);
          textRecette.setText(recette + " €");
          textRecetteMonth.setText(recetteMonth + " €");
          
      } catch (SQLException ex) {
          Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
  }
}