package model;

/**
 * Created by raphael on 13/12/16.
 */
public class ModelQuete {

    private String intituleQuete;
    private String contenueQuete;
    ModelObjectif objectif;

    public ModelQuete(String intituleQuete, String contenueQuete){
        this.intituleQuete = intituleQuete;
        this.contenueQuete = contenueQuete;
        objectif = null;
    }

    boolean isSuccess(){
        return false;
    }

    public void ajoutObjectif(ModelObjectif objectif){
        this.objectif = objectif;
    }

    void print(){
        System.out.println("La quête que j'ai à vous proposez se nomme : "+intituleQuete+"." +
                           "\n" +
                           "\n"+contenueQuete+
                           "\n"+objectif.toString());
    }
}
