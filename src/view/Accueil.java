/**
 * Created by charly on 07/11/16.
 */
package view;

import controller.ControlBouton;
import controller.ControlMenu;
import model.AccueilModel;

import javax.swing.*;
import java.awt.*;

public class Accueil extends JFrame{

        /* Model Accueil */

    protected AccueilModel accueilModel;

        /* Control Accueil */

    protected ControlBouton controlBouton;
    protected ControlMenu controlMenu;

        /* JPanel */

    protected JPanel global;
    protected JPanel general;
    protected JPanel haut;
    protected JPanel millieu;
    protected JPanel bas;

        /* Grid */

    protected JPanel grille;

        /* JButton */

    public JButton newgame;
    public JButton option;
    public JButton exit;

        /*JMenu*/

    protected JMenuBar barMenu;
    protected JMenu options;
    public JMenuItem couperson;
    public JMenuItem quit;
    public JMenu credit;

    public Accueil(AccueilModel accueilModel){
        this.accueilModel = accueilModel;
        controlBouton = new ControlBouton(this, accueilModel);
        controlMenu = new ControlMenu(this, accueilModel);
        initAttribut();
        creerMenu();
        creerWidget();
        pack();
        setVisible(true);	                             // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ferme avec la croix
        setLocationRelativeTo(null);                     // Affiche au milieu de l'écran
    }

    public void initAttribut(){

        /* JPanel */

        global =  new JPanel();
        general = new JPanel();
        haut = new JPanel();
        millieu =  new JPanel();
        bas =  new JPanel();

        /* Grid */

        grille = new JPanel(new GridLayout(3,1));

        /* JButton */

        newgame = new JButton("Nouvelle partie");
        option = new JButton("Options");
        exit = new JButton("Quitter");

        newgame.addActionListener(controlBouton);
        option.addActionListener(controlBouton);
        exit.addActionListener(controlBouton);
    }

    public void creerWidget(){

        haut.setPreferredSize(new Dimension(500,100));
        millieu.setPreferredSize(new Dimension(500, 100));
        bas.setPreferredSize(new Dimension(500, 100));

        haut.add(newgame);
        millieu.add(option);
        bas.add(exit);

        grille.add(haut);
        grille.add(millieu);
        grille.add(bas);

        general.add(grille);
        general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));

        global.add(general);

        setContentPane(global);
    }

    public void creerMenu(){
        /*JMenu*/

        barMenu = new JMenuBar();
        options = new JMenu("Options");
        couperson = new JMenuItem("Couper le son");
        quit = new JMenuItem("Quitter");
        credit = new JMenu("Crédits");

        options.add(couperson);
        options.add(quit);

        barMenu.add(options);
        barMenu.add(credit);

        this.setJMenuBar(barMenu);

        options.addActionListener(controlMenu);
        couperson.addActionListener(controlMenu);
        quit.addActionListener(controlMenu);
        credit.addActionListener(controlMenu);
    }
}