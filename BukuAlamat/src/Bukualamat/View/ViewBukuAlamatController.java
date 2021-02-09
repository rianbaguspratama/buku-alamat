package Bukualamat.View;

import Bukualamat.BukuAlamat;
import Bukualamat.DataPersonal;
import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewBukuAlamatController implements Initializable {

    @FXML
    private TableView<DataPersonal> tabelPerson;
    @FXML
    private TableColumn<DataPersonal, String> kolomNmDepan;
    @FXML
    private TableColumn<DataPersonal, String> kolomNmBelakang;
    @FXML
    private Label labelNmDepan;
    @FXML
    private Label labelNmBelakang;
    @FXML
    private Label labelAlamat;
    @FXML
    private Label labelKotaKab;
    @FXML
    private Label labelNoHp;

    private BukuAlamat kelasUtama;
    
    public ViewBukuAlamatController() {
        
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        kolomNmDepan.setCellValueFactory(celldata->celldata.getValue().namadepanProperty());
        kolomNmBelakang.setCellValueFactory(celldata->celldata.getValue().namabelakangProperty());
        
        viewDetail(null);
        
        tabelPerson.getSelectionModel().selectedItemProperty().addListener((observable,personlama,personbaru) -> viewDetail(personbaru));
    }    
    
    public void setKelasUtama(BukuAlamat bukualamat) {
        this.kelasUtama = bukualamat;
        
        tabelPerson.setItems(kelasUtama.getDataPersonal());
    }
    
    private void viewDetail(DataPersonal dataPerson ) {
        if(dataPerson != null) {
            labelNmDepan.setText(dataPerson.getNamadepan());
            labelNmBelakang.setText(dataPerson.getNamabelakang());
            labelAlamat.setText(dataPerson.getAlamat());
            labelKotaKab.setText(dataPerson.getKotakabupaten());
            labelNoHp.setText(dataPerson.getNohp());
        } else {
            labelNmDepan.setText("");
            labelNmBelakang.setText("");
            labelAlamat.setText("");
            labelKotaKab.setText("");
            labelNoHp.setText("");
        }
    }
    
}
