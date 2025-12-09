package com.example.lab2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AddRController {
    private DiaryB diaryB;
    @FXML
    private TextField txtSubject;

//    @FXML
//    private TextField txtDate;
    @FXML
    private TextField txtTypeWork;

    @FXML
    private TextField txtRating;
    @FXML
    private TextField txtAbcde;
    @FXML
    private DatePicker datePicker;

    @FXML
    private Label dateLabel;

    public DiaryB getDiaryB(){
        return diaryB;
    }
    public void setDiaryB(DiaryB diaryB){
        this.diaryB = diaryB;
        txtSubject.setText(diaryB.getSubject());
        //txtDate.setText(diaryB.getDate());
        txtTypeWork.setText(diaryB.getTypeWork());
        txtRating.setText(diaryB.getRating());
        txtAbcde.setText(diaryB.getAbcde());
        if (diaryB.getDedlain() != null && !diaryB.getDedlain().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd"
                );
                LocalDate date = LocalDate.parse(diaryB.getDedlain(), formatter);
                datePicker.setValue(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
    @FXML
    void actionSave(ActionEvent event){
        diaryB.setSubject(txtSubject.getText());

        if (datePicker.getValue() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDate = datePicker.getValue().format(formatter);
            diaryB.setDate(formattedDate);
            diaryB.setDedlain(formattedDate);
        }

        diaryB.setTypeWork(txtTypeWork.getText());
        diaryB.setRating(txtRating.getText());
        diaryB.setAbcde(txtAbcde.getText());

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
    @FXML
    void getDate(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        if (date != null) {
            System.out.println(date.toString());
            dateLabel.setText(date.toString());
        }
    }
    private DB db;  // додати

    public void setDB(DB db) {  // додати
        this.db = db;
    }



//    @FXML
//    void goBack(ActionEvent event) {
//        Button btn = (Button) event.getSource();
//        String fxmlFile = (String) btn.getUserData(); // читаємо userData
//        openPage(event, fxmlFile, "Назад"); // можна додати title
//
//    }
}
