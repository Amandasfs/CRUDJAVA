package com.inss.teste.testecrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("FXMLVBoxMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 580);
        stage.setTitle("Cadastro de Estagiárias");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}