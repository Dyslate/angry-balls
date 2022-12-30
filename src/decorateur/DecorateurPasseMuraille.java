package decorateur;

import mesmaths.cinematique.Collisions;
import modele.Bille;

/**
 * Decorateur permettant à une bille de traverser les murs.
 */
public class DecorateurPasseMuraille extends DecorateurBille {
    public DecorateurPasseMuraille(Bille b) {
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
