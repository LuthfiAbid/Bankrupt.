/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankrupt;

import static bankrupt.KoneksiDB.koneksi;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class FormController implements Initializable {

    @FXML
    private JFXTextField User;
    @FXML
    private JFXPasswordField Password;
    @FXML
    private Button ok;
    
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button ok1;
    @FXML
    private TextField nama;
    @FXML
    private TextField Alamat;
    private JFXTextField Username;
    private TextField last;
    @FXML
    private TextField rekening;
    @FXML
    private TextField saldotunai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
void Kirim(){
        //untuk validasi isian
         if(rekening.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Nomor Rekening Anda");
        }else if (nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan Nama Anda");
        }else if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Username Anda");
        }else if(password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Password Anda");
        }else if(Alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih Alamat Buku");
        }
        }
    @FXML
     private void buttonOk(ActionEvent event) throws SQLException, IOException {
          if(User.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Username harap diisi!");
          }else if(Password.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Password tidak boleh kosong!");
          }else{
          
      Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta?zeroDateTimeBehavior=convertToNull", "root","");
            ps = connection.prepareStatement("SELECT * FROM `akun` WHERE username=? AND password =?");
            ps.setString(1,User.getText());
            ps.setString(2,Password.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Benar!");
          
        
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("tabpane.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),600 , 400);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Nasabah");
            stage.show();
       } else{
                Component rootPane = null;
              javax.swing.JOptionPane.showMessageDialog(rootPane, "Username atau Password Salah!");  
              Password.setText("");
              User.requestFocus();
            }
    } catch(java.sql.SQLException ex){
            Component rootPane = null;
         javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal!"); 
    }
        
        }
    }

    @FXML
    private void buttonOk1(ActionEvent event)throws SQLException, IOException {
        if(rekening.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Nomor Rekening harap diisi!");
        }else if(nama.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Nama harap diisi!");
    }else if(username.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Nomor Rekening harap diisi!");
    }else if(password.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Password harap diisi!");
    }else if(Alamat.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Alamat anda harap diisi!");
    }else{
    
        Connection connection;
        PreparedStatement ps;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan menyimpan data");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk menyimpan data, Cancel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Kirim();
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
                String query = "INSERT INTO `akun`(`norek`,`nama`,`username`,`password`,`alamat`,`saldo`) VALUES (?,?,?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, rekening.getText());
                ps.setString(2, nama.getText());
                ps.setString(3, username.getText());
                ps.setString(4, password.getText());
                ps.setString(5,  Alamat .getText());
                ps.setString(6,  saldotunai .getText());
                
                ps.execute();
                Alert berhasil = new Alert(AlertType.INFORMATION);
                berhasil.setTitle("Informasi Database");
                berhasil.setHeaderText(null);
                berhasil.setContentText("Data "+username.getText()+" Telah Berhasil Disimpan\n\nTerima Kasih.");   
                berhasil.showAndWait();
                ps.close();
            } catch (SQLException e) {
                Alert gagal = new Alert(AlertType.ERROR);
                gagal.setTitle("Informasi Database");
                gagal.setHeaderText(null);
                gagal.setContentText("Data "+username.getText()+" Tidak Dapat Disimpan\n\nSilahkan Di Ulang.\n"
                        + "Error = "+e);
                gagal.showAndWait();
            }
        } else {
            alert.close();
        }
    }
    }
}

