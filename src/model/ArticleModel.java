package model;

public class ArticleModel {

    protected int id;
    protected String categorie;
    protected String refInterne;
    protected String refFournisseur;
    protected int q;
    protected int q_mini;


    public ArticleModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getRefInterne() {
        return refInterne;
    }

    public void setRefInterne(String refInterne) {
        this.refInterne = refInterne;
    }

    public String getRefFournisseur() {
        return refFournisseur;
    }

    public void setRefFournisseur(String refFournisseur) {
        this.refFournisseur = refFournisseur;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getQ_mini() {
        return q_mini;
    }

    public void setQ_mini(int q_mini) {
        this.q_mini = q_mini;
    }



}
