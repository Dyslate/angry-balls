package decorateur.decorateur;
import decorateur.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
public class DecorateurVitesse extends DecorateurBille {
    public Vecteur vitesse;
    protected DecorateurVitesse(Bille b, Vecteur vitesse) {
        super(b);
        this.vitesse=vitesse;
    }
}
