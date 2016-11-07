/**
 * Created by charly on 07/11/16.
 */
package view;

import controller.ControlBouton;
import controller.ControlMenu;
import model.AccueilModel;

public class Accueil {

        /* Model Accueil */

    protected AccueilModel accueilModel;

        /* Control Accueil */

    protected ControlBouton controlBouton;
    protected ControlMenu controlMenu;

        /* JPanel */



        /* JLabel */



        /* JButton */



        /*JMenu*/



    public Accueil(AccueilModel accueilModel){
        this.accueilModel = accueilModel;
        this.controlBouton = new ControlBouton(this, accueilModel);
        this.controlMenu = new ControlMenu(this, accueilModel);
    }
}