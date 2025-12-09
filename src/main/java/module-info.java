module com.example.lab2_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.lab2_2 to javafx.fxml;
    exports com.example.lab2_2;
}