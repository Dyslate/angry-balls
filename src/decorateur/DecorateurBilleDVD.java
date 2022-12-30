package decorateur;

import mesmaths.cinematique.Collisions;
import modele.Bille;


/**
 * Decorateur permettant à une bille de se comporter comme un certain écran de chargement Windows.
 */
public class DecorateurBilleDVD extends DecorateurBille {
    public DecorateurBilleDVD(Bille b) {
        super(b);
    }


    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);    }
}
