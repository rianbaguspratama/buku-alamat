package Bukualamat;

import Bukualamat.View.ViewBukuAlamatController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BukuAlamat extends Application {
    // Variable Kelas
    private Stage stageAplikasi;
    private BorderPane rootAplikasi;
    
    private ObservableList<DataPersonal> dataperson = FXCollections.observableArrayList();
    
    public BukuAlamat() {
        dataperson.add(new DataPersonal("Budi","Santoso"));
        dataperson.add(new DataPersonal("Ahmad","Dahlan"));
        dataperson.add(new DataPersonal("Hasyim","Asy'ari"));
        dataperson.add(new DataPersonal("Anies","Baswedan"));
        dataperson.add(new DataPersonal("Ridwan","Kamil"));
    }
    
    public ObservableList<DataPersonal> getDataPersonal() {
        return dataperson;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.stageAplikasi = primaryStage;
        this.stageAplikasi.setTitle("Buku Alamat");
    
        initGUIKerangka();
        initViewBukuAlamat();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void initGUIKerangka() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BukuAlamat.class.getResource("View/GUIKerangka.fxml"));
            rootAplikasi = (BorderPane)loader.load();
            
            Scene sceneAplikasi = new Scene(rootAplikasi);
            stageAplikasi.setScene(sceneAplikasi);
            stageAplikasi.setResizable(false);
            stageAplikasi.show();
        } catch (IOException ex) {
            Logger.getLogger(BukuAlamat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initViewBukuAlamat() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BukuAlamat.class.getResource("View/ViewBukuAlamat.fxml"));
            AnchorPane guiIsi = (AnchorPane)loader.load();
            rootAplikasi.setCenter(guiIsi);
            
            ViewBukuAlamatController kontroller = loader.getController();
            kontroller.setKelasUtama(this);
            
        } catch (IOException ex) {
            Logger.getLogger(BukuAlamat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
