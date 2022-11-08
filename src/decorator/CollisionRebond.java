package decorator;

import mesmaths.cinematique.Collisions;
import modele.Bille;
public class CollisionRebond extends DecorateurBille {
    protected CollisionRebond(Bille b) {
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);    }
}
