package vues;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import model.UserModel;

public class StartController {


    @FXML
    private MenuController menuController;

    @FXML
    private Parent menu;


    public StartController(){

    }


    @FXML
    public void initialize(){



    }


    public void initChamps(UserModel userModel) {

        menuController.initUserModel(userModel);
        menuController.initChamps(userModel);

    }
}
