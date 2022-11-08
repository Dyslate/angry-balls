package decorator;


import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.awt.*;

public class BilleDynamique extends Bille {
    protected BilleDynamique(Vecteur centre, double rayon, Vecteur vitesse, Vecteur accélération, Color couleur) {
        super(centre, rayon, vitesse, accélération, couleur);
    }
    protected BilleDynamique(Bille b){
        super(b);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {

    }
}
