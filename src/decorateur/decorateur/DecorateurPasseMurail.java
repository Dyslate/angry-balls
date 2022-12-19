package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import modele.Bille;
public class DecorateurPasseMurail extends DecorateurBille {
    public DecorateurPasseMurail(Bille b) {
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
