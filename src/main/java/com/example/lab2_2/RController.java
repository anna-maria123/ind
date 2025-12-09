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

public class RController {

    private DB db = new DB();

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<DiaryB> diaryTable;
    @FXML
    private TableColumn<DiaryB, String> columnSubject;
    @FXML
    private TableColumn<DiaryB, String> columnDate;
    @FXML
    private TableColumn<DiaryB, String> columnTypeWork;
    @FXML
    private TableColumn<DiaryB, String> columnRating;
    @FXML
    private TableColumn<DiaryB, String> columnAbcde;

    @FXML
    public void initialize() {
        diaryTable.setEditable(true);

        columnSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        //columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnDate.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDate.setOnEditCommit(event -> {
            event.getRowValue().setDate(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnTypeWork.setCellValueFactory(new PropertyValueFactory<>("typeWork"));
        columnRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        columnAbcde.setCellValueFactory(new PropertyValueFactory<>("abcde"));

        columnSubject.setCellFactory(TextFieldTableCell.forTableColumn());
       // columnDate.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTypeWork.setCellFactory(TextFieldTableCell.forTableColumn());
        columnRating.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAbcde.setCellFactory(TextFieldTableCell.forTableColumn());
        columnRating.setCellFactory(col -> {
            TextFieldTableCell<DiaryB, String> cell = new TextFieldTableCell<>();
            cell.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (newItem == null || newItem.isEmpty()) {
                    cell.setStyle("");
                } else {
                    try {
                        int rating = Integer.parseInt(newItem.trim()); // конвертуємо в число
                        if (rating <= 2) {
                            cell.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;"); // червоний
                        } else if (rating > 2 && rating < 4) {
                            cell.setStyle("-fx-background-color: #FFA500; -fx-text-fill: black;"); // оранжевий
                        } else if (rating == 4) {
                                cell.setStyle("-fx-background-color: #FFFF00; -fx-text-fill: black;"); // оранжевий
                        } else if (rating == 5) {
                            cell.setStyle("-fx-background-color: #7CFC00; -fx-text-fill: black;"); // зелений
                        } else {
                            cell.setStyle(""); // якщо інші значення
                        }
                    } catch (NumberFormatException e) {
                        cell.setStyle(""); // якщо не число
                    }
                }
            });
            return cell;
        });
        columnAbcde.setCellFactory(col -> {
            TextFieldTableCell<DiaryB, String> cell = new TextFieldTableCell<>();
            cell.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (newItem == null || newItem.isEmpty()) {
                    cell.setStyle("");
                } else {
                    String normalized = newItem.toUpperCase().trim(); // приводимо до верхнього регістру
                    switch (normalized) {
                        case "F":
                            cell.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;"); // червоний
                            break;
                        case "E":
                        case "D":
                            cell.setStyle("-fx-background-color: #FFA500; -fx-text-fill: black;"); // оранжевий
                            break;
                        case "C":
                        case "B":
                            cell.setStyle("-fx-background-color: #FFFF00; -fx-text-fill: black;"); // жовтий
                            break;
                        case "A":
                            cell.setStyle("-fx-background-color: #7CFC00; -fx-text-fill: black;"); // зелений
                            break;
                        default:
                            cell.setStyle(""); // для інших значень
                    }
                }
            });
            return cell;
        });




        columnSubject.setOnEditCommit(event -> {
            event.getRowValue().setSubject(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnDate.setOnEditCommit(event -> {
            event.getRowValue().setDate(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnTypeWork.setOnEditCommit(event -> {
            event.getRowValue().setTypeWork(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnRating.setOnEditCommit(event -> {
            event.getRowValue().setRating(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnAbcde.setOnEditCommit(event -> {
            event.getRowValue().setAbcde(event.getNewValue());
            db.update(event.getRowValue());
        });

        refreshTable();

        db.getAll().addListener((ListChangeListener<DiaryB>) change -> refreshTable());
    }

    public void showDialog(DiaryB diaryB, Stage owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addR.fxml"));
            Parent root = loader.load();
            AddRController controller = loader.getController();
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
                DiaryB newDiary = new DiaryB("", "", "", 0, ""); // категорія "rating"
                newDiary.setCategory("rating");
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
                        "rating".equalsIgnoreCase(diary.getCategory()) && (
                                diary.getSubject().toLowerCase().contains(query) ||
                                        diary.getDate().toLowerCase().contains(query) ||
                                        diary.getTypeWork().toLowerCase().contains(query) ||
                                        diary.getRating().toLowerCase().contains(query) ||
                                        diary.getAbcde().toLowerCase().contains(query)
                        ));
                diaryTable.setItems(filtered);
                break;

            case "refresh":
                refreshTable();
                txtSearch.clear();
                break;
        }
    }

    private void refreshTable() {
        ObservableList<DiaryB> ratingList = db.getAll().filtered(diary ->
                "rating".equalsIgnoreCase(diary.getCategory())
        );
        diaryTable.setItems(ratingList);
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
