package vues;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.UserModel;
import model.UsersData;


public class LoginUserController {

    private Stage dialogue;
    private MainApp mainApp = new MainApp();
    private boolean errorChamps = false;

    @FXML
    Label errorLbl;

    @FXML
    Label nomLbl;

    @FXML
    Label prenomLbl;

    @FXML
    Label mdpLbl;

    @FXML
    TextField nomTxt;

    @FXML
    TextField prenomTxt;

    @FXML
    PasswordField mdpTxt;


    public LoginUserController(){

    }

    @FXML
    public void initialize(){

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

                    if(errorChamps){
                        initChamps();
                        errorChamps = false;
                    }
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

                    if(errorChamps){
                        initChamps();
                        errorChamps = false;
                    }
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

                    if(errorChamps){
                        initChamps();
                        errorChamps = false;
                    }
                }
            }
        });
    }

    @FXML
    public void handelvalider(ActionEvent event){

        boolean validate = false;

        verifChamps();

        if(verifChamps()){
            //connection database
            UsersData usersData = new UsersData();


            // verification data base
            validate = usersData.controleUser(nomTxt.getText(), prenomTxt.getText(), mdpTxt.getText());

            //lancer nouvelle fenetre main
            if(validate){

                dialogue.close();

                UserModel userModel = usersData.returnUserInit(nomTxt.getText(), prenomTxt.getText(), mdpTxt.getText());

                mainApp.initStartShow(userModel);

                usersData.save();

            }else {

                mdpLbl.setStyle("-fx-text-fill: red;");
                mdpTxt.setStyle("-fx-border-color: red;");
                nomLbl.setStyle("-fx-text-fill: red;");
                nomTxt.setStyle("-fx-border-color: red;");
                prenomLbl.setStyle("-fx-text-fill: red;");
                prenomTxt.setStyle("-fx-border-color: red;");
                errorLbl.setText("L'Utilisateur n'est pas connu !");

                errorChamps = true;

            }


        }

    }

    @FXML
    public void handelquitter(ActionEvent event){

        dialogue.close();

    }

    @FXML
    public void handelInsert(MouseEvent event){

        initChamps();
        mainApp.userInsertShow();

    }

    public boolean verifChamps() {

        if (!nomTxt.getText().equals("") && !mdpTxt.getText().equals("") && !prenomTxt.getText().equals("")) {

            return true;

        } else if (!nomTxt.getText().equals("") && !prenomTxt.getText().equals("") && mdpTxt.getText().equals("")) {

            mdpLbl.setStyle("-fx-text-fill: red;");
            mdpTxt.setStyle("-fx-border-color: red;");
            errorLbl.setText("Le Mot de passe n'est pas rempli !");

            return false;

        } else if (nomTxt.getText().equals("") && !prenomTxt.getText().equals("") && !mdpTxt.getText().equals("")) {

            nomLbl.setStyle("-fx-text-fill: red;");
            nomTxt.setStyle("-fx-border-color: red;");
            errorLbl.setText(" Le Nom n'est pas rempli !");

            return false;

        } else if(!nomTxt.getText().equals("") && prenomTxt.getText().equals("") && !mdpTxt.getText().equals("")){

            prenomLbl.setStyle("-fx-text-fill: red;");
            prenomTxt.setStyle("-fx-border-color: red;");
            errorLbl.setText("Le Prénom n'est pas rempli !");

            return false;

        }else{

            mdpLbl.setStyle("-fx-text-fill: red;");
            mdpTxt.setStyle("-fx-border-color: red;");
            prenomLbl.setStyle("-fx-text-fill: red;");
            prenomTxt.setStyle("-fx-border-color: red;");
            nomLbl.setStyle("-fx-text-fill: red;");
            nomTxt.setStyle("-fx-border-color: red;");

            errorLbl.setText("Aucun champs rempli !");

            errorChamps = true;

            return false;
        }

    }

    public void initChamps(){

        nomTxt.setText("");
        mdpTxt.setText("");
        prenomTxt.setText("");
        errorLbl.setText("");

        mdpTxt.setStyle("-fx-border-color: null;");
        mdpLbl.setStyle("-fx-text-fill: black;");

        prenomTxt.setStyle("-fx-border-color: null;");
        prenomLbl.setStyle("-fx-text-fill: black;");

        nomTxt.setStyle("-fx-border-color: null;");
        nomLbl.setStyle("-fx-text-fill: black;");
    }

    public void setDialogue(Stage dialogue){

        this.dialogue = dialogue;

    }



}
