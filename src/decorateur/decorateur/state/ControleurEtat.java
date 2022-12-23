package decorateur.decorateur.state;

import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;

public abstract class ControleurEtat {
    public ControleurGeneral controleurGeneral;
    public ControleurEtat retour;
    public ControleurEtat[] suivants;
    public ControleurEtat(ControleurGeneral controleurGeneral, ControleurEtat retour){
        this.controleurGeneral = controleurGeneral;
        this.retour = retour;
        this.suivants=null;
    }
    public void init() {
        CadreAngryBalls.billard.addMouseListener(this.controleurGeneral);
        CadreAngryBalls.billard.addMouseMotionListener(this.controleurGeneral);
    }
    public void mouseDragged(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mouseClicked(MouseEvent arg0){}
}

