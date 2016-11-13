package model;

/**
 * Created by raphael on 13/11/16.
 */
public class ModelPnj extends ModelEntite{

    private enum Metier{
        FORGERON("Forgeron"),
        GARDE("Garde"),
        PAYSAN("Paysan"),
        BUCHERON("Bucheron"),
        MARCHAND("Marchand"),
        BASEMETIER("Citoyen");

        private String metier = "";

        Metier(String metier) {
            this.metier = metier;
        }

        public String toString(){
            return metier;
        }

    }
    Metier baseMetier = Metier.BASEMETIER;
    Metier metier;

    ModelPnj(String nom){
        super(nom);
        this.metier = baseMetier;
    }

    ModelPnj(int vie, int niveau, String nom){
        super(vie,niveau,nom);
        this.metier = baseMetier;
    }

    void setMetier(int i){
        if(i <= 6 && i > 0){
            switch (i){
                case 1 :
                    metier = Metier.BUCHERON;
                    vie = 200;
                    break;
                case 2 :
                    metier = Metier.FORGERON;
                    vie = 200;
                    break;
                case 3 :
                    metier = Metier.GARDE;
                    vie = 750;
                    break;
                case 4 :
                    metier = Metier.MARCHAND;
                    vie = 200;
                    break;
                case 5 :
                    metier = Metier.PAYSAN;
                    vie = 200;
                    break;
                case 6 :
                    metier = Metier.BASEMETIER;
                    break;
            }
        }
        else{
            System.out.println("Vous ne pouvez pas mettre un nombre supérieur à 6 ou inferieur à 0");
        }
    }

    public void print() {
        if(vie <= 0){
            System.out.println("Le personnage "+nom+" est actuellement mort.");
        }
        else{
            System.out.println("Ce personnage s'apelle "+nom+", c'est "+genre+" "+metier+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }
}