package model;

import java.sql.*;
import java.util.Date;

public class FusibleData {

    private Connection connexion;
    private Statement statement = null;
    private Date dateNow = new Date();


    public FusibleData(){

        this.connexion = DatabaseConnectionFusibles.getInstance();

        try {
            this.statement = connexion.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean tableExiste() throws SQLException{

        boolean existe = false;

        ResultSet tables =  connexion.getMetaData().getTables(connexion.getCatalog(), null, "FUSIBLES", null);

        existe = tables.next();

        tables.close();

        return existe;

    }

    public void createTable(){

        try {
            statement.executeUpdate("CREATE TABLE Fusibles (id INT IDENTITY PRIMARY KEY , dateInsert DATE , type VARCHAR(100), taille VARCHAR(100), intensite INT, tension INT, q_mini INT, q_relle INT, marque VARCHAR(100), ref_Fournisseur VARCHAR(100), ref_interne VARCHAR(100), emplacement VARCHAR(100))");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void save() {

        try {

            //Fermeture est sauvegarde sur disque dur
            statement.executeQuery("SHUTDOWN");
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void insert(FusibleModel fusibleModel){

        try {

            PreparedStatement prepare = connexion.prepareStatement("INSERT INTO Fusibles (dateInsert, type, taille, intensite, tension, q_mini, q_relle, marque, ref_Fournisseur, ref_interne, emplacement) VALUES (CURDATE(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            prepare.setString(1, fusibleModel.getType());
            prepare.setString(2, fusibleModel.getTaille());
            prepare.setInt(3, fusibleModel.getIntensite());
            prepare.setInt(4, fusibleModel.getTension());
            prepare.setInt(5, fusibleModel.getQ_mini());
            prepare.setInt(6, fusibleModel.getQ());
            prepare.setString(7, fusibleModel.getMarque());
            prepare.setString(8, fusibleModel.getRefFournisseur());
            prepare.setString(9, fusibleModel.getRefInterne());
            prepare.setString(10, fusibleModel.getEmplacement());

            prepare.executeUpdate();

            prepare.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public boolean controleFusible(String type, String taille, int intensite, int tension, String marque){

        boolean existe = false;

        try {

            String query = "SELECT * FROM Fusibles WHERE type = '"+type+"' AND taille = '"+taille+"' AND intensite = '"+intensite+"' AND tension = '"+tension+"' AND marque = '"+marque+"'";

            ResultSet res = statement.executeQuery(query);

            existe = res.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public boolean isFusibleExiste(String type, String taille, int intensite, int tension, String marque,String ref_Fournisseur, String ref_interne){

        boolean existe = false;

        try {

            String query = "SELECT * FROM Fusibles WHERE type = '"+type+"' AND taille = '"+taille+"' AND intensite = '"+intensite+"' AND tension = '"+tension+"' AND marque = '"+marque+"' AND ref_Fournisseur = '"+ref_Fournisseur+"' AND ref_interne = '"+ref_interne+"'";

            ResultSet res = statement.executeQuery(query);

            existe = res.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;

    }


}
