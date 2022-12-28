package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

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
            if(BilleAttrape.estPress&&!BilleAttrape.estRelache&&this.getClef()==BilleAttrape.billeCourante){
                Vecteur temporaire = new Vecteur(BilleRelache.posX,BilleRelache.posY);
                bille.getPosition().set(temporaire);
            }
            if(BilleAttrape.estRelache){
                BilleAttrape.estPress=false;
                BilleAttrape.estRelache= false;
            }
        }
    }
