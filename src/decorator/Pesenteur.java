package decorator;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
public class Pesenteur extends DecorateurBille {
    Vecteur acceleration;
    protected Pesenteur(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }
}
