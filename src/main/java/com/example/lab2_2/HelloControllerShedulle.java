package com.example.lab2_2;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerShedulle {

    private DB db = new DB();

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<DiaryB> diaryTable;
    @FXML
    private TableColumn<DiaryB, String> columnCouple;
    @FXML
    private TableColumn<DiaryB, String> columnTime;
    @FXML
    private TableColumn<DiaryB, String> columnMonday;
    @FXML
    private TableColumn<DiaryB, String> columnTuesday;
    @FXML
    private TableColumn<DiaryB, String> columnWednesday;
    @FXML
    private TableColumn<DiaryB, String> columnThursday;
    @FXML
    private TableColumn<DiaryB, String> columnFriday;

    @FXML
    public void initialize() {
        diaryTable.setEditable(true);

        columnCouple.setCellValueFactory(new PropertyValueFactory<>("couple"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        columnMonday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        columnTuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        columnWednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        columnThursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        columnFriday.setCellValueFactory(new PropertyValueFactory<>("friday"));

        columnCouple.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTime.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMonday.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTuesday.setCellFactory(TextFieldTableCell.forTableColumn());
        columnWednesday.setCellFactory(TextFieldTableCell.forTableColumn());
        columnThursday.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFriday.setCellFactory(TextFieldTableCell.forTableColumn());

        columnCouple.setOnEditCommit(event -> {
            event.getRowValue().setCouple(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnTime.setOnEditCommit(event -> {
            event.getRowValue().setTime(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnMonday.setOnEditCommit(event -> {
            event.getRowValue().setMonday(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnTuesday.setOnEditCommit(event -> {
            event.getRowValue().setTuesday(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnWednesday.setOnEditCommit(event -> {
            event.getRowValue().setWednesday(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnThursday.setOnEditCommit(event -> {
            event.getRowValue().setThursday(event.getNewValue());
            db.update(event.getRowValue());
        });
        columnFriday.setOnEditCommit(event -> {
            event.getRowValue().setFriday(event.getNewValue());
            db.update(event.getRowValue());
        });

        refreshTable();

        db.getAll().addListener((ListChangeListener<DiaryB>) change -> refreshTable());
    }

    public void showDialog(DiaryB diaryB, Stage owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addS.fxml"));
            Parent root = loader.load();
            SAddController controller = loader.getController();
            controller.setDiaryB(diaryB);

            Stage editDialogStage = new Stage();
            editDialogStage.setTitle("Вікно редагування");
            editDialogStage.setScene(new Scene(root));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(owner);
            editDialogStage.setMaximized(true);
            editDialogStage.setResizable(true);
            editDialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openWindow(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        Stage stage = (Stage) clickedButton.getScene().getWindow();

        switch (clickedButton.getId()) {
            case "bthAdd":
                DiaryB newDiary = new DiaryB("", "", "", "", "", "", "");
                newDiary.setCategory("schedule");
                showDialog(newDiary, stage);
                db.add(newDiary);
                refreshTable();
                break;

            case "bthEdit":
                DiaryB selected = diaryTable.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    showDialog(selected, stage);
                    diaryTable.refresh();
                } else showAlert("Будь ласка, оберіть запис для редагування.");
                break;

            case "bthDelete":
                DiaryB toDelete = diaryTable.getSelectionModel().getSelectedItem();
                if (toDelete != null) {
                    db.delete(toDelete);
                    refreshTable();
                } else showAlert("Будь ласка, оберіть запис для видалення.");
                break;

            case "search":
                String query = txtSearch.getText().trim().toLowerCase();
                ObservableList<DiaryB> filtered = db.getAll().filtered(diary ->
                        "schedule".equalsIgnoreCase(diary.getCategory()) &&
                                (diary.getCouple().toLowerCase().contains(query)
                                        || diary.getTime().toLowerCase().contains(query)
                                        || diary.getMonday().toLowerCase().contains(query)
                                        || diary.getTuesday().toLowerCase().contains(query)
                                        || diary.getWednesday().toLowerCase().contains(query)
                                        || diary.getThursday().toLowerCase().contains(query)
                                        || diary.getFriday().toLowerCase().contains(query))
                );
                diaryTable.setItems(filtered);
                break;

            case "refresh":
                refreshTable();
                txtSearch.clear();
                break;
        }
    }

    private void refreshTable() {
        ObservableList<DiaryB> scheduleList = db.getAll().filtered(diary ->
                "schedule".equalsIgnoreCase(diary.getCategory())
        );
        diaryTable.setItems(scheduleList);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Інформація");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void openPage(ActionEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.sizeToScene();
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
