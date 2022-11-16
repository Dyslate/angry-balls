package decorator.decorateur;
import decorator.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
public class DecorateurPesenteur extends DecorateurBille {
    Vecteur acceleration;
    public DecorateurPesenteur(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }
}
