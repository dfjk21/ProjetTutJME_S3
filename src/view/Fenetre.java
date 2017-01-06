package view;

import controller.ControlButtonCarac;
import controller.ControlButtonFenetre;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Fenetre extends JFrame {

    protected ModelHero modelH;

    public ControlButtonFenetre controlButtonFenetre;
    public JPanel panoFondEcran;
    public JPanel panoGlobalJeu;

    public JPanel panoEspaceIntéraction;
    public JButton buttonCaractéristique;
    public JButton buttonQuete;

    public JPanel panoEspaceJeu;
    public JPanel panoEspaceDialogue;
    public JPanel panoEspaceReponse;
    public JTextField textReponse;
    public JButton buttonReponse;

    public JTextArea tableauAll;

    public Fenetre(ModelHero modelH) {

        this.modelH=modelH;
        setTitle("RPG");
        initJeu();
        plateauDeJeu();
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initJeu() {

        panoEspaceIntéraction = new JPanel(new GridLayout(2, 1, 25, 10));


        buttonCaractéristique = new JButton("Caractéristique");
        buttonCaractéristique.setPreferredSize(new Dimension(150, 50));

        buttonQuete = new JButton("Quête");
        buttonQuete.setPreferredSize(new Dimension(150, 50));


        panoEspaceIntéraction.add(buttonCaractéristique);
        panoEspaceIntéraction.add(buttonQuete);

        panoEspaceReponse = new JPanel();
        textReponse = new JTextField();
        textReponse.setColumns(10);
        buttonReponse = new JButton("Valider");
        buttonReponse.setMnemonic(KeyEvent.VK_ENTER);
        panoEspaceReponse.add(textReponse);
        panoEspaceReponse.add(buttonReponse);

    }

    public void plateauDeJeu() {

        panoEspaceJeu = new JPanel(new GridLayout(2, 1, 5, 5));
        panoEspaceJeu.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        panoEspaceDialogue = new JPanel();
        tableauAll = new JTextArea("");
        tableauAll.setBackground(Color.LIGHT_GRAY);
        panoEspaceDialogue.add(tableauAll);
        tableauAll.setText("");

        panoEspaceJeu.add(panoEspaceDialogue);
        panoEspaceJeu.add(panoEspaceReponse);

        panoFondEcran = new JPanel(new GridLayout(1, 2));
        panoFondEcran.setLayout(new BoxLayout(panoFondEcran, BoxLayout.X_AXIS));

        panoFondEcran.add(panoEspaceIntéraction);
        panoFondEcran.add(panoEspaceJeu);

        panoGlobalJeu = new JPanel();
        panoGlobalJeu.add(panoFondEcran);

        setContentPane(panoGlobalJeu);

        controlButtonFenetre = new ControlButtonFenetre(modelH,this);
    }

    public void setInteraction(ActionListener listener) {
        buttonCaractéristique.addActionListener(listener);
        buttonQuete.addActionListener(listener);
        buttonReponse.addActionListener(listener);
    }

    public void display() {
        setVisible(true);
    }
}