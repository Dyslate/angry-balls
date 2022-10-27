package decorator;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public class testDecorateur {
    public static void main(String[] args) {
        Vecteur  vitesse = new Vecteur(1,1);
        Vecteur  position = new Vecteur(2,2);
        double rayon = 5.0;
        Color couleur = Color.RED;

        Vecteur  acceleration = new Vecteur(3,3);
        BilleDP b = new BilleDP();
        System.out.println("Acceleration avant : "+b.getAcceleration());
        new Pesenteur(b,acceleration);
        System.out.println("Acceleration après : "+b.getAcceleration());
        new Pesenteur(b,new Vecteur(5,5));
        System.out.println("Acceleration encore après : "+b.getAcceleration());
    }
}
