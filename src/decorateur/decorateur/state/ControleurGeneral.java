package decorateur.decorateur.state;

import vues.Billard;
import vues.CadreAngryBalls;

import java.awt.event.*;


public class ControleurGeneral implements MouseListener, MouseMotionListener {


    CadreAngryBalls cadre;
    public ControleurEtat billeAttrape, billeRelache, controleurCourant;
    public ControleurGeneral(CadreAngryBalls cadre) {
        installeControleurs();
        this.cadre = cadre;
    }
    private void installeControleurs(){
        this.billeAttrape = new BilleAttrape(this,null,null);
        this.billeRelache = new BilleRelache(this,this.billeAttrape,this.billeAttrape);
        this.billeRelache.retour = this.billeAttrape;
        this.billeAttrape.suivants[0] = this.billeRelache;
        this.controleurCourant = this.billeAttrape;
        this.setControleur(this.controleurCourant);
    }

    public void setControleur(ControleurEtat controleurEtat){
        this.controleurCourant = controleurEtat;
        this.controleurCourant.init();
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {this.controleurCourant.mouseDragged(arg0);}
    @Override
    public void mousePressed(MouseEvent arg0) {
        this.controleurCourant.mousePressed(arg0);
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        this.controleurCourant.mouseReleased(arg0);
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public CadreAngryBalls getCadre() {
        return cadre;
    }

    public Billard getBillard(){
        return CadreAngryBalls.billard;
    }
}
