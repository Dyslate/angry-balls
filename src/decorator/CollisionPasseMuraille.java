package decorator;

import mesmaths.cinematique.Collisions;
import modele.Bille;
public class CollisionPasseMuraille extends DecorateurBille {
    protected CollisionPasseMuraille(Bille b) {
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
