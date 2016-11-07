/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.AccueilModel;
import view.Accueil;

import java.awt.event.ActionEvent;

public class ControlMenu {

    /* Accueil */

    protected Accueil accueil;

    /* Model accueil */

    protected AccueilModel accueilModel;

    public ControlMenu(Accueil accueil, AccueilModel accueilModel){
        this.accueil = accueil;
        this.accueilModel = accueilModel;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
