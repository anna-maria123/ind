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

public class HWAddController {

    private DiaryB diaryB;

    @FXML
    private TextField txtSubject;

    @FXML
    private TextField txtHomeWork;

    @FXML
    private TextField txtStatus;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label dateLabel;

    public DiaryB getDiaryB() {
        return diaryB;
    }

    public void setDiaryB(DiaryB diaryB) {
        this.diaryB = diaryB;

        txtSubject.setText(diaryB.getSubject());
        txtHomeWork.setText(diaryB.getHomeWork());
        txtStatus.setText(diaryB.getStatus());

        if (diaryB.getDedlain() != null && !diaryB.getDedlain().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                        "d MMMM yyyy",
                        new Locale("uk", "UA")
                );

                LocalDate date = LocalDate.parse(
                        diaryB.getDedlain().toLowerCase(),
                        formatter
                );

                datePicker.setValue(date);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void actionSave(ActionEvent event) {
        diaryB.setSubject(txtSubject.getText());
        diaryB.setHomeWork(txtHomeWork.getText());

        if (datePicker.getValue() != null) {
            diaryB.setDedlain(datePicker.getValue().toString());
        }

        diaryB.setStatus(txtStatus.getText());

        DB db = new DB();
        db.update(diaryB);

        actionClose(event);
    }

    @FXML
    void actionClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    private void openPage(ActionEvent event, String fxmlFile, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            Parent root = loader.load();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
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
}
