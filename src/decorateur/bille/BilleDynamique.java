package decorateur.bille;
import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;
import modele.OutilsBille;
import observateur.ObservateurCollision;

import java.awt.*;
import java.util.Vector;
public class BilleDynamique extends Bille {

    public Vecteur position; // centre de la bille
    public double rayon; // rayon > 0
    public Vecteur vitesse;
    public Vecteur acceleration;

    public int clef; // identifiant unique de cette bille
    public Couleur couleur;
    private static int prochaineClef = 0;
    public static double ro = 1; // masse volumique

    public ObservateurCollision inscrit;


    public BilleDynamique(Vecteur position, double rayon, Vecteur vitesse, Couleur couleur) {
        this.position=position;
        this.rayon=rayon;
        this.vitesse=vitesse;
        this.couleur=couleur;
        this.clef = prochaineClef++;
    }

    public BilleDynamique(Vecteur position, double rayon, Vecteur vitesse, Vecteur acceleration, Couleur couleur, ObservateurCollision obs) {
        this.position=position;
        this.rayon=rayon;
        this.vitesse=vitesse;
        this.couleur=couleur;
        this.acceleration = acceleration;
        this.clef = prochaineClef++;
        this.inscription(obs);
        this.inscrit = obs;
    }

    public BilleDynamique() {
        this.position=new Vecteur(0,0);
        this.rayon=25;
        this.vitesse=new Vecteur(0,0);
        this.couleur= new Couleur(100,100,100,100);
        this.acceleration=new Vecteur(0,0);
        this.clef = prochaineClef++;
    }

    public BilleDynamique(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Couleur couleur) {
        this.position = centre;
        this.rayon = rayon;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.vitesse = vitesse;
        this.clef = prochaineClef++;
    }
    @Override
    public Vecteur getPosition() {
        return position;
    }

    @Override
    public boolean estPilotable(){
        return false;
    }

    @Override
    public double getRayon() {
        return rayon;
    }

    @Override
    public void setRayon(double rayon) {this.rayon = rayon;}
    @Override
    public Vecteur getVitesse() {
        return vitesse;
    }

    @Override
    public Vecteur getAcceleration() {
        return acceleration;
    }

    @Override
    public int getClef() {
        return clef;
    }

    @Override
    public double masse() {
        return ro * Geop.volumeSphère(rayon);
    }


    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        if (inscrit == null) {
            return super.gestionCollisionBilleBille(billes);
        } else {
            return this.inscrit.gestionCollisionMultiple(this, billes);
        }
    }

    public Couleur getCouleur() {
        return couleur;
    }
    @Override
    public void setCouleur(Couleur coul) {this.couleur = coul;}
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

    @Override
    public void dessine(Graphics g) {
    		int width, height;
    		int xMin, yMin;
    		xMin = (int) Math.round(getPosition().x - getRayon());
    		yMin = (int) Math.round(getPosition().y - getRayon());
    		width = height = 2 * (int) Math.round(getRayon());
    		g.setColor(couleur.transformeAWT());
    		g.fillOval(xMin, yMin, width, height);
    		g.setColor(Color.CYAN);
    		g.drawOval(xMin,yMin,width,height);
    }

    @Override
    public String toString() {
            return "centre = " + getPosition() + " rayon = " + getRayon() + " vitesse = " + getVitesse() + " acceleration = "
                    + getAcceleration() + " couleur = " + couleur + "clef = " + getClef();
    }
}
