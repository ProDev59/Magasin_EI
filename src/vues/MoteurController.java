package vues;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MoteurController {


    @FXML
    private MenuController menuController;

    @FXML
    private Parent menu;




    public void initChamps() {
        menuController.initChamps(MenuController.userModel);
        menuController.moteurBtn.setDisable(true);
    }

}
