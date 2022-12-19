package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

public class DecorateurBilleDVD extends DecorateurBille {
    public DecorateurBilleDVD(Bille b) {
        super(b);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        getAcceleration().set(Vecteur.VECTEURNUL);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);    }
}
