package model;

/**
 * Created by raphael on 11/11/16.
 */

public class ModelHero extends ModelEntite {

    private enum Classe{
        MAGE("Mage"),
        GUERRIER("Guerrier"),
        ASSASSIN("Assassin"),
        TRAVELERS("Travelers"),
        BASECLASSE("Aventurier");

        private String intitule = "";

        Classe(String intitule) {
            this.intitule = intitule;
        }

        public String toString(){
            return intitule;
        }

    }
    Classe baseIntitule = Classe.BASECLASSE;
    Classe classe;

    public ModelHero(String nom){
        super(nom);
        this.classe = baseIntitule;
    }

    public ModelHero(int vie, int niveau, String nom){
        super(vie,niveau,nom);
        this.classe = baseIntitule;
    }

    public void setClasse(int i){
        if(i <= 5 && i > 0){
            switch (i){
                case 1 :
                    classe = Classe.ASSASSIN;
                    vie = 300;
                    this.setDefenceMag(10);
                    this.setDefencePhy(6);
                    this.setForce(20);
                    this.setMagie(8);
                    break;
                case 2 :
                    classe = Classe.GUERRIER;
                    vie = 500;
                    this.setDefenceMag(15);
                    this.setDefencePhy(20);
                    this.setForce(8);
                    this.setMagie(4);
                    break;
                case 3 :
                    classe = Classe.MAGE;
                    vie = 250;
                    this.setDefenceMag(15);
                    this.setDefencePhy(8);
                    this.setForce(6);
                    this.setMagie(25);
                    break;
                case 4 :
                    classe = Classe.TRAVELERS;
                    vie = 350;
                    this.setDefenceMag(10);
                    this.setDefencePhy(8);
                    this.setForce(14);
                    this.setMagie(10);
                    break;
                case 5 :
                    classe = Classe.BASECLASSE;
                    this.setDefenceMag(10);
                    this.setDefencePhy(10);
                    this.setForce(8);
                    this.setMagie(8);
                    break;
            }
        }
        else{
            System.out.println("Vous ne pouvez pas mettre un nombre supérieur à 5 ou inferieur à 0");
        }
        //faire un switch entre es différente classe
    }

    public void print() {
        if(vie <= 0){
            System.out.println("Le personnage "+nom+" est actuellement mort.");
        }
        else{
            System.out.println("Ce personnage s'apelle "+nom+", c'est "+genre+" "+classe+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }

    public Classe getClasse() {
        return classe;
    }
}