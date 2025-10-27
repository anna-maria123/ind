package com.example.lab2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    //1 сторінка
    @FXML
    private Button mainMenu;

    @FXML
     void openMainPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));

        try{
            Parent root = loader.load();
            Stage stage =(Stage) mainMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Перейти до головного меню");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }



    //Відкрити розклад
     @FXML
     private Button shedule;

    @FXML
    void openShedulePageAfterMain(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("schedule.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) shedule.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Розклад");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Додати розклад
    @FXML
    private Button addS;

    @FXML
    void openAddS(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addS.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) addS.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Додати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Редагувати розклад
    @FXML
    private Button editS;

    @FXML
    void openEditS(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addS.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) editS.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Редагувати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Видалити розклад
    @FXML
    private Button deleteS;
    @FXML
    void openDeleteS(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addS.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) deleteS.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Видалити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Кнопка Назад (розклад)
    @FXML
    private Button returnMain;

    @FXML
    void openMainAfterS(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) returnMain.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Назад");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до розкладу
    @FXML
    private Button cancelS;

    @FXML
    void openSPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("schedule.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelS.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так(розклад)
    @FXML
    private Button ok;

    @FXML
    void yesS(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) ok.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }




    //Кнопка повернутися до головного меню
    @FXML
    private Button returnMainMenu;

    @FXML
    void openMainPageAfterYes(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));

        try{
            Parent root = loader.load();
            Stage stage =(Stage) returnMainMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Повернутися до головного меню");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }




    //Відкрити HW
    @FXML
    private Button HW;
    @FXML
    void openHWPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HW.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) HW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Домашні завдання");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Додати HW
    @FXML
    private Button HWadd;

    @FXML
    void openHWAddPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HWadd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) HWadd.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Додати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //HWstatus
    @FXML
    private Button HWstatus;

    @FXML
    void openHWStatusPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HWstatus.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) HWstatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Статус");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Видалити HW
    @FXML
    private Button deleteHW;

    @FXML
    void openDeleteHW(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HWadd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) deleteHW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Видалити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Редагувати HW
    @FXML
    private Button editHW;

    @FXML
    void openEditHW(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HWadd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) editHW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Редагувати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Кнопка Назад (HW)
    @FXML
    private Button returnMainHW;

    @FXML
    void openMainAfterHW(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) returnMainHW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Назад");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до домашнього
    @FXML
    private Button cancelHW;

    @FXML
    void openHW(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HW.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelHW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так після HW
    @FXML
    private Button okHW;

    @FXML
    void yesHW(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) okHW.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до домашнього після статусу
    @FXML
    private Button cancelHWAfterStatus;

    @FXML
    void openHWAfterStatus(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("HW.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelHWAfterStatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так після HWStatus
    @FXML
    private Button okHWStatus;

    @FXML
    void yesHWStatus(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) okHWStatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }






    //Перейти до відвідування
    @FXML
    private Button visiting;

    @FXML
    void openVisitingPageAfterMain(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visiting.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) visiting.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відвідування");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Додати відвідування
    @FXML
    private Button visitingadd;

    @FXML
    void openVisitingAddPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visitingAdd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) visitingadd.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Додати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відвідування статус
    @FXML
    private Button visitingStatus;

    @FXML
    void openVisitingStatusPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visitingStatus.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) visitingStatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Статус");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Видалити відвідування
    @FXML
    private Button deleteVisiting;

    @FXML
    void openDeleteVisiting(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visitingAdd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) deleteVisiting.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Видалити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Редагувати відвідування
    @FXML
    private Button editVisiting;

    @FXML
    void openEditVisiting(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visitingAdd.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) editVisiting.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Редагувати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Кнопка Назад(visiting)
    @FXML
    private Button returnMainVisiting;

    @FXML
    void openMainAfterVisiting(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) returnMainVisiting.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Назад");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до відвідування
    @FXML
    private Button cancelV;

    @FXML
    void openVPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visiting.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelV.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так після відвідування
    @FXML
    private Button okV;

    @FXML
    void yesV(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) okV.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до відвідування після статусу
    @FXML
    private Button cancelVAfterStatus;

    @FXML
    void openVAfterStatus(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("visiting.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelVAfterStatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так після VStatus
    @FXML
    private Button okVStatus;

    @FXML
    void yesVStatus(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) okVStatus.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }





    //Відкрити оцінки
    @FXML
    private Button rating;

    @FXML
    void openRatingPageAfterMain(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("rating.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) rating.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Оцінки");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Додати оцінки
    @FXML
    private Button addR;

    @FXML
    void openAddR(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addR.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) addR.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Додати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Редагувати оцінки
    @FXML
    private Button editR;

    @FXML
    void openEditR(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addR.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) editR.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Редагувати");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Видалити оцінки
    @FXML
    private Button deleteR;
    @FXML
    void openDeleteR(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("addR.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) deleteR.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Видалити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Кнопка Назад (оцінки)
    @FXML
    private Button returnMainRating;

    @FXML
    void openMainAfterR(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("main.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) returnMainRating.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Назад");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Відмінити і повернутися до оцінок
    @FXML
    private Button cancelR;

    @FXML
    void openRPage(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("rating.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) cancelR.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Відмінити");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    //Перейти до сторінки так(оцінки)
    @FXML
    private Button okR;

    @FXML
    void yesR(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("yes.fxml"));
        try{
            Parent root = loader.load();
            Stage stage =(Stage) okR.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Зберегти");
            stage.sizeToScene();
            stage.setResizable(true);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }


    }













}