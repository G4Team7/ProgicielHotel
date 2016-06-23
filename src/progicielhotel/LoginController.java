package progicielhotel;

import database.DataAccessor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controls the login screen */
public class LoginController {
  @FXML private TextField user;
  @FXML private TextField password;
  @FXML private Button loginButton;
  
  public void initialize() {}
  
  public void initManager(final LoginManager loginManager) {
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        String sessionID = authorize();
        if (sessionID != null) {
          loginManager.authenticated(sessionID);
        }
      }
    });
  }

  /**
   * Check authorization credentials.
   * 
   * If accepted, return a sessionID for the authorized session
   * otherwise, return null.
   */   
  private String authorize() {
      
      DataAccessor dataAccessor ;
      try {
          dataAccessor = new DataAccessor("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/gondor", "root", "");
          return dataAccessor.checkUser(user.getText(), password.getText())
            ? generateSessionID() 
            : null;
      } catch (SQLException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
      
    
  }
  
  private static int sessionID = 0;

  private String generateSessionID() {
    sessionID++;
    return "xyzzy - session " + sessionID;
  }
}