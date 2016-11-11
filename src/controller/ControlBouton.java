/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.AccueilModel;
import view.Accueil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBouton implements ActionListener {

     /* Accueil */

    protected Accueil accueil;

    /* Model accueil */

    protected AccueilModel accueilModel;

    public ControlBouton(Accueil accueil, AccueilModel accueilModel){
        this.accueil = accueil;
        this.accueilModel = accueilModel;
    }

    public void actionPerformed(ActionEvent e){

    }
}
