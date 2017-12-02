
package bankrupt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author kevin
 */
public class Data {
    private SimpleStringProperty norek, nm, pass, saldo,alamat,tgl,lk,perempuan;
    

    public Data(String Kode, String Nama, String Pass, String Saldo,String Alamat,String Tanggal,String Laki,String Perempuan) {
        this.norek = new SimpleStringProperty(Kode);
        this.nm = new SimpleStringProperty(Nama);
        this.pass = new SimpleStringProperty(Pass);
        this.saldo = new SimpleStringProperty(Saldo);
        this.alamat = new SimpleStringProperty(Alamat);
        this.tgl = new SimpleStringProperty(Tanggal);
        this.lk = new SimpleStringProperty(Laki);
        this.perempuan = new SimpleStringProperty(Perempuan);
        
    }

    Data() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getKode() {
        return norek.get();
    }

    public void setKode(String Kode) {
        this.norek = new SimpleStringProperty(Kode);
    }

    public String getNama() { 
        return nm.get();
    }

    public void setNama(String Nama) {
        this.nm = new SimpleStringProperty(Nama);
    }

    public String getPass() {
        return pass.get();
    }

    public void setPass(String Pass) {
        this.pass = new SimpleStringProperty(Pass);
    }

    public String getSaldo() {
        return saldo.get();
    }

    public void setSaldo(String Saldo) {
        this.alamat = new SimpleStringProperty(Saldo);
    }
    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String Alamat) {
        this.alamat = new SimpleStringProperty(Alamat);
    }
    public String getTanggal() {
        return tgl.get();
    }

    public void setTanggal(String Tanggal) {
        this.tgl = new SimpleStringProperty(Tanggal);
    }
   
}
