package com.example.lab2_2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private TableView<DiaryB> todayTable; // Таблиця на головній сторінці
    @FXML
    private TableColumn<DiaryB, String> todaySubject;
    @FXML
    private TableColumn<DiaryB, String> todayHW;
    @FXML
    private TableColumn<DiaryB, String> todayDedlain;
    @FXML
    private TableColumn<DiaryB, String> todayStatus;

    private DB db = new DB(); // Використовуємо ту ж базу, що і HWController

    @FXML
    public void initialize() {
        // Прив’язуємо колонки до полів DiaryB
        todaySubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        todayHW.setCellValueFactory(new PropertyValueFactory<>("homeWork"));
        todayDedlain.setCellValueFactory(new PropertyValueFactory<>("dedlain"));
        todayStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Встановлюємо підсвічування статусу
        todayStatus.setCellFactory(col -> {
            return new javafx.scene.control.cell.TextFieldTableCell<>() {
                {
                    itemProperty().addListener((obs, oldItem, newItem) -> {
                        if (newItem == null || newItem.isEmpty()) {
                            setStyle("");
                        } else {
                            String normalized = newItem.toLowerCase().trim();
                            if (normalized.contains("не виконано") || normalized.contains("not done")) {
                                setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
                            } else if (normalized.contains("виконано") || normalized.contains("done")) {
                                setStyle("-fx-background-color: #7CFC00; -fx-text-fill: black;");
                            } else {
                                setStyle("");
                            }
                        }
                    });
                }
            };
        });

        // Відображаємо тільки записи категорії "homework"
        refreshTodayTable();
    }

    private void refreshTodayTable() {
        ObservableList<DiaryB> homeworkList = db.getAll().filtered(diary ->
                "homework".equalsIgnoreCase(diary.getCategory())
        );
        todayTable.setItems(homeworkList);
    }

//    private DB db = new DB();
//
//    @FXML
//    private TableView<DiaryB> todayTable;
//    @FXML
//    private TableColumn<DiaryB, String> todaySubject;
//    @FXML
//    private TableColumn<DiaryB, String> todayHW;
//    @FXML
//    private TableColumn<DiaryB, String> todayStatus;
//
//    @FXML
//    public void initialize() {
//        if (todayTable == null || todaySubject == null || todayHW == null || todayStatus == null) {
//            System.out.println("ERROR: TableView або колонки не підключені!");
//            return;
//        }
//
//        todaySubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
//        todayHW.setCellValueFactory(new PropertyValueFactory<>("homeWork"));
//        todayStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
//
//        updateTodayTasks();
//        startDailyUpdater();
//    }
//
//    private void updateTodayTasks() {
//        LocalDate today = LocalDate.now();
//        ObservableList<DiaryB> allTasks = db.getAll();
//        if (allTasks == null) {
//            allTasks = FXCollections.observableArrayList();
//        }
//
//        FilteredList<DiaryB> todayTasks = new FilteredList<>(allTasks, diary ->
//                diary.getDedlainDate() != null && diary.getDedlainDate().equals(today)
//        );
//
//        todayTable.setItems(todayTasks);
//    }
//
//    private void startDailyUpdater() {
//        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), e -> updateTodayTasks()));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//


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
        }
    }

    @FXML
    void openShedulePageAfterMain(ActionEvent event) {
        openPage(event, "schedule.fxml", "Розклад");
    }

//    @FXML
//    void openMainAfterS(ActionEvent event) {
//        openPage(event, "main.fxml", "Назад");
//    }
   @FXML
   void goBack(ActionEvent event) {
    Button btn = (Button) event.getSource();
    String fxmlFile = (String) btn.getUserData(); // читаємо userData
    openPage(event, fxmlFile, "Назад"); // можна додати title
}
//
//    @FXML
//    void yesS(ActionEvent event) {
//        openPage(event, "yes.fxml", "Зберегти");
//    }
@FXML
void Yes(ActionEvent event) {
    Button btn = (Button) event.getSource();
    String fxmlFile = (String) btn.getUserData(); // читаємо userData
    openPage(event, fxmlFile, "Повернутися до головного меню"); // можна додати title
}


    @FXML
    void openMainPageAfterYes(ActionEvent event) {
        openPage(event, "main.fxml", "Повернутися до головного меню");
    }
    @FXML
    void openHWPage(ActionEvent event){
        openPage(event,"HW.fxml","Домашнє завдання");
    }
    @FXML
    void openRatingPageAfterMain(ActionEvent event){
        openPage(event,"rating.fxml","Оцінки");
    }
    @FXML
    void openVisitingPageAfterMain(ActionEvent event){
        openPage(event,"visiting.fxml","Відвідування");
    }
    @FXML
    void Status(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String fxmlFile = (String) btn.getUserData(); // читаємо userData
        openPage(event, fxmlFile, "Статус"); // можна додати title
    }


}
