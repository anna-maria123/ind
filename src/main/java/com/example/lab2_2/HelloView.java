package com.example.lab2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloView {
    private void openPage(ActionEvent event, String fxmlFile, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    @FXML
    void openMainPage(ActionEvent event) {
        openPage(event, "main.fxml", "Перейти до головного меню");
    }

}
