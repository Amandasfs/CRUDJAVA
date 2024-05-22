module com.inss.teste.testecrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens com.inss.teste.testecrud to javafx.fxml;
    exports com.inss.teste.testecrud;
    exports com.inss.teste.testecrud.controller;
    opens com.inss.teste.testecrud.controller to javafx.fxml;
}