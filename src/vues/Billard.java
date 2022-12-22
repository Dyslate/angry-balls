package vues;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
public class Billard extends Canvas  {
	public Vector<Bille> billes;
	public static boolean estPress = false;
	public static double posX = -1;
	public static double posY = -1;
	public static int billeCourante = 0;


	public static double posSouris1X = -1;
	public static double posSouris1Y = -1;
	public static double posSouris2X = -1;
	public static double posSouris2Y = -1;

	public static Vecteur vitesseSouris = new Vecteur(-1,-1);

	public Billard(Vector<Bille> billes) {
		this.billes = billes;
	//	this.addMouseMotionListener(this);
//		this.addMouseListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		int i;
		for (i = 0; i < this.billes.size(); ++i){
			this.billes.get(i).dessine(graphics);
		}
		// System.out.println("billes dans le billard = " + billes);
	}


/*
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
	}

	@Override
	public void mousePressed(MouseEvent e){
		posSouris1X = e.getX();
		posSouris1Y = e.getY();

		System.out.println("pressed");
		for (int i = 0; i < this.billes.size(); ++i){
			if (e.getX() > billes.get(i).getPosition().x - billes.get(i).getRayon() && e.getX() < billes.get(i).getPosition().x + billes.get(i).getRayon()) {
				if (e.getY() > billes.get(i).getPosition().y - billes.get(i).getRayon() && e.getY() < billes.get(i).getPosition().y + billes.get(i).getRayon()) {
					if (billes.get(i).estPilotable()) {
						billeCourante = i;
						estPress = true;
						System.out.println("La bille " + billes.get(i).getCouleur() + " a été clické!");
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("released");
		estPress = false;
		posSouris2X = e.getX();
		posSouris2Y = e.getY();
		vitesseSouris = new Vecteur(0.00001*(posSouris2X-posSouris1X),0.00001*(posSouris2Y-posSouris1Y));
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragged");
		if(estPress&&vitesseSouris.x!=-1&&vitesseSouris.y!=-1){
			posX = e.getX();
			posY = e.getY();

			this.billes.get(billeCourante).getAcceleration().ajoute(vitesseSouris);

			System.out.println(vitesseSouris);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
*/
}
