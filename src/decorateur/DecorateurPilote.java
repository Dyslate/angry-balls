package decorateur;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

import static etats.BilleAttrape.*;
import static etats.BilleRelache.*;


/**
 * Decorateur permettant à une bille d'être controllable via la souris.
 */
public class DecorateurPilote extends DecorateurBille {
    public DecorateurPilote(Bille b) {
        super(b);
    }

    @Override
    public boolean estPilotable() {
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        if(estPress&&!estRelache&&this.getClef()==billeCourante){
            Vecteur temporaire = new Vecteur(posX/ (masse()*0.00003),posY / (masse()*0.00003));
            bille.getPosition().set(temporaire);
        }
        if(estRelache){
            estPress=false;
            estRelache= false;
        }
    }
}
