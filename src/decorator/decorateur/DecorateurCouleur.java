package decorator.decorateur;
import decorator.DecorateurBille;
import modele.Bille;
import modele.Couleur;

import java.awt.*;
public class DecorateurCouleur extends DecorateurBille {
    public DecorateurCouleur(Bille b, Couleur couleur) {
        super(b);
        bille.couleur = couleur;
    }
}
