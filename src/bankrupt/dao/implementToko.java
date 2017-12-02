/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankrupt.dao;
import java.util.List;
import bankrupt.Data;
/**
 *
 * @author SMK TELKOM
 */
public interface implementToko {
    public void TampilData(Data a);
    public void UbahData(Data a);
    public void SimpanData(Data a);
    public void HapusData(String kode);
    public String user = "";
}
