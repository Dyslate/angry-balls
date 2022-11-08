package decorator;
import modele.Bille;
import java.awt.*;
public class Couleur extends DecorateurBille {
    Color couleur;
    protected Couleur(Bille b, Color couleur) {
        super(b);
        this.couleur = couleur;
    }
}
