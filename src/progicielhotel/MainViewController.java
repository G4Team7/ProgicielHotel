package progicielhotel;

import database.DataAccessor;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/** Controls the main application screen */
public class MainViewController {
  //@FXML private Button logoutButton;
  //@FXML private Label  sessionLabel;
  @FXML private Text textRecette;
  @FXML private Text textRecetteMonth;
  private DataAccessor dataAccessor ;
  
  public void initialize() {}
  
  public void initSessionID(final LoginManager loginManager, String sessionID) {
      
          //sessionLabel.setText(sessionID);
          /*logoutButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
          loginManager.logout();
          }
          });
          
          restaurantButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent event) {
          try {
          FXMLLoader loader = new FXMLLoader(
          getClass().getResource("DirecteurRestaurant.fxml")
          );
          scene.setRoot((Parent) loader.load());
          DirecteurRestaurantController controller =
          loader.<DirecteurRestaurantController>getController();
          controller.initSessionID(this, sessionID);
          } catch (IOException ex) {
          Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
          }
          }
          });
          */
      try {   
          dataAccessor = new DataAccessor("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/gondor", "root", "");
          java.util.Date today = Calendar.getInstance().getTime();
          
          String date = new SimpleDateFormat("yyyy-MM-dd").format(today);         
          
          String month = new SimpleDateFormat("yyyy").format(today);
          String year = new SimpleDateFormat("MM").format(today);
          
          Integer recette = dataAccessor.getDailyRecetteReservations(date);
          
          int recetteMonth = dataAccessor.getMonthlyRecetteReservations(year, month, date);
          
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