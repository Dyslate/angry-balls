package decorateur;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class DecorateurBilleArret extends DecorateurBille {
    public DecorateurBilleArret(Bille b) {
        super(b);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, hauteur);
    }

}
