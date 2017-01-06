package view;


import controller.ControlButtonQuetes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Quetes extends JFrame {
    JPanel quete;
    JLabel lQuete;
    public JButton buttonExit;
    ControlButtonQuetes controlButtonQuetes;

    public Quetes(){
        initAttribut();
        createWidget();
        setResizable(false);
        setVisible(false);
        setLocationRelativeTo(null);
        pack();
        controlButtonQuetes = new ControlButtonQuetes(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initAttribut(){
        lQuete = new JLabel("Liste Quêtes : ");
    }

    private void createWidget(){
        quete = new JPanel(new GridLayout(2,1)); // A changer en fonction du nombre de quetes
        quete.add(lQuete);
        buttonExit = new JButton("Fermer");
        buttonExit.setPreferredSize(new Dimension(150,30));
        quete.add(buttonExit);
        setContentPane(quete);
    }

    public void display() {
        setVisible(true);
    }

    public void setFermeQuetes(ActionListener listener){
        buttonExit.addActionListener(listener);
    }
}
