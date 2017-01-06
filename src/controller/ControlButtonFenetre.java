package controller;

import model.ModelHero;
import view.Caracteristique;
import view.Fenetre;
import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButtonFenetre implements ActionListener {
    public ModelHero mHero;
    public Fenetre fenetre;

    public ControlButtonFenetre(ModelHero mHero, Fenetre fenetre){
        this.fenetre=fenetre;
        this.mHero=mHero;
        fenetre.setInteraction(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() ==  fenetre.buttonCaractéristique){
            new Caracteristique(mHero).display();
        }

        if (actionEvent.getSource()== fenetre.buttonQuete){
            new Quetes().display();
        }
    }
}
