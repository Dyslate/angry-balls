package decorateur.decorateur;
import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

public class DecorateurPesenteur extends DecorateurBille {
    Vecteur acceleration;
    public DecorateurPesenteur(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }

    @Override
    public Vecteur gestionAcceleration(Vector<Bille> billes)
    {
        bille.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        getAcceleration().ajoute(this.acceleration);          // contribution du champ de pesanteur (par exemple)
        return this.getAcceleration();
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

    }
}
