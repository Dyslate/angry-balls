package decorator;


import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;
import modele.OutilsBille;

import java.awt.*;
import java.util.Vector;

public abstract class DecorateurBille extends Bille {

    protected Bille bille;

    public DecorateurBille(Bille b) {
        this.bille = b;
    }

    @Override
    public Vecteur getPosition(){return this.bille.getPosition();}
    @Override
    public Vecteur getVitesse(){return this.bille.getVitesse();}

    @Override
    public Couleur getCouleur(){
        return this.bille.getCouleur();
    }
    @Override
    public double getRayon(){return this.bille.getRayon();}

    @Override
    public Vecteur getAcceleration(){return this.bille.getAcceleration();}
    @Override
    public int getClef(){return this.bille.getClef();}

    @Override
    public double masse(){return this.bille.masse();}
   @Override
    public void deplacer(double deltaT){
       Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(),
               deltaT);
    }

    @Override
    public Vecteur gestionAcceleration(Vector<Bille> billes){
        return bille.gestionAcceleration(billes);
    }



    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
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
        g.setColor(bille.getCouleur().transformeAWT());            // ICI à modifier, actuellement il récupère la classe Couleur mais il veut un Color qui vient d'AWT, il faut donc transformer notre couleur en AWT et la balancer ici
    /*    System.out.println("g.getColor() "+g.getColor());
        System.out.println("bille.couleur "+bille.couleur);
        System.out.println("bille.couleur toString "+bille.couleur.toString());
*/

        g.fillOval(xMin, yMin, width, height);
        g.drawOval(xMin,yMin,width,height);
    }
    @Override
    public String toString(){
        return "position = " + getPosition() + " rayon = " + getRayon() + " vitesse = " + getVitesse() + " acceleration = "
                + getAcceleration()  + "clef = " + getClef();
    }
}
