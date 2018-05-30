package vues;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.FusibleModel;

public class FusibleTableRechercheController {

    Stage dialogue;

    @FXML
    TableView<FusibleModel> tableView;

    @FXML
    private TableColumn<FusibleModel, String> tailleColonne;

    @FXML
    private TableColumn<FusibleModel, String> typeColonne;

    @FXML
    private TableColumn<FusibleModel, String> intensiteColonne;

    @FXML
    private TableColumn<FusibleModel, String> tensionColonne;

    @FXML
    private TableColumn<FusibleModel, String> q_miniColonne;

    @FXML
    private TableColumn<FusibleModel, String> q_relleColonne;

    @FXML
    private TableColumn<FusibleModel, String> marqueColonne;

    @FXML
    private TableColumn<FusibleModel, String> ref_fournisseurColonne;

    @FXML
    private TableColumn<FusibleModel, String> ref_interneColonne;

    @FXML
    private TableColumn<FusibleModel, String> emplacementColonne;


    @FXML
    public void initialize(){

        tailleColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyTaille());

        typeColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyType());

        intensiteColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyIntensite());

        tensionColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyTension());

        q_miniColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyQMini());

        q_relleColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyQ());

        marqueColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyMarque());

        ref_fournisseurColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyRefFournisseur());

        ref_interneColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyRefInterne());

        emplacementColonne.setCellValueFactory(cellData -> cellData.getValue().getPropertyEmplacement());


    }

    public void setDialogue(Stage dialogue){
        this.dialogue = dialogue;
    }

    public void setTableFuses(ObservableList<FusibleModel> fusibleModels){

        tableView.setItems(fusibleModels);

    }



}
