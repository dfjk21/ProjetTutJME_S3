package model;
import java.util.Random;

/**
 * Created by raphael on 11/11/16.
 */

public class ModelCombat {
  
    Random input = new Random();
    final int CRITIQUE_BASE = 15;
    ModelCombat(){
      
    }
  
    public void attaquePhy(ModelEntite perso){
        int force = perso.getForce();
        int plus = input.nextInt(force)/2;
        int degats = 1;
        if (plus <= force/4){
          degats = force - plus;
        }
        else{
          degats = force + (plus-force/4);
        }
        if(degats == 0){
          degats = 1;
        }
        
        critique = input.nextInt(100);
        if(critique <= CRITIQUE_BASE){
          degats = degats + degats*0.5;
        }
        perteVie(degats);
    }
}
