/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankrupt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class PrograsbarController implements Initializable {

    @FXML
    private Button exit;
    @FXML
    private Button start;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void buttonStart(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),635 , 520);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Nasabah");
            stage.show();
    }
    
}
