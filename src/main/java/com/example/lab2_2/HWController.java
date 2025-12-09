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

public class HWController {

    private DB db = new DB();
    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<DiaryB> diaryTable;
    @FXML
    private TableColumn<DiaryB, String> columnSubject;
    @FXML
    private TableColumn<DiaryB, String> columnHW;
    @FXML
    private TableColumn<DiaryB, String> columnDedlain;
    @FXML
    private TableColumn<DiaryB, String> columnStatus;

    @FXML
    public void initialize() {
        diaryTable.setEditable(true);

        columnSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        columnHW.setCellValueFactory(new PropertyValueFactory<>("homeWork"));
        columnDedlain.setCellValueFactory(new PropertyValueFactory<>("dedlain"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        columnSubject.setCellFactory(TextFieldTableCell.forTableColumn());
        columnHW.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDedlain.setCellFactory(TextFieldTableCell.forTableColumn());

        columnStatus.setCellFactory(col -> {
            TextFieldTableCell<DiaryB, String> cell = new TextFieldTableCell<>();
            cell.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (newItem == null || newItem.isEmpty()) {
                    cell.setStyle("");
                } else {
                    String normalized = newItem.toLowerCase().trim();
                    if (normalized.contains("не виконано") || normalized.contains("not done")) {
                        cell.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
                    } else if (normalized.contains("виконано") || normalized.contains("done")) {
                        cell.setStyle("-fx-background-color: #7CFC00; -fx-text-fill: black;");
                    } else {
                        cell.setStyle("");
                    }
                }
            });
            return cell;
        });

        columnSubject.setOnEditCommit(event -> {
            event.getRowValue().setSubject(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnHW.setOnEditCommit(event -> {
            event.getRowValue().setHomeWork(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnDedlain.setOnEditCommit(event -> {
            event.getRowValue().setDedlain(event.getNewValue());
            db.update(event.getRowValue());
        });

        columnStatus.setOnEditCommit(event -> {
            event.getRowValue().setStatus(event.getNewValue());
            db.update(event.getRowValue());
        });

        // Відображаємо тільки записи категорії "homework"
        ObservableList<DiaryB> homeworkList = db.getAll().filtered(diary ->
                "homework".equalsIgnoreCase(diary.getCategory())
        );
        diaryTable.setItems(homeworkList);

        db.getAll().addListener((ListChangeListener<DiaryB>) change -> {
            // можна оновлювати лічильник рядків
        });
    }

    public void showDialog(DiaryB diaryB, Stage owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HWadd.fxml"));
            Parent root = loader.load();
            HWAddController controller = loader.getController();
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
//            case "bthAdd":
//                DiaryB newDiary = new DiaryB("", "", "", "homework"); // категорія "homework"
//                showDialog(newDiary, stage);
//                db.add(newDiary);
//                refreshTable();
//                break;
            case "bthAdd":
                DiaryB newDiary = new DiaryB("", "", "", ""); // status за замовчуванням
                newDiary.setCategory("homework");
                showDialog(newDiary, stage);
                db.add(newDiary);
                refreshTable();
                break;


            case "bthEdit":
                DiaryB selected = diaryTable.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    showDialog(selected, stage);
                    diaryTable.refresh();
                } else {
                    showAlert("Будь ласка, оберіть запис для редагування.");
                }
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
                        "homework".equalsIgnoreCase(diary.getCategory()) && (
                                diary.getSubject().toLowerCase().contains(query) ||
                                        diary.getHomeWork().toLowerCase().contains(query) ||
                                        diary.getDedlain().toLowerCase().contains(query) ||
                                        diary.getStatus().toLowerCase().contains(query)
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
        ObservableList<DiaryB> homeworkList = db.getAll().filtered(diary ->
                "homework".equalsIgnoreCase(diary.getCategory())
        );
        diaryTable.setItems(homeworkList);
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
