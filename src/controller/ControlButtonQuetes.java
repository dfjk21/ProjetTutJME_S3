package controller;

import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButtonQuetes implements ActionListener {

    Quetes quetes;

    public ControlButtonQuetes(Quetes quetes){
        this.quetes= quetes;
        quetes.setFermeQuetes(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() ==  quetes.buttonExit){
            quetes.setVisible(false);
        }
    }
}
