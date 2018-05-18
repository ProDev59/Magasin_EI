package vues;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.UserModel;

import java.io.IOException;

public class MainApp extends Application {

    public static Stage primaryStage;
    private AnchorPane anchorPaneLayout;
    private Scene scene;



    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        MainApp.primaryStage.setResizable(false);
            initShow();

    }

    public void initShow(){

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("mainView.fxml"));
            anchorPaneLayout = (AnchorPane) loader.load();

            scene = new Scene(anchorPaneLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Magasin EI");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void initStartShow(UserModel userModel){

        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("StartView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            StartController startController = loader.getController();
            startController.initChamps(userModel);


            primaryStage.getScene().setRoot(page);
            primaryStage.setTitle("Magasin EI");

            primaryStage.show();



        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void userShow(){

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("loginUserView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Connection");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LoginUserController loginUserController = loader.getController();
            loginUserController.setDialogue(dialogStage);

            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userInsertShow(){

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("insertUserView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Inscription");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            InsertUserController insertUserController = loader.getController();
            insertUserController.setDialogue(dialogStage);

            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
