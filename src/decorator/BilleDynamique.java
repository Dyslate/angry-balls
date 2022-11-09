package decorator;
import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;
import java.awt.*;
import java.util.Vector;
public class BilleDynamique extends Bille {
    double rayon;
    Vecteur vitesse;
    Vecteur position;



    Color couleur;

    public BilleDynamique(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
        this.position=position;
        this.rayon=rayon;
        this.vitesse=vitesse;
        this.couleur=couleur;
    }


    protected BilleDynamique(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur) {
        this.position = centre;
        this.rayon = rayon;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.vitesse = vitesse;
    }
    @Override
    public Vecteur getPosition() {
        return position;
    }

    @Override
    public double getRayon() {
        return rayon;
    }
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
        return ro;
    }

    @Override
    public void deplacer(double deltaT) {
        Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(),
        				deltaT);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
    }
    public Color getCouleur() {
        return couleur;
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(),
                abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(),
                ordonneeCoinHautGauche, hauteur);
    }

    @Override
    public void dessine(Graphics g) {
    		int width, height;
    		int xMin, yMin;
    		xMin = (int) Math.round(getPosition().x - getRayon());
    		yMin = (int) Math.round(getPosition().y - getRayon());
    		width = height = 2 * (int) Math.round(getRayon());
    		g.setColor(couleur);
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
