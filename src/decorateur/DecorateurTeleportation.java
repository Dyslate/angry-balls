package decorateur;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

import static etats.BilleAttrape.*;
import static etats.BilleRelache.*;


/**
 * Decorateur permettant à la bille de se téléporter via la souris. Au relachement du click de la souris, la bille se positionne à l'endroit voulue.
 */
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
