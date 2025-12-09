package com.example.lab2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SAddController {
    private DiaryB diaryB;
    @FXML
    private TextField txtCouple;

    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtMonday;

    @FXML
    private TextField txtTuesday;
    @FXML
    private TextField txtWednesday;

    @FXML
    private TextField txtThursday;
    @FXML
    private TextField txtFriday;
    public DiaryB getDiaryB(){
        return diaryB;
    }
    public void setDiaryB(DiaryB diaryB){
        this.diaryB = diaryB;
        txtCouple.setText(diaryB.getCouple());
        txtTime.setText(diaryB.getTime());
        txtMonday.setText(diaryB.getMonday());
        txtTuesday.setText(diaryB.getTuesday());
        txtWednesday.setText(diaryB.getWednesday());
        txtThursday.setText(diaryB.getThursday());
        txtFriday.setText(diaryB.getFriday());
    }
    @FXML
    void  actionSave(ActionEvent event){
        diaryB.setCouple(txtCouple.getText());
        diaryB.setTime(txtTime.getText());
        diaryB.setMonday(txtMonday.getText());
        diaryB.setTuesday(txtTuesday.getText());
        diaryB.setWednesday(txtWednesday.getText());
        diaryB.setThursday(txtThursday.getText());
        diaryB.setFriday(txtFriday.getText());
        DB db = new DB(); // Або передати db у SAddController через setDB
        db.update(diaryB);
        actionClose(event);

    }
    @FXML
    void actionClose(ActionEvent event){
        Node source =(Node) event.getSource();
        Stage stage =(Stage) source.getScene().getWindow();
        stage.hide();;
    }
    private void openPage(ActionEvent event, String fxmlFile, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            Parent root = loader.load();
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.sizeToScene();
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    @FXML
//    void Yes(ActionEvent event) {
//        Button btn = (Button) event.getSource();
//        String fxmlFile = (String) btn.getUserData(); // читаємо userData
//        openPage(event, fxmlFile, "Повернутися до головного меню"); // можна додати title
//    }


    @FXML
    void goBack(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String fxmlFile = (String) btn.getUserData(); // читаємо userData
        openPage(event, fxmlFile, "Назад"); // можна додати title

}
}
