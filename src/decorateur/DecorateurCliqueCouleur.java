package decorateur;

import etats.BilleAttrape;
import modele.Bille;
import modele.Couleur;

import java.util.Vector;

/**
 * Decorateur permettant à une bille se changer de couleur par une couleur aléatoire via un click souris.
 */
public class DecorateurCliqueCouleur extends DecorateurBille {
    public DecorateurCliqueCouleur(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        if(BilleAttrape.estPress&&BilleAttrape.estRelache&&this.getClef()==BilleAttrape.billeCourante) {
            bille.setCouleur(Couleur.getRandomCouleur());
            BilleAttrape.estPress=false;
            BilleAttrape.estRelache=false;
        }
    }
}