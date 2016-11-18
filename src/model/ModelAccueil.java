/**
 * Created by charly on 07/11/16.
 */
package model;

public class ModelAccueil {

    private boolean etatPartieJME;

    public ModelAccueil(boolean etatJME){
        etatPartieJME = etatJME;
    }

    public void setEtatPartieJME(boolean etatJME) {
        etatPartieJME = etatJME;
    }

    public boolean getEtatPartieJME() {
        return etatPartieJME;
    }

}