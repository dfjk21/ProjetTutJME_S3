/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.AccueilModel;
import view.Accueil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {

    /* Accueil */

    protected Accueil accueil;

    /* Model accueil */

    protected AccueilModel accueilModel;

    public ControlMenu(Accueil accueil, AccueilModel accueilModel){
        this.accueil = accueil;
        this.accueilModel = accueilModel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accueil.couperson){

        }
        if(e.getSource() == accueil.quit){
            System.exit(0);
        }
        if(e.getSource() == accueil.credit){

        }
    }
}
