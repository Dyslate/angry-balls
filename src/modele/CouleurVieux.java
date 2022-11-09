package modele;

import exception.ExceptionCouleur;

import java.awt.*;

public class CouleurVieux {
    public int r;
    public int g;
    public int b;
    public int t;

    public CouleurVieux(int r, int g, int b, int t) throws ExceptionCouleur {
        if (testCouleur(r) || testCouleur(g) ||  testCouleur(b) || testCouleur(t)) {
            System.err.println("Votre couleur n'est pas une couleur: ["+r+"-"+g+"-"+b+"-"+t+"]" +
                    "\n Les paramètres doivent être compris entre 0 et 255");
            new CouleurVieux();
        } else {
            this.r = r;
            this.g = g;
            this.b = b;
            this.t = t;
        }
    }

    public CouleurVieux() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.t = 255;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getT() {
        return t;
    }
    public boolean testCouleur(int c) {
        return  !(c < 0 || c > 255);
    }

    public Color transforme(CouleurVieux c){
        return new Color(r,g,b,t);
    }
}
