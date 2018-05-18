package model;

public class FusibleModel extends ArticleModel {

    private String type;
    private String taille;
    private int intensite;
    private int tension;

    public FusibleModel(String type, String taille, int intensite, int tension, int q_mini, int q, String ref_fourn, String ref_int){

        this.type = type;
        this.taille = taille;
        this.intensite = intensite;
        this.tension = tension;
        this.q_mini = q_mini;
        this.q = q;
        this.refFournisseur = ref_fourn;
        this.refInterne = ref_int;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getIntensite() {
        return intensite;
    }

    public void setIntensite(int intensite) {
        this.intensite = intensite;
    }

    public int getTension() {
        return tension;
    }

    public void setTension(int tension) {
        this.tension = tension;
    }
}
