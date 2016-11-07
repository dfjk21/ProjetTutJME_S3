/**
 * Created by charly on 07/11/16.
 */
import controller.ControlGroup;

public class Rpg {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                ControlGroup controlGroup = new ControlGroup();
            }
        });
    }
}
