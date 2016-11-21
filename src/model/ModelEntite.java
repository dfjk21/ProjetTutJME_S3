package model;
import java.util.Random;

/**
 * Created by raphael on 11/11/16.
 */
public class ModelEntite {

    protected int vie;
    protected int force;
    protected int magie;
    protected int defencePhy;
    protected int defenceMag;
    protected int niveau;
    protected int vieMax = vie;
    protected enum Genre {
        HOMME("un homme"),
        FEMMME("une femme"),
        NONDEF("Indefini");

        private String genre = "";

        Genre(String genre) {
            this.genre = genre;
        }

        public String toString(){
            return genre;
        }
    }
    Random input = new Random();
    protected String nom;
    Genre baseGenre = Genre.NONDEF;
    Genre genre;

    ModelEntite(String nom){
        vie = 150;
        force = input.nextInt(20);
        magie = input.nextInt(30);
        niveau = 1;
        this.nom = nom;
        this.genre = baseGenre;
    }

    ModelEntite(int vie, int niveau,String nom){
        this.vie = vie;
        this.niveau = niveau;
        this.nom = nom;
        this.genre = baseGenre;

        if(niveau > 1){
            for(int i = 1; i < niveau; i++){
                if((this.vie / 2) % 2 != 0){
                    this.vie = this.vie + this.vie/2 + 1;
                }
                else{
                    this.vie = this.vie + this.vie/2;
                }
            }
        }
    }

    void setVie(int vie){
        this.vie = vie;
    }
    
    void setForce(int force){
        this.force = focre;
    }
    
    void setDefencePhy(int defencePhy){
        this.defencePhy = defencePhy;
    }
    
    void setDefenceMag(int defenceMag){
        this.defenceMag = defenceMag;
    }
    
    void setMagie(int magie){
        this.magie = magie;
    }

    void setNiveau(int niveau){
        this.niveau = niveau;
    }

    void setGenre(int i){
        if(i <= 3 && i > 0){
            switch (i){
                case 1 :
                    genre = Genre.FEMMME;
                    break;
                case 2 :
                    genre = Genre.HOMME;
                    break;
                case 3 :
                    genre = Genre.NONDEF;
                    break;
            }
        }
        else{
            System.out.println("Vous ne pouvez pas mettre un nombre superieur à 3 ou inferieur à 0");
        }
    }

    void setNom(String nom){
        this.nom = nom;
    }

    int getVie(){
        return vie;
    }
    
    int getDefPhy(){
        return defencePhy;
    }
    
    int getDefMag(){
        return defenceMag;
    }
    
    int getForce(){
        return force;
    }

    int getMagie(){
        return magie;
    }
    
    int getNiveau(){
        return niveau;
    }

    String getNom(){
        return nom;
    }

    public void gainNiveau(){
        niveau++;

        if((vie / 2) % 2 != 0){
            vie = vie + (vie + 1)/2;
        }
        else{
            vie = vie + vie/2;
        }
    }

    public boolean estMort(){
        if(vie <= 0){
            return true;
        }
        return false;
    }

    public void perteVie(int degats){
        vie -= degats;
    }

    public void regenVie(){
        while(vie < vieMax){
            //incrémenter de 1 la vie tout les x secondes
        }
    }

    public void print() {
        if(estMort()){
            System.out.println("Le personnage "+nom+" est actuellement mort.");
        }
        else{
            System.out.println("Ce personnage s'apelle "+nom+",c'est "+genre+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }
}
