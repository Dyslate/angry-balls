package modele;

import java.awt.*;
import java.util.Observable;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Vecteur;
import observateur.InscriptionCollision;
import observateur.ObservateurCollision;

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
public abstract class Bille implements InscriptionCollision {
//----------------- classe Bille-------------------------------------

	public abstract Vecteur getPosition();
	public abstract double getRayon();
	public abstract void setRayon(double rayon);
	public abstract Couleur getCouleur();
	public abstract void setCouleur(Couleur coul);
	public abstract Vecteur getVitesse();
	public abstract Vecteur getAcceleration();
	public abstract int getClef();
	public abstract double masse();
	public void deplacer(double deltaT) {
		Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
	}
	public abstract void gestionAcceleration(Vector<Bille> billes);
	public boolean gestionCollisionBilleBille(Vector<Bille> billes){
		return OutilsBille.gestionCollisionBilleBille(this,billes);
	}

	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur);
	public void inscription(ObservateurCollision obs) {
		obs.ajouteBille(this);
	}
	public abstract void dessine(Graphics g);
	public abstract String toString();

	public abstract boolean estPilotable();
}
