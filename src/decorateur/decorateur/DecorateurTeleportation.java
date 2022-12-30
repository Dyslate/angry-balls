package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

import static decorateur.decorateur.state.BilleAttrape.*;
import static decorateur.decorateur.state.BilleRelache.*;


public class DecorateurTeleportation extends DecorateurBille {
    public DecorateurTeleportation(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        if(estPress&&estRelache&&this.getClef()==billeCourante) {
            Vecteur temporaire = bille.getPosition();
            if(estPress&&estRelache&&this.getClef()==billeCourante){
                temporaire = new Vecteur(posX,posY);
            }
            bille.getPosition().set(temporaire);
            estPress = false;
            estRelache = false;
        }
    }
}
