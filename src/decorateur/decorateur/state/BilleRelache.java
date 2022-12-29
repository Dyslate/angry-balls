package decorateur.decorateur.state;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

public class BilleRelache extends ControleurEtat {

    //Position drag/drop
    public static double posX = -1;
    public static double posY = -1;

    //Position souris au relachement
    public static double posSouris2X;
    public static double posSouris2Y;


    //Creation du vecteur vitesse souris: différence entre position click et positionnement relachement.
    public static Vecteur vitesseSouris;

    //Recupération du cadre et du billard.
    public CadreAngryBalls cadre;
    public Billard billard;

    public BilleRelache(ControleurGeneral controleurGeneral, ControleurEtat successeur, ControleurEtat retour) {
        super(controleurGeneral, retour);
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=successeur;
        cadre = controleurGeneral.getCadre();
        billard =  controleurGeneral.getBillard();
        if(BilleAttrape.estRelache){
            BilleAttrape.estRelache=false;
        }
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        //Position de la souris au relachement
        posSouris2X = arg0.getX();
        posSouris2Y = arg0.getY();
        if(BilleAttrape.estPress){
            vitesseSouris = new Vecteur((posSouris2X-BilleAttrape.posSouris1X)/(0.5*BilleAttrape.masse),
                    (posSouris2Y-BilleAttrape.posSouris1Y)/(0.5*BilleAttrape.masse));
            BilleAttrape.estRelache = true;
        }
        this.controleurGeneral.setControleur(this.retour);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }
}
