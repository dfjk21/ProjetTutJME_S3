/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.AccueilModel;
import view.Accueil;

public class ControlGroup {

    public ControlGroup() {
        AccueilModel accueilModel = new AccueilModel(false);
        Accueil accueil = new Accueil(accueilModel);

    }
}