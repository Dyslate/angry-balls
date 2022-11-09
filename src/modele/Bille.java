package modele;

import java.awt.*;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/**
 * Cas general d'une bille de billard
 * 
 * Aucune des classes du package maladroit.modele ne doit faire de reference e
 * des classes de java.awt ni e aucune autre librairie graphique JAVA car le
 * modele NE DOIT PAS dependre de la vue !!! Vous devez faire les modifications
 * en consequence !! Exploitez les Design Patterns.
 * 
 * On rappelle que ces references e une librairie graphique sont nefastes car si
 * on change de librairie graphique, voire on fait migrer le projet sur android,
 * il faut modifier les classes du modele. La maintenance devient catastrophique
 * 
 * A MODIFIER
 * 
 * 
 */
public abstract class Bille {
//----------------- classe Bille-------------------------------------
	public Vecteur position; // centre de la bille
	public double rayon; // rayon > 0
	public Vecteur vitesse;
	public Vecteur acceleration;

	public int clef; // identifiant unique de cette bille
	public Couleur couleur;
	private static final int prochaineClef = 0;
	public static double ro = 1; // masse volumique
	public abstract Vecteur getPosition();
	public abstract double getRayon();
	public abstract Vecteur getVitesse();
	public abstract Vecteur getAcceleration();
	public abstract int getClef();
	public abstract double masse();
	public abstract void deplacer(double deltaT);
	public abstract void gestionAcceleration(Vector<Bille> billes);
	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur);
	public abstract void dessine(Graphics g);
	public abstract String toString();
}
