package vues;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


public class MainController {


    private MainApp mainApp = new MainApp();


    @FXML
    private void initialize() {

    }


    @FXML
    public void handelClic(MouseEvent mouseEvent) {
        mainApp.userShow();
    }


}
