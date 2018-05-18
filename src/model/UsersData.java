package model;


import java.sql.*;
import java.util.Date;

public class UsersData {

    private Connection connexion;
    private Statement statement = null;
    private Date dateNow = new Date();


    public UsersData(){

        this.connexion = DatabaseConnectionUsers.getInstance();

        try {
            this.statement = connexion.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean tableExiste() throws SQLException{

        boolean existe = false;

        ResultSet tables =  connexion.getMetaData().getTables(connexion.getCatalog(), null, "USERS", null);

        existe = tables.next();

        tables.close();

        return existe;

    }

    public void createTable(){

        try {
            statement.executeUpdate("CREATE TABLE Users (id INT IDENTITY PRIMARY KEY , dateInsert DATE , nom VARCHAR(100), prenom VARCHAR(100), equipe VARCHAR(100), fonction VARCHAR(100), password VARCHAR(100), passwordConf VARCHAR(100))");
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

    public void insert(UserModel userModel){

        try {

            PreparedStatement prepare = connexion.prepareStatement("INSERT INTO Users (dateInsert, nom, prenom, equipe, fonction, password, passwordConf) VALUES (CURDATE(), ?, ?, ?, ?, ?, ?)");

            prepare.setString(1, userModel.getNom());
            prepare.setString(2, userModel.getPrenom());
            prepare.setString(3, userModel.getEquipe());
            prepare.setString(4, userModel.getFonction());
            prepare.setString(5, userModel.getMdp());
            prepare.setString(6, userModel.getMdpConf());

            prepare.executeUpdate();

            prepare.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public boolean controleUser(String nom, String prenom, String mdp){

        boolean existe = false;

        try {

            String query = "SELECT * FROM Users WHERE nom = '"+nom+"' AND prenom = '"+prenom+"' AND password = '"+mdp+"'";

            ResultSet res = statement.executeQuery(query);

            existe = res.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public UserModel returnUserInit(String nom, String prenom, String mdp){

        String nomData = "";
        String prenomData = "";
        String fonctionData = "";
        String equipeData = "";

        try {

            String query = "SELECT * FROM Users WHERE nom = '"+nom+"' AND prenom = '"+prenom+"' AND password = '"+mdp+"'";

            ResultSet res = statement.executeQuery(query);

            while (res.next()){

                nomData = res.getString("nom");
                prenomData = res.getString("prenom");
                fonctionData = res.getString("fonction");
                equipeData = res.getString("equipe");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new UserModel(nomData, prenomData, fonctionData, equipeData, "", "");

    }

    public boolean isUserExiste(String nom, String prenom, String fonction, String equipe){

        boolean existe = false;

        try {

            String query = "SELECT * FROM Users WHERE nom = '"+nom+"' AND prenom = '"+prenom+"' AND fonction = '"+fonction+"' AND equipe = '"+equipe+"'";

            ResultSet res = statement.executeQuery(query);

            existe = res.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;

    }

    public void effacer(UserModel userModel){

    }




}
