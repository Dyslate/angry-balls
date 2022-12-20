package decorateur.decorateur;
import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

public class DecorateurPesanteur extends DecorateurBille {
    Vecteur acceleration;
    public static Vecteur gravite = new Vecteur(0, 0.025);
    public DecorateurPesanteur(Bille b) {
        super(b);
        this.acceleration = gravite;
    }
    public DecorateurPesanteur(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes)
    {
        bille.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        getAcceleration().ajoute(this.acceleration);          // contribution du champ de pesanteur (par exemple)
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }
}
