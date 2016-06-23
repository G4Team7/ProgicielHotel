package progicielhotel;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controls the main application screen */
public class MainViewController {
  //@FXML private Button logoutButton;
  //@FXML private Label  sessionLabel;
  
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
    
    
  }
}