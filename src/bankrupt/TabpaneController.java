/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankrupt;

import static bankrupt.KoneksiDB.koneksi;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class TabpaneController implements Initializable {

    private static String username;

    static void setUserLogin(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private JFXTextField Nama;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField nomor;
    @FXML
    private JFXTextField saldo;
    @FXML
    private Button ok;
    @FXML
    private Button cari;
    @FXML
    private Button total;
    @FXML
    private JFXTextField User;
    @FXML
    private JFXTextField awal;
    @FXML
    private JFXTextField Depo;
    @FXML
    private JFXTextField Depo2;
    @FXML
    private Button OK;
    private ResultSet rs;
    @FXML
    private JFXTextField NICK;
    @FXML
    private JFXTextField NOREK;
    @FXML
    private JFXTextField SALDO;
    @FXML
    private JFXTextField TRANS1;
    @FXML
    private JFXTextField TRANS2;
    @FXML
    private Button transfer;
    @FXML
    private Button TOTAL;
    @FXML
    private JFXTextField akun1;
    @FXML
    private JFXTextField akun2;
    private JFXTextField account;
    @FXML
    private Button show;
    @FXML
    private JFXTextField transferakun;
    @FXML
    private Button out;
    @FXML
    private Button out1;
    @FXML
    private Button out2;

   

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    public void combo(){
       
    }

    @FXML
    private void buttonOk(ActionEvent event) {
        
        Connection connection;
        PreparedStatement ps;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan menyimpan data");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk menyimpan data, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            try {
                
                String value1=User.getText();
                String value2=Depo2.getText();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta?zeroDateTimeBehavior=convertToNull", "root","");
                String query = "UPDATE akun set SALDO='"+value2+"' where nama='"+value1+"'";
                ps = connection.prepareStatement(query);
                
                
                ps.execute();
                Alert berhasil = new Alert(Alert.AlertType.INFORMATION);
                berhasil.setTitle("Informasi Database");
                berhasil.setHeaderText(null);
                berhasil.setContentText("Data "+Depo2.getText()+" Telah Berhasil Deposit\n\nTerima Kasih.");   
                User.setText("");
                Depo.setText("");
                awal.setText("");
                Depo2.setText("");
                berhasil.showAndWait();
                ps.close();
            } catch (SQLException e) {
                Alert gagal = new Alert(Alert.AlertType.ERROR);
                gagal.setTitle("Informasi Database");
                gagal.setHeaderText(null);
                gagal.setContentText("Data "+Depo.getText()+" Tidak Dapat Deposit\n\nSilahkan Di Ulang.\n"
                        + "Error = "+e);
                gagal.showAndWait();
            }
        } else {
            alert.close();
        }
    }

    @FXML
    private void buttonSearch(ActionEvent event) {
        
         Connection connection;
        PreparedStatement pst;
        String sql="SELECT * FROM `akun` WHERE nama=?";
    try{
        
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
    pst=connection.prepareStatement(sql);
    pst.setString(1, User.getText());
    rs = pst.executeQuery();
    if(rs.next()){
         
    String add1=rs.getString("saldo");
    awal.setText(add1);
    
    
    }else{
    JOptionPane.showMessageDialog(null, "Username tidak ditemukan!");
    }
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    Depo2.setText("");
    Depo.setText("");
    }
    }

    @FXML
    private void buttonTotal(ActionEvent event) {
        
        try{
        String a1=awal.getText();
        String a2=Depo.getText();
        int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
        String sum1=String.valueOf(sum);
        Depo2.setText(sum1);
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }

    @FXML
    private void buttonSubmit(ActionEvent event) {
         Connection connection;
        PreparedStatement pst;
        String sql="SELECT * FROM `akun` WHERE nama=?";
    try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
    pst=connection.prepareStatement(sql);
    pst.setString(1, Nama.getText());
    rs = pst.executeQuery();
    if(rs.next()){
    String add1=rs.getString("alamat");
    alamat.setText(add1);
    String add2=rs.getString("norek");
    nomor.setText(add2);
    String add3=rs.getString("SALDO");
    saldo.setText(add3);
    
    }else{
    JOptionPane.showMessageDialog(null, "Username tidak ditemukan!");
    }
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
    }

    @FXML
    private void buttonCari(ActionEvent event) {
        Connection connection;
        PreparedStatement pst;
        String sql="SELECT * FROM `akun` WHERE nama=?";
    try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
    pst=connection.prepareStatement(sql);
    pst.setString(1, NICK.getText());
    rs = pst.executeQuery();
    if(rs.next()){
         
    String add1=rs.getString("norek");
    NOREK.setText(add1);
    String add2=rs.getString("saldo");
    SALDO.setText(add2);
    
    }else{
    JOptionPane.showMessageDialog(null, "Nickname tidak ditemukan!");
    }
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    NICK.setText("");
    NOREK.setText("");
    SALDO.setText("");
    }
    }

    @FXML
    private void buttonTransfer(ActionEvent event) {
        TransferC();
        TransferD();
    }
    public void TransferD(){
 Connection connection = null;
        PreparedStatement pst;
try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
String v1=NICK.getText();
String v2=TRANS2.getText();
String sql="UPDATE `akun` set `saldo`='"+v2+"' WHERE `nama`='"+v1+"'";
pst=connection.prepareStatement(sql);
pst.execute();
JOptionPane.showMessageDialog(null,"Successfuly Transfer!");
}catch(SQLException | HeadlessException e){
JOptionPane.showMessageDialog(null,"Successfuly Transfer!");
}
}
public void TransferC(){
     Connection connection = null;
        PreparedStatement pst;
try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
String v1=transferakun.getText();
String v2=akun2.getText();
String sql="UPDATE `akun` set `saldo`='"+v2+"' WHERE `norek`='"+v1+"'";
pst=connection.prepareStatement(sql);
pst.execute();
JOptionPane.showMessageDialog(null,"Successfuly Transfer!");
}catch(SQLException | HeadlessException e){
JOptionPane.showMessageDialog(null,"Successfuly Transfer!");
}
}
@FXML
    private void buttonTOTAL(ActionEvent event) {
        try{
        String a1=SALDO.getText();
        String a2=TRANS1.getText();
        int sum=Integer.parseInt(a1)-Integer.parseInt(a2);
        String sum1=String.valueOf(sum);
        TRANS2.setText(sum1);
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }

    @FXML
    private void buttonShow(ActionEvent event) throws SQLException {
         Connection connection;
        PreparedStatement pst;
        String sql="SELECT saldo FROM `akun` WHERE norek=?";
    try{
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ta", "root","");
    pst=connection.prepareStatement(sql);
    pst.setString(1, transferakun.getText());
    rs = pst.executeQuery();
    if(rs.next()){
         
 
    String add2=rs.getString("saldo");
    akun1.setText(add2);
    String a1=TRANS1.getText();
    String a2=akun1.getText();
    int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
    String sum1=String.valueOf(sum);
    akun2.setText(sum1);
    }else{
    JOptionPane.showMessageDialog(null, "Nickname tidak ditemukan!");
    }
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
    }

    @FXML
    private void buttonOut(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan Logout?");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk Logout, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
    ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),635 , 520);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Nasabah");
            stage.show();
    }
        else {
            alert.close();
        }
    }

    @FXML
    private void buttonout2(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan Logout?");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk Logout, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
    ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),635 , 520);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Nasabah");
            stage.show();
    }
        else {
            alert.close();
        }
    }

    @FXML
    private void buttonout3(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan Logout?");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk Logout, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
    ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("form.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),635 , 520);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Nasabah");
            stage.show();
    }
        else {
            alert.close();
        }
    }
    }


    


