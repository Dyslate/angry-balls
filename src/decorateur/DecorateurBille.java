package decorateur;


import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;

import java.awt.*;
import java.util.Vector;

/**
 * Classe abstraite pour implémenter le décorateur à angry-balls.
 */
public abstract class DecorateurBille extends Bille {

    protected Bille bille;


    public DecorateurBille(Bille b) {
        this.bille = b;
    }

    @Override
    public void enleverInscrit() {this.bille.enleverInscrit();}

    @Override
    public Vecteur getPosition(){return this.bille.getPosition();}
    @Override
    public Vecteur getVitesse(){return this.bille.getVitesse();}

    @Override
    public Couleur getCouleur(){
        return this.bille.getCouleur();
    }
    public void setCouleur(Couleur coul) {this.bille.setCouleur(coul);}
    @Override
    public double getRayon(){return this.bille.getRayon();}

    @Override
    public void setRayon(double rayon) {this.bille.setRayon(rayon);}
    @Override
    public Vecteur getAcceleration(){return this.bille.getAcceleration();}
    @Override
    public int getClef(){return this.bille.getClef();}

    @Override
    public boolean inscrit() {
        return this.bille.inscrit();
    }

    @Override
    public double masse(){return this.bille.masse();}

    @Override
    public boolean estPilotable(){
        return false;
    }

    public void gestionAcceleration(Vector<Bille> billes) {
        this.bille.gestionAcceleration(billes);
    }
    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return this.bille.gestionCollisionBilleBille(billes);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        this.bille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

    @Override
    public void dessine(Graphics g) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(getPosition().x - getRayon());
        yMin = (int) Math.round(getPosition().y - getRayon());
        width = height = 2 * (int) Math.round(getRayon());
        g.setColor(bille.getCouleur().transformeAWT());
        g.fillOval(xMin, yMin, width, height);
        g.drawOval(xMin,yMin,width,height);

    }




    @Override
    public String toString(){
        return "position = " + getPosition() + " rayon = " + getRayon() + " vitesse = " + getVitesse() + " acceleration = "
                + getAcceleration()  + "clef = " + getClef();
    }
}
