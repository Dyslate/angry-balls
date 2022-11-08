package decorator;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;



public class Pesenteur extends DecorateurBille {
    protected Pesenteur(Bille b, Vecteur accel) {
        super(b);
        b.accélération=accel;
    }
}
