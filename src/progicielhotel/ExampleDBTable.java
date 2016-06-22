/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progicielhotel;

import Client.Client;
import Client.ClientDataAccessor;
import javafx.application.Application ;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView ;
import javafx.scene.control.TableColumn ;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.scene.layout.BorderPane ;
import javafx.scene.Scene ;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage ;
import javafx.util.Callback;

/**
 *
 * @author Rechad
 */
public class ExampleDBTable extends Application{
    private ClientDataAccessor dataAccessor ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        dataAccessor = new ClientDataAccessor("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/gondor", "root", ""); // provide driverName, dbURL, user, password...

        TableView<Client> clientTable = new TableView<>();
        TableColumn<Client, String> nom = new TableColumn<>("Nom");
        nom.setCellValueFactory(new Callback<CellDataFeatures<Client, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(CellDataFeatures<Client, String> p) {
                // p.getValue() returns the Person instance for a particular TableView row
                return p.getValue().nomProperty();
            }
         });

        TableColumn<Client, String> lastNameCol = new TableColumn<>("Prenom");
        lastNameCol.setCellValueFactory(new Callback<CellDataFeatures<Client, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(CellDataFeatures<Client, String> p) {
                // p.getValue() returns the Person instance for a particular TableView row
                return p.getValue().prenomProperty();
            }
         });
        TableColumn<Client, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new Callback<CellDataFeatures<Client, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(CellDataFeatures<Client, String> p) {
                // p.getValue() returns the Person instance for a particular TableView row
                return p.getValue().adresseProperty();
            }
         });

        clientTable.getColumns().addAll(nom, lastNameCol, adresseCol);

        clientTable.getItems().addAll(dataAccessor.getPersonList());

        BorderPane root = new BorderPane();
        root.setCenter(clientTable);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        if (dataAccessor != null) {
            dataAccessor.shutdown();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
