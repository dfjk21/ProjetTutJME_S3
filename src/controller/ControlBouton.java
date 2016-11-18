/**
 * Created by charly on 07/11/16.
 */
package controller;

import model.ModelAccueil;
import view.Accueil;
import view.JME;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBouton implements ActionListener {

     /* Accueil */

    protected Accueil accueil;

    /* Model accueil */

    protected ModelAccueil modelAccueil;

    public ControlBouton(Accueil accueil, ModelAccueil modelAccueil){
        this.accueil = accueil;
        this.modelAccueil = modelAccueil;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == accueil.newgame){
            newGame(e);
        }
        if(e.getSource() == accueil.option){

        }
        if(e.getSource() == accueil.exit){
            System.exit(0);
        }
    }

    protected static void newGame(ActionEvent e) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                JME jme = new JME();//This would be your jME app extending SimpleApplication
                jme.start();
            }
        });
        t.start();
    }
}
