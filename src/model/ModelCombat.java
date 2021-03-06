package model;

import java.util.Random;

public class ModelCombat {

    Random input = new Random();
    final int CRITIQUE_BASE = 15;
    final int PARADE_BASE = 15;
    final int ESQUIVE_BASE = 15;
    public ModelCombat(){

    }
  /*
    public void deroulementCombat(){
      int degats;
      //exemple1
      degats = attaquePhy(p1);
      degats = esquive(degats);
      perteVie(degats);
      //exemple2
      degats = attaqueMag(p2);
      degats = parade(degats);
      perteVie(degats);
    }
  */


    public double attaquePhy(ModelEntite perso){
        int force = perso.getForce();
        int plus = input.nextInt(force)/2;
        double degats = 1;
        if (plus <= force/4){
            degats = force - plus;
        }
        else{
            degats = force + (plus-force/4);
        }
        if(degats <= 0){
            degats = 1;
        }
        degats = critique(degats);
        return degats;
    }

    public double attaqueMag(ModelEntite perso){
        int magie = perso.getMagie();
        int plus = input.nextInt(magie);
        double degats = 1;
        if(plus <= magie/2){
            degats = magie - input.nextInt(10);
        }
        else if(plus <= (magie/4)*3){
            degats = magie + (input.nextInt(20)-10);
        }
        else{
            degats = magie + input.nextInt(10);
        }
        degats = critique(degats);
        return degats;
    }

    public double critique(double degats){
        int critique = input.nextInt(100);
        if(critique <= CRITIQUE_BASE){
            degats = degats + degats*0.5;
        }
        return degats;
    }

    public double esquive(double degats){
        int esquive = input.nextInt(100);
        if(esquive <= ESQUIVE_BASE){
            degats = 5;
        }
        else if(esquive >=95){
            degats = degats+ 5;
        }
        return degats;
    }

    public double parade(double degats){
        int parade = input.nextInt(100);
        if(parade <= PARADE_BASE){
            degats = 0;
        }
        else if(parade >=90){
            degats = degats+ 10;
        }
        return degats;
    }

    public double defencePhy(double degats, ModelEntite perso){
        int defenceP = perso.getDefPhy();
        degats = degats - defenceP;
        return degats;
    }

    public double defenceMag(double degats, ModelEntite perso){
        int defenceM = perso.getDefMag();
        degats = degats - defenceM;
        return degats;
    }
}