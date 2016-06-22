/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

/**
 *
 * @author Rechad
 */
public class UserDataAccessor {
    // in real life, use a connection pool....
    private Connection connection ;

    public UserDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<User> getPersonList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from user");
        ){
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                User user = new User(prenom, nom);
                userList.add(user);
            }
            return userList ;
        } 
    }
}
