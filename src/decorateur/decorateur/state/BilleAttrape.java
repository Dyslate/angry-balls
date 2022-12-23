package decorateur.decorateur.state;

import mesmaths.geometrie.base.Vecteur;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

public class BilleAttrape extends ControleurEtat{

    public static boolean estPress = false;
    public static boolean estRelache = false;

    public static int billeCourante = 0;
    public static double posSouris1X = -1;
    public static double posSouris1Y = -1;


    public BilleAttrape(ControleurGeneral controleurGeneral, ControleurEtat suivant, ControleurEtat retour) {
        super(controleurGeneral, controleurGeneral.billeAttrape);
        this.retour = retour;
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=suivant;
    }

    @Override
    public void mousePressed(MouseEvent e){
        posSouris1X = e.getX();
        posSouris1Y = e.getY();
      //  System.out.println("rel: "+posSouris1X+"-"+posSouris1Y);

        for (int i = 0; i < CadreAngryBalls.billard.billes.size(); i++){
            if (e.getX() > CadreAngryBalls.billard.billes.get(i).getPosition().x - CadreAngryBalls.billard.billes.get(i).getRayon() && e.getX() < CadreAngryBalls.billard.billes.get(i).getPosition().x + CadreAngryBalls.billard.billes.get(i).getRayon()) {
                if (e.getY() > CadreAngryBalls.billard.billes.get(i).getPosition().y - CadreAngryBalls.billard.billes.get(i).getRayon() && e.getY() < CadreAngryBalls.billard.billes.get(i).getPosition().y + CadreAngryBalls.billard.billes.get(i).getRayon()) {
                    if (CadreAngryBalls.billard.billes.get(i).estPilotable()) {
                        billeCourante = i;
                        estPress = true;
                        System.out.println("La bille " + CadreAngryBalls.billard.billes.get(i).getCouleur() + " a été clické!");
                    }
                }
            }
        }
        this.controleurGeneral.setControleur(suivants[0]);
    }






        @Override
    public void init() {
        super.init();
    }
}
