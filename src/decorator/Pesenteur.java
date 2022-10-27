package decorator;

import mesmaths.geometrie.base.Vecteur;


public class Pesenteur extends DecorateurBille {
    public Pesenteur(BilleBasique b, Vecteur acceleration){
        billeBasique = b;
        b.setAcceleration(acceleration);
    }
}
