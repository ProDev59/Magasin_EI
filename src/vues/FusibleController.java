package vues;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;


public class FusibleController {


    public FusibleController(){

    }


    @FXML
    private MenuController menuController;

    @FXML
    private Parent menu;


    @FXML
    public void handelRechercherFuse(MouseEvent event){

    }

    @FXML
    public void handelInsertFuse(MouseEvent event){


            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("fusibleViewInsert.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                Stage dialogStage = new Stage();
                dialogStage.setTitle("Article insertion");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(MainApp.primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                FusibleControllerInsert fusibleControllerInsert = loader.getController();
                fusibleControllerInsert.setDialogue(dialogStage);

                dialogStage.showAndWait();


            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    @FXML
    public void handelSupprimerFuse(MouseEvent event){

    }


    public void initChamps() {
        menuController.initChamps(MenuController.userModel);
        menuController.fusibleBtn.setDisable(true);
    }


}
