package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

import static decorateur.decorateur.state.BilleAttrape.*;
import static decorateur.decorateur.state.BilleRelache.vitesseSouris;

public class DecorateurLancePierre extends DecorateurBille {
    public DecorateurLancePierre(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        if(estPress&&estRelache&&this.getClef()==billeCourante){
            this.bille.getAcceleration().set(new Vecteur(-vitesseSouris.x,-vitesseSouris.y));
            estPress=false;
            estRelache=false;
        }
    }
}
