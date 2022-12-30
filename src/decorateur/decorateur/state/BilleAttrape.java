package decorateur.decorateur.state;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;
import java.util.Vector;

public class BilleAttrape extends ControleurEtat{

    //Booleens pour gèrer les différents états (press ou relache)
    public static boolean estPress = false;
    public static boolean estRelache = false;

    //Bille selectionné
    public static int billeCourante = 0;

    //Position souris au moment du click
    public static double posSouris1X;
    public static double posSouris1Y;

    //Recuperation de la masse de la bille
    public static double masse;

    //Recuperation du cadre, et du billard
    CadreAngryBalls cadre;
    Billard billard;

    public BilleAttrape(ControleurGeneral controleurGeneral, ControleurEtat suivant, ControleurEtat retour) {
        super(controleurGeneral, controleurGeneral.billeAttrape);
        this.retour = retour;
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=suivant;
        cadre = controleurGeneral.getCadre();
        billard = controleurGeneral.getBillard();
        estRelache=false;
        estPress=false;
    }

    //Test si la souris est sur la bille clickée, et si la bille est pilotable.
    public static boolean CliquePilotable(Vector<Bille> billes, MouseEvent e){
        boolean res = false;
        for (Bille bille : billes) {
            boolean testX = e.getX()>bille.getPosition().x-bille.getRayon()&&e.getX()<bille.getPosition().x+bille.getRayon();
            boolean testY = e.getY() > bille.getPosition().y - bille.getRayon() && e.getY()<bille.getPosition().y+bille.getRayon();
            if(bille.estPilotable()){
                if(testX&&testY) {
                    billeCourante = bille.getClef();
                    masse = bille.masse();
                    res = true;
                }
            }
        }
        return res;
    }
    @Override
    public void mousePressed(MouseEvent e){
        //Position de la souris au moment du click
        posSouris1X = e.getX();
        posSouris1Y = e.getY();
        if(CliquePilotable(billard.billes,e)){
            estPress = true;
        }
        this.controleurGeneral.setControleur(suivants[0]);
    }

    @Override
    public void init() {
        super.init();
    }
}
