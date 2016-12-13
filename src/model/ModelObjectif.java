package model;

import java.util.HashMap;

/**
 * Created by raphael on 13/12/16.
 */
public class ModelObjectif {

    private HashMap<String, Integer> objectif;

    public ModelObjectif(){
        objectif = new HashMap<String, Integer>();

        objectif.put("RemporterCombat2", 2);
    }

    public String toString(){
        return("Gagner deux combats : 0/"+objectif.get("RemporterCombat2"));
    }
}
