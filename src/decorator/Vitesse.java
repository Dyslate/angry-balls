package decorator;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
public class Vitesse extends DecorateurBille {
    Vecteur vitesse;
    protected Vitesse(Bille b, Vecteur vitesse) {
        super(b);
        this.vitesse=vitesse;
    }
}
