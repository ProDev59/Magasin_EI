package vues;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FusibleControllerInsert {

    ObservableList<String> itemsCategorie = FXCollections.observableArrayList("CARTOUCHE", "COUTEAU");
    ObservableList<String> itemsType = FXCollections.observableArrayList("aM", "gG", "Protistor");


    private Stage dialogue;

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

            }
        });

        typeCbo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue.equals("aM")){

                    typeLbl.setPadding(new Insets(0, 0, 0, 15));
                    typeLbl.setStyle("-fx-text-fill : green;" +
                                     "-fx-   ");
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

            }
        });
    }


    @FXML
    public void handelValide(ActionEvent event){
        System.out.println("Valider");

    }

    @FXML
    public void handelQuitter(ActionEvent event){
        this.dialogue.close();
    }

    public void setDialogue(Stage dialogue){
        this.dialogue = dialogue;
    }


}
