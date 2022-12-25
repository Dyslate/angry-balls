package decorateur.decorateur.state;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

public class BilleRelache extends ControleurEtat {

    public static double posX = -1;
    public static double posY = -1;
    public static double posSouris2X;
    public static double posSouris2Y;

    public static Vecteur vitesseSouris = new Vecteur(-1,-1);
    public CadreAngryBalls cadre;
    public Billard billard;

    public BilleRelache(ControleurGeneral controleurGeneral, ControleurEtat successeur, ControleurEtat retour) {
        super(controleurGeneral, retour);
        this.suivants = new ControleurEtat[1];
        this.suivants[0]=successeur;
        cadre = controleurGeneral.getCadre();
        billard =  controleurGeneral.getBillard();
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        System.out.println("released");
        posSouris2X = arg0.getX();
        posSouris2Y = arg0.getY();
        vitesseSouris = new Vecteur((posSouris2X-BilleAttrape.posSouris1X)/(0.5*billard.billes.get(BilleAttrape.billeCourante).masse()),
                (posSouris2Y-BilleAttrape.posSouris1Y)/(0.5*billard.billes.get(BilleAttrape.billeCourante).masse()));
        BilleAttrape.estRelache = true;
        this.controleurGeneral.setControleur(this.retour);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if(BilleAttrape.estPress&&vitesseSouris.x!=-1&&vitesseSouris.y!=-1){
            posX = e.getX();
            posY = e.getY();
        }
    }
}
