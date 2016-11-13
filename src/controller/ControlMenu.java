/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.ModelAccueil;
import view.Accueil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {

    /* Accueil */

    protected Accueil accueil;

    /* Model accueil */

    protected ModelAccueil modelAccueil;

    public ControlMenu(Accueil accueil, ModelAccueil modelAccueil){
        this.accueil = accueil;
        this.modelAccueil = modelAccueil;
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
