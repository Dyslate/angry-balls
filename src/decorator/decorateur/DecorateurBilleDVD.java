package decorator.decorateur;

import decorator.DecorateurBille;
import mesmaths.cinematique.Collisions;
import modele.Bille;
public class DecorateurBilleDVD extends DecorateurBille {
    public DecorateurBilleDVD(Bille b) {
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);    }
}
