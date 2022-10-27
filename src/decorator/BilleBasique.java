package decorator;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public abstract class BilleBasique {
    Vecteur position;
    Vecteur vitesse;
    Vecteur acceleration;
    double rayon;
    Color couleur;

    public Vecteur getPosition() {
        return position;
    }

    public void setPosition(Vecteur position) {
        this.position = position;
    }

    public Vecteur getVitesse() {
        return vitesse;
    }

    public void setVitesse(Vecteur vitesse) {
        this.vitesse = vitesse;
    }

    public Vecteur getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vecteur acceleration) {
        this.acceleration = acceleration;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

}
