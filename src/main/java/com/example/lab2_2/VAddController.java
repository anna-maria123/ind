package com.example.lab2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VAddController {
    private DiaryB diaryB;
    private DB db; // додаємо DB, щоб працювало з оновленням

    @FXML
    private TextField txtSubject;

    @FXML
    private DatePicker datePicker; // замість txtDate
    @FXML
    private TextField txtWorking;

    @FXML
    private TextField txtStatus;
    @FXML
    private TextField txtTypeWork;

    public void setDB(DB db) {
        this.db = db;
    }

    public DiaryB getDiaryB(){
        return diaryB;
    }

    public void setDiaryB(DiaryB diaryB){
        this.diaryB = diaryB;
        txtSubject.setText(diaryB.getSubject());
        txtWorking.setText(diaryB.getWorking());
        txtStatus.setText(diaryB.getStatus());
        txtTypeWork.setText(diaryB.getTypeWork());

        // Встановлюємо дату в DatePicker
        if (diaryB.getDate() != null && !diaryB.getDate().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.parse(diaryB.getDate(), formatter);
                datePicker.setValue(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void actionSave(ActionEvent event){
        diaryB.setSubject(txtSubject.getText());
        diaryB.setWorking(txtWorking.getText());
        diaryB.setStatus(txtStatus.getText());
        diaryB.setTypeWork(txtTypeWork.getText());

        // Зберігаємо дату у форматі dd.MM.yyyy
        if (datePicker.getValue() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = datePicker.getValue().format(formatter);
            diaryB.setDate(formattedDate);
        }

        if (db != null) {
            if (diaryB.getId() == 0) {
                db.add(diaryB);
            } else {
                db.update(diaryB);
            }
        }

        actionClose(event);
    }

    @FXML
    void actionClose(ActionEvent event){
        Node source =(Node) event.getSource();
        Stage stage =(Stage) source.getScene().getWindow();
        stage.hide();
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

    @FXML
    void goBack(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String fxmlFile = (String) btn.getUserData();
        openPage(event, fxmlFile, "Назад");
    }
}
