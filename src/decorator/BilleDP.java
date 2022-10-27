package decorator;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public class BilleDP extends BilleBasique{
    public BilleDP(){
        setAcceleration(new Vecteur(1,1));
        setCouleur(Color.BLACK);
        setRayon(5.0);
        setVitesse(new Vecteur(2,2));
        setPosition(new Vecteur(3,3));
    }
}
