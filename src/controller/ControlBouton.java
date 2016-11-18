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

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == accueil.newgame){
            if(!modelAccueil.getEtatPartieJME()){
                //Avant d'exécuter le main de la classe JME on rend invisible la fenêtre JSwing
                //accueil.setVisible(false);
                //On défini l'état de JME en true pour dire que la partie est lancée
                modelAccueil.setEtatPartieJME(true);
                //On exécute JME
                newGame();

            }
        }
        if(event.getSource() == accueil.option){

        }
        if(event.getSource() == accueil.exit){
            System.exit(0);
        }
    }

    protected void newGame() {
        //On initialise un nouveau thead qui va exécuter le main de la classe JME
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
