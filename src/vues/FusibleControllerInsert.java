package vues;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.FusibleModel;
import model.FusibleData;

import java.sql.SQLException;

public class FusibleControllerInsert {

    ObservableList<String> itemsCategorie = FXCollections.observableArrayList("CARTOUCHE", "COUTEAU");
    ObservableList<String> itemsType = FXCollections.observableArrayList("aM", "gG", "Protistor");


    private Stage dialogue;
    private String categorie = "", type = "";

    Image imageFuseCartouche = new Image(getClass().getResource("img/fusibleCartouche.png").toExternalForm());
    Image imageFuseCouteau = new Image(getClass().getResource("img/fusibleCouteau.png").toExternalForm());


    @FXML
    ComboBox categorieCbo;

    @FXML
    ComboBox typeCbo;

    @FXML
    ImageView imageView;

    @FXML
    Label typeLbl;

    @FXML
    Label errorLbl;

    @FXML
    Label typeEttiquetteLbl;

    @FXML
    Label tailleEttiquetteLbl;

    @FXML
    Label intensiteEttiquetteLbl;

    @FXML
    Label tensionEttiquetteLbl;

    @FXML
    Label q_stock_mini_EttiquetteLbl;

    @FXML
    Label q_stock_relle_EttiquetteLbl;

    @FXML
    Label marqueEttiquetteLbl;

    @FXML
    Label ref_fournisseurEttiquetteLbl;

    @FXML
    Label ref_interneEttiquetteLbl;

    @FXML
    Label emplacementEttiquetteLbl;


    @FXML
    TextField tailleTxt;

    @FXML
    TextField intensiteTxt;

    @FXML
    TextField tensionTxt;

    @FXML
    TextField q_stock_rel;

    @FXML
    TextField q_stock_mini;

    @FXML
    TextField marqueTxt;

    @FXML
    TextField ref_fournisseurTxt;

    @FXML
    TextField ref_interneTxt;

    @FXML
    TextField emplacementTxt;


    @FXML
    public void initialize(){

        categorieCbo.setItems(itemsCategorie);
        typeCbo.setItems(itemsType);

        imageView.setImage(imageFuseCartouche);

        categorieCbo.getSelectionModel().select("CARTOUCHE");


        categorieCbo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue.equals("CARTOUCHE")){

                    imageView.setImage(imageFuseCartouche);

                }else if (newValue.equals("COUTEAU")){

                    imageView.setImage(imageFuseCouteau);

                }else {

                    imageView.setImage(imageFuseCartouche);

                }

