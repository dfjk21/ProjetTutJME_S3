package model;

/**
 * Created by raphael on 13/11/16.
 */
public class ModelMob extends ModelEntite{

    private enum Type{
        LOUP("Loup"),
        BANDIT("Bandit"),
        SLIM("Slim"),
        BASEMOB("Goblin");

        private String intitule = "";

        Type(String intitule) {
            this.intitule = intitule;
        }

        public String toString(){
            return intitule;
        }

    }
    Type baseIntitule = Type.BASEMOB;
    public Type classe;

    ModelMob(String nom){
        super(nom);
        this.classe = baseIntitule;
    }

    ModelMob(int vie, int niveau, String nom){
        super(vie,niveau,nom);
        this.classe = baseIntitule;
    }

    public Type getClasse(){
        return classe;
    }

    public void print() {
        if(vie <= 0){
            System.out.println("Le monstre "+nom+" est mort.");
        }
        else{
            System.out.println("Ce monstre s'apelle "+nom+", c'est "+genre+" "+classe+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }

}