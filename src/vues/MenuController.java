package vues;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.UserModel;


import java.io.IOException;


public class MenuController {


    public static UserModel userModel;

    @FXML
    private MoteurController moteurController;
    @FXML
    private FusibleController fusibleController;


    public MenuController(){


    }



    @FXML
    AnchorPane anchorPane;

    @FXML
    Label nomLbl;

    @FXML
    Label prenomLbl;

    @FXML
    Label fonctionLbl;

    @FXML
    Label equipeLbl;

    @FXML
    Group moteurBtn;

    @FXML
    Group fusibleBtn;

    @FXML
    public void initialize(){

    }

    public void initChamps(UserModel userModel){

        nomLbl.setText(userModel.getNom().toUpperCase());
        prenomLbl.setText(userModel.getPrenom().toUpperCase());
        fonctionLbl.setText(userModel.getFonction().toUpperCase());
        equipeLbl.setText(userModel.getEquipe().toUpperCase());

    }

    @FXML
    public void handleMoteur(MouseEvent event){

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("moteurView.fxml"));
            anchorPane = (AnchorPane) loader.load();

            MoteurController moteurController = loader.getController();
            moteurController.initChamps();

            MainApp.primaryStage.getScene().setRoot(anchorPane);
            MainApp.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleFusible(MouseEvent event){

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("fusibleView.fxml"));
            anchorPane = (AnchorPane) loader.load();

            FusibleController fusibleController = loader.getController();
            fusibleController.initChamps();

            MainApp.primaryStage.getScene().setRoot(anchorPane);
            MainApp.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initUserModel(UserModel model){

        userModel = model;

    }


}