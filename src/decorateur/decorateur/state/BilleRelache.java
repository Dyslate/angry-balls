package decorateur.decorateur.state;

import mesmaths.geometrie.base.Vecteur;
import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

import static decorateur.decorateur.state.BilleAttrape.*;

public class BilleRelache extends ControleurEtat {

    //Position drag/drop
    public static double posX;
    public static double posY;

    //Position mouvement
    public static double posXm;
    public static double posYm;

    //Position souris au relachement
    public static double posSouris2X;
    public static double posSouris2Y;


    //Creation du vecteur vitesse souris: différence entre position click et positionnement relachement.
    public static Vecteur vitesseSouris = Vecteur.VECTEURNUL;

    //Recupération du cadre et du billard.
    public CadreAngryBalls cadre;
    public Billard billard;

    public BilleRelache(ControleurGeneral controleurGeneral, ControleurEtat successeur, ControleurEtat retour) {
        super(controleurGeneral, retour);
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=successeur;
        cadre = controleurGeneral.getCadre();
        billard =  controleurGeneral.getBillard();
        if(estRelache){
            estRelache=false;
        }
    }



    @Override
    public void mouseReleased(MouseEvent arg0) {
        //Position de la souris au relachement
        posSouris2X = arg0.getX();
        posSouris2Y = arg0.getY();
        if(estPress){
            vitesseSouris = new Vecteur((posSouris2X-posSouris1X)/(0.5*masse),
                    (posSouris2Y-posSouris1Y)/(0.5* masse));
            estRelache = true;
        }
        this.controleurGeneral.setControleur(this.retour);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        posXm = e.getX();
        posYm = e.getY();
    }

}

