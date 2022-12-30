package decorateur;
import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

public class DecorateurPesanteur extends DecorateurBille {
    public Vecteur gravite = new Vecteur(0, 0.01);
    public DecorateurPesanteur(Bille b) {
        super(b);
    }
    public DecorateurPesanteur(Bille b, Vecteur gravite) {
        super(b);
        this.gravite=gravite;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes)
    {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        this.bille.getAcceleration().ajoute(this.gravite);          // contribution du champ de pesanteur (par exemple)
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }
}
