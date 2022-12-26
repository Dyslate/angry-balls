package decorateur.decorateur.state;

import modele.Bille;
import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;
import java.util.Vector;

public class BilleAttrape extends ControleurEtat{

    public static boolean estPress = false;
    public static boolean estRelache = false;

    public static int billeCourante = 0;
    public static double posSouris1X = -1;
    public static double posSouris1Y = -1;
    CadreAngryBalls cadre;
    Billard billard;

    public BilleAttrape(ControleurGeneral controleurGeneral, ControleurEtat suivant, ControleurEtat retour) {
        super(controleurGeneral, controleurGeneral.billeAttrape);
        this.retour = retour;
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=suivant;
        cadre = controleurGeneral.getCadre();
        billard = controleurGeneral.getBillard();
    }


    public static boolean clickPilotable(Vector<Bille> billes, MouseEvent e){
        boolean res = false;
        int compteur = 0;
        for (Bille bille : billes) {
            boolean testX = e.getX()>bille.getPosition().x-bille.getRayon()&&e.getX()<bille.getPosition().x+bille.getRayon();
            boolean testY = e.getY() > bille.getPosition().y - bille.getRayon() && e.getY()<bille.getPosition().y+bille.getRayon();
            if(bille.estPilotable()){
                if(testX&&testY) {
                    billeCourante = compteur;
                    res = true;
                }
            }
            compteur++;

        }
        return res;
    }
    @Override
    public void mousePressed(MouseEvent e){
        posSouris1X = e.getX();
        posSouris1Y = e.getY();
        if(clickPilotable(billard.billes,e)){
            estPress = true;
            System.out.println("La bille " + billeCourante+ " a été clické!");
        }
        this.controleurGeneral.setControleur(suivants[0]);
    }


        @Override
    public void init() {
        super.init();
    }
}