package vues;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserModel;
import model.UsersData;

import java.sql.SQLException;


public class InsertUserController {

    ObservableList<String> itemsFunction = FXCollections.observableArrayList("MOP", "PMP", "RTO", "TO" ,"CDP", "Adj CDP", "LT", "EI");
    ObservableList<String> itemsEquipe = FXCollections.observableArrayList("EQ1", "EQ2", "EQ3", "EQ4", "EQ5", "JOUR");

    private Stage dialogue;
    private String fonction = "", equipe = "";
    private boolean valideMdp = true;


    @FXML
    Label errorLbl;

    @FXML
    Label nomLbl;

    @FXML
    Label prenomLbl;

    @FXML
    Label fonctionLbl;

    @FXML
    Label equipeLbl;

    @FXML
    Label mdpLbl;

    @FXML
    Label mdpConfLbl;

    @FXML
    TextField nomTxt;

    @FXML
    TextField prenomTxt;

    @FXML
    ComboBox fonctionCbo;

    @FXML
    ComboBox equipeCbo;

    @FXML
    TextField mdpTxt;

    @FXML
    TextField mdpConfTxt;


    public InsertUserController(){

    }

    @FXML
    public void initialize(){

        fonctionCbo.setItems(itemsFunction);
        equipeCbo.setItems(itemsEquipe);

        fonctionCbo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                errorLbl.setText("");
                fonctionLbl.setStyle("-fx-text-fill: black;");
                fonctionCbo.setStyle("-fx-border-color: null;");

                fonction = (String) newValue;
            }
        });

        equipeCbo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                errorLbl.setText("");
                equipeLbl.setStyle("-fx-text-fill: black;");
                equipeCbo.setStyle("-fx-border-color: null;");

                equipe = (String) newValue;
            }
        });

        nomTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    nomTxt.setText("");
                    errorLbl.setText("");
                    nomTxt.setStyle("-fx-border-color: null;");
                    nomLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        prenomTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    prenomTxt.setText("");
                    errorLbl.setText("");
                    prenomTxt.setStyle("-fx-border-color: null;");
                    prenomLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        mdpTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    mdpTxt.setText("");
                    errorLbl.setText("");
                    mdpTxt.setStyle("-fx-border-color: null;");
                    mdpLbl.setStyle("-fx-text-fill: black;");

                    if(!valideMdp){

                        mdpConfTxt.setText("");
                        errorLbl.setText("");
                        mdpConfTxt.setStyle("-fx-border-color: null;");
                        mdpConfLbl.setStyle("-fx-text-fill: black;");

                    }

                }
            }
        });

        mdpConfTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    mdpConfTxt.setText("");
                    errorLbl.setText("");
                    mdpConfTxt.setStyle("-fx-border-color: null;");
                    mdpConfLbl.setStyle("-fx-text-fill: black;");

                    if(!valideMdp){

                        mdpTxt.setText("");
                        errorLbl.setText("");
                        mdpTxt.setStyle("-fx-border-color: null;");
                        mdpLbl.setStyle("-fx-text-fill: black;");

                    }

                }
            }
        });

    }

    @FXML
    public void handelQuitter(ActionEvent event){

        this.dialogue.close();

    }

    @FXML
    public void handelValider(ActionEvent event){

        if (verifChamps() && verifMdp()){

            UserModel userModel = new UserModel(nomTxt.getText(), prenomTxt.getText(), fonction, equipe, mdpTxt.getText(), mdpConfTxt.getText());

            UsersData usersData = new UsersData();

            try {

                if(!usersData.tableExiste()){

                    usersData.createTable();
                    usersData.insert(userModel);

                }else {
                    if(!usersData.isUserExiste(userModel.getNom(), userModel.getPrenom(), userModel.getFonction(), userModel.getEquipe())){

                        usersData.insert(userModel);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("INFORMATION");
                        alert.setHeaderText(null);
                        alert.setContentText("Votre compte a bien était crée !!!");

                        alert.showAndWait();

                    }else{
                        //Alert
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERREUR");
                        alert.setHeaderText(null);
                        alert.setContentText("Ce compte est déja utilisé veuillez vous connecter, ou crée un autre compte !!!");

                        alert.showAndWait();

                    }

                }

            } catch (SQLException e) {
                //e.printStackTrace();
                e.getMessage();
            }

            this.dialogue.close();

        }
    }

    public boolean verifChamps(){

        if(!nomTxt.getText().equals("") && !prenomTxt.getText().equals("") && !fonctionCbo.getItems().equals("") && !equipeCbo.getItems().equals("") && !mdpTxt.getText().equals("") && !mdpConfTxt.getText().equals("")){
            return true;
        }else{
            errorChamps();
            return false;
        }

    }

    public boolean verifMdp(){

        if(mdpTxt.getText().equals(mdpConfTxt.getText())){

            return true;

        }else {

            valideMdp = false;

            errorLbl.setText("Les Mots de passe ne sont pas identiques !");

            mdpConfLbl.setStyle("-fx-text-fill: red;");;
            mdpConfTxt.setStyle("-fx-text-fill: red;");

            mdpLbl.setStyle("-fx-text-fill: red;");;
            mdpTxt.setStyle("-fx-text-fill: red;");

            return false;
        }

    }

    public void errorChamps(){

        errorLbl.setText("Verifier vos informations !!!");

        if(nomTxt.getText().equals("")){

            nomLbl.setStyle("-fx-text-fill: red;");
            nomTxt.setStyle("-fx-border-color: red;");

        }

        if(prenomTxt.getText().equals("")){

            prenomLbl.setStyle("-fx-text-fill: red;");
            prenomTxt.setStyle("-fx-border-color: red;");

        }

        if(prenomTxt.getText().equals("")){

            prenomLbl.setStyle("-fx-text-fill: red;");
            prenomTxt.setStyle("-fx-border-color: red;");

        }

        if(fonction.equals("")){

            fonctionLbl.setStyle("-fx-text-fill: red;");
            fonctionCbo.setStyle("-fx-border-color: red;");

        }

        if(equipe.equals("")){

            equipeLbl.setStyle("-fx-text-fill: red;");
            equipeCbo.setStyle("-fx-border-color: red;");

        }

        if(mdpTxt.getText().equals("")){

            mdpLbl.setStyle("-fx-text-fill: red;");
            mdpTxt.setStyle("-fx-border-color: red;");

        }

        if(mdpConfTxt.getText().equals("")){

            mdpConfLbl.setStyle("-fx-text-fill: red;");
            mdpConfTxt.setStyle("-fx-border-color: red;");

        }




    }

    public void setDialogue(Stage dialogue){

        this.dialogue = dialogue;

    }


}
