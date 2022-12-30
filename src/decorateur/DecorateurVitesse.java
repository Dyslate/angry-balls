package decorateur;
import decorateur.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

/**
 * Decorateur permettant de modifier la vitesse d'une bille.
 */
public class DecorateurVitesse extends DecorateurBille {
    public Vecteur vitesse;
    protected DecorateurVitesse(Bille b, Vecteur vitesse) {
        super(b);
        this.vitesse=vitesse;
    }
}
