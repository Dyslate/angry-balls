package decorator.decorateur;
import decorator.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
public class DecorateurPesenteur extends DecorateurBille {
    public Vecteur acceleration;
    protected DecorateurPesenteur(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }
}
