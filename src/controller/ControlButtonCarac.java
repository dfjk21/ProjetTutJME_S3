package controller;

import model.ModelHero;
import view.Caracteristique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButtonCarac implements ActionListener{

    public Caracteristique caracteristique;
    public ModelHero mHero;

    public ControlButtonCarac(ModelHero mHero, Caracteristique caracteristique){
        this.mHero= mHero;
        this.caracteristique=caracteristique;
        caracteristique.setFermeCarac(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() ==  caracteristique.buttonExit){
            caracteristique.setVisible(false);
        }
    }
}
