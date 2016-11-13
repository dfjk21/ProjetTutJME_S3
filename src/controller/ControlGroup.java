/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.ModelAccueil;
import view.Accueil;

public class ControlGroup {

    public ControlGroup() {
        ModelAccueil modelAccueil = new ModelAccueil(false);
        Accueil accueil = new Accueil(modelAccueil);

    }
}