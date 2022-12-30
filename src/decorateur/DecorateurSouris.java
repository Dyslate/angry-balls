package decorateur;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

import static etats.BilleAttrape.*;
import static etats.BilleRelache.*;

public class DecorateurSouris extends DecorateurBille {
    public DecorateurSouris(Bille b) {
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
                Vecteur temporaire = new Vecteur(posX,posY);
                bille.getPosition().set(temporaire);
            }
            if(estRelache){
                estPress=false;
                estRelache= false;
            }
        }
    }