                categorie = (String) newValue;

            }
        });

        typeCbo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                errorLbl.setText("");
                typeEttiquetteLbl.setStyle("-fx-text-fill: black;");
                typeCbo.setStyle("-fx-border-color: null;");

                if(newValue.equals("aM")){

                    typeLbl.setPadding(new Insets(0, 0, 0, 15));
                    typeLbl.setStyle("-fx-text-fill : green;");
                    typeLbl.setText("aM");


                }else if (newValue.equals("gG")){

                    typeLbl.setPadding(new Insets(0, 0, 0, 15));
                    typeLbl.setStyle("-fx-text-fill : black;");
                    typeLbl.setText("gG");


                }else if(newValue.equals("Protistor")){

                    typeLbl.setPadding(new Insets(0, 0, 0, 0));
                    typeLbl.setStyle("-fx-text-fill : red;");
                    typeLbl.setText("Protistor");

                }else {

                    typeLbl.setText("");

                }

                type = (String) newValue;

            }
        });

        tailleTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    tailleTxt.setText("");
                    errorLbl.setText("");
                    tailleTxt.setStyle("-fx-border-color: null;");
                    tailleEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        intensiteTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    intensiteTxt.setText("");
                    errorLbl.setText("");
                    intensiteTxt.setStyle("-fx-border-color: null;");
                    intensiteEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        tensionTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    tensionTxt.setText("");
                    errorLbl.setText("");
                    tensionTxt.setStyle("-fx-border-color: null;");
                    tensionEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        q_stock_mini.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    q_stock_mini.setText("");
                    errorLbl.setText("");
                    q_stock_mini.setStyle("-fx-border-color: null;");
                    q_stock_mini_EttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        q_stock_rel.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    q_stock_rel.setText("");
                    errorLbl.setText("");
                    q_stock_rel.setStyle("-fx-border-color: null;");
                    q_stock_relle_EttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        marqueTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    marqueTxt.setText("");
                    errorLbl.setText("");
                    marqueTxt.setStyle("-fx-border-color: null;");
                    marqueEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        ref_fournisseurTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    ref_fournisseurTxt.setText("");
                    errorLbl.setText("");
                    ref_fournisseurTxt.setStyle("-fx-border-color: null;");
                    ref_fournisseurEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        ref_interneTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    ref_interneTxt.setText("");
                    errorLbl.setText("");
                    ref_interneTxt.setStyle("-fx-border-color: null;");
                    ref_interneEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });

        emplacementTxt.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    emplacementTxt.setText("");
                    errorLbl.setText("");
                    emplacementTxt.setStyle("-fx-border-color: null;");
                    emplacementEttiquetteLbl.setStyle("-fx-text-fill: black;");
                }
            }
        });
    }


    @FXML
    public void handelValide(ActionEvent event){

        if (verifChamps()){

            FusibleModel fusibleModel = new FusibleModel(type, tailleTxt.getText(), Integer.parseInt(intensiteTxt.getText()), Integer.parseInt(tensionTxt.getText()), Integer.parseInt(q_stock_mini.getText()), Integer.parseInt(q_stock_rel.getText()), marqueTxt.getText(), ref_fournisseurTxt.getText(), ref_interneTxt.getText(),emplacementTxt.getText());

            FusibleData fusibleData = new FusibleData();

            try {

                if(!fusibleData.tableExiste()){

                    fusibleData.createTable();
                    fusibleData.insert(fusibleModel);

                }else {
                    if(!fusibleData.isFusibleExiste(fusibleModel.getType(), fusibleModel.getTaille(), fusibleModel.getIntensite(), fusibleModel.getTension(), fusibleModel.getMarque(), fusibleModel.getRefFournisseur(), fusibleModel.getRefInterne())){

                        fusibleData.insert(fusibleModel);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("INFORMATION");
                        alert.setHeaderText(null);
                        alert.setContentText("Référence du fusible bien enregistrée ");

                        alert.showAndWait();

                    }else{
                        //Alert
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERREUR");
                        alert.setHeaderText(null);
                        alert.setContentText("Cette référence de fusible est déja crée !!!");

                        alert.showAndWait();

                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();
                //e.getMessage();
            }

            //SAVE TEST
            fusibleData.save();

            this.dialogue.close();

        }

    }

    @FXML
    public void handelQuitter(ActionEvent event){
        this.dialogue.close();
    }

    public void setDialogue(Stage dialogue){
        this.dialogue = dialogue;
    }

    public boolean verifChamps(){

        if(!categorieCbo.getItems().equals("") && !typeCbo.getItems().equals("") && !tailleTxt.getText().equals("") && !intensiteTxt.getText().equals("") && !tensionTxt.getText().equals("") && !q_stock_mini.getText().equals("") && !q_stock_rel.getText().equals("") && !marqueTxt.getText().equals("") && !ref_fournisseurTxt.getText().equals("") && !ref_interneTxt.getText().equals("") && !emplacementTxt.getText().equals("")){
            return true;
        }else{
            errorChamps();
            return false;
        }

    }

    private void errorChamps() {

        errorLbl.setText("Verifier vos informations !!!");


        if(typeCbo.equals("")){

            typeEttiquetteLbl.setStyle("-fx-text-fill: red;");
            typeCbo.setStyle("-fx-border-color: red;");

        }

        if(tailleTxt.getText().equals("")){

            tailleEttiquetteLbl.setStyle("-fx-text-fill: red;");
            tailleTxt.setStyle("-fx-border-color: red;");

        }

        if(intensiteTxt.getText().equals("")){

            intensiteEttiquetteLbl.setStyle("-fx-text-fill: red;");
            intensiteTxt.setStyle("-fx-border-color: red;");

        }

        if(tensionTxt.getText().equals("")){

            tensionEttiquetteLbl.setStyle("-fx-text-fill: red;");
            tensionTxt.setStyle("-fx-border-color: red;");

        }


        if(q_stock_mini.getText().equals("")){

            q_stock_mini_EttiquetteLbl.setStyle("-fx-text-fill: red;");
            q_stock_mini.setStyle("-fx-border-color: red;");

        }

        if(q_stock_rel.getText().equals("")){

            q_stock_relle_EttiquetteLbl.setStyle("-fx-text-fill: red;");
            q_stock_rel.setStyle("-fx-border-color: red;");

        }

        if(marqueTxt.getText().equals("")){

            marqueEttiquetteLbl.setStyle("-fx-text-fill: red;");
            marqueTxt.setStyle("-fx-border-color: red;");

        }

        if(ref_fournisseurTxt.getText().equals("")){

            ref_fournisseurEttiquetteLbl.setStyle("-fx-text-fill: red;");
            ref_fournisseurTxt.setStyle("-fx-border-color: red;");

        }

        if(ref_interneTxt.getText().equals("")){

            ref_interneEttiquetteLbl.setStyle("-fx-text-fill: red;");
            ref_interneTxt.setStyle("-fx-border-color: red;");

        }

        if(emplacementTxt.getText().equals("")){

            emplacementEttiquetteLbl.setStyle("-fx-text-fill: red;");
            emplacementTxt.setStyle("-fx-border-color: red;");

        }

    }


}
