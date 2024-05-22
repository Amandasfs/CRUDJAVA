package com.inss.teste.testecrud.controller;

import com.inss.teste.testecrud.config.Database;
import com.inss.teste.testecrud.config.DatabaseConfig;
import com.inss.teste.testecrud.dao.EstagiariasDAO;
import com.inss.teste.testecrud.model.Estagiarias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLVBoxMainController {

    @FXML
    private TableView<Estagiarias> tableEstagiarias;
    @FXML
    private TableColumn<Estagiarias, Integer> tableColumnEstagiariasMatricula;
    @FXML
    private TableColumn<Estagiarias, String> tableColumnEstagiariasNome;
    @FXML
    private TextField matricula;
    @FXML
    private TextField nome;
    @FXML
    private Button ButtonCad;
    @FXML
    private Button ButtonAlt;
    @FXML
    private Button ButtonDEL;
    @FXML
    private Text welcomeText;

    private List<Estagiarias> estagiariasList;
    private ObservableList<Estagiarias> observableList;

    //Atributos para manipulação de Banco de Dados
    Database database;
    private final Connection conn = database.connect();
    private final EstagiariasDAO dao = new EstagiariasDAO();

    public FXMLVBoxMainController() {
        super();
    }

    public void initialize(URL url, ResourceBundle rb){
        dao.setConn(conn);
        
    }
}
