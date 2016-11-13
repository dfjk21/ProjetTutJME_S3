package model;

/**
 * Created by raphael on 13/11/16.
 */
public class ModelMob extends ModelEntite{

    ModelMob(String nom){
        super(nom);
    }

    ModelMob(int vie, int niveau, String nom){
        super(vie,niveau,nom);
    }


}