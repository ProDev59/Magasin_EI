package model;

public class UserModel {


    private String nom;
    private String prenom;
    private String fonction;
    private String equipe;
    private String mdp;
    private String mdpConf;


    public UserModel(String nom, String prenom, String fonction, String equipe, String mdp, String mdpConf){

        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.equipe = equipe;
        this.mdp = mdp;
        this.mdpConf = mdpConf;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdpConf() {
        return mdpConf;
    }

    public void setMdpConf(String mdpConf) {
        this.mdpConf = mdpConf;
    }


}
