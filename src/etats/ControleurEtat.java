package etats;

import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

public abstract class ControleurEtat {
    public ControleurGeneral controleurGeneral;
    public ControleurEtat retour;
    public ControleurEtat[] suivants;
    CadreAngryBalls cadre;
    Billard billard;
    public ControleurEtat(ControleurGeneral controleurGeneral, ControleurEtat retour){
        this.controleurGeneral = controleurGeneral;
        this.retour = retour;
        this.suivants=null;
        cadre = controleurGeneral.getCadre();
        billard = controleurGeneral.getBillard();
    }
    public void init() {
        billard.addMouseListener(this.controleurGeneral);
        billard.addMouseMotionListener(this.controleurGeneral);
    }
    public void mouseDragged(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}

    public void mouseMoved(MouseEvent arg0) {}
}

