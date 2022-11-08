package decorator;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.awt.*;


public class Couleur extends DecorateurBille {
    protected Couleur(Bille b, Color couleur) {
        super(b);
        b.couleur = couleur;
    }
}
