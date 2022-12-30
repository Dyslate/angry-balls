package decorateur;
import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;


/**
 * Decorateur permettant d'ajouter de la gravité à une bille.
 */
public class DecorateurPesanteur extends DecorateurBille {
    public Vecteur gravite = new Vecteur(0, 0.01);
    public DecorateurPesanteur(Bille b) {
        super(b);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        this.bille.getAcceleration().ajoute(this.gravite);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }
}
