package modele;

import java.awt.*;
import java.util.HashMap;

/* COULEUR STOCKEE SUR UN INT
            Sur 32 bits (little endian) :
                                    0-7 :         red
                                    8-15: :      green
                                    16-23 :     blue
                                    24-31:     alpha
         */
public class Couleur {
    // COULEURS PREDEFINIES
    public static Couleur noir = new Couleur(0,0,0,255);
    public static Couleur blanc = new Couleur(255,255,255,255);
    public static Couleur vert = new Couleur(0,255,0,255);
    public static Couleur bleu = new Couleur(0,0,255,255);
    public static Couleur rouge = new Couleur(255,0,0,255);
    public static Couleur jaune = new Couleur(255,255,0,255);
    public static Couleur mauve = new Couleur(190,0,255,255);
    public static Couleur grisUltraStylé = new Couleur(51,51,51,100);
    public static Couleur couleurDuSex = new Couleur(69,69,69,69);
    public static Couleur couleurDuWeed = new Couleur(42,04,20,42); // 0 BLAZE IT



    public long couleur;

    public Couleur() {
        this.couleur = 0xff;
    }
    public Couleur(long r, long g, long b, long a) {
        if (!testCouleur(r) || !testCouleur(g) || !testCouleur(b) || !testCouleur(a)) {
            this.couleur = 0xff;
        } else {
            this.couleur = r << 24 | g << 16 | b << 8 | a;
        }
    }


    public String toString(){

        return "Couleur (r,g,b,a): ("+ ((couleur & 0xff000000)>>24)+","+((couleur & 0xff0000)>>16)+","+((couleur & 0xff00)>>8)+","+((couleur & 0xff))+")";
    }

    public boolean testCouleur(long c) {
        return  !(c < 0 || c > 255);
    }
    public Color transformeAWT() {
        return new Color((int)((couleur & 0xff000000)>>24), (int)((couleur & 0xff0000)>>16), (int)((couleur & 0xff00)>>8), (int)(couleur & 0xff));
    }

    public int getRed() {
        return (int) (couleur & 0xff000000>>24);
    }
}