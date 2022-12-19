package vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import modele.Bille;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
public class Billard extends Canvas {
	Vector<Bille> billes;

	public Billard(Vector<Bille> billes) {
		this.billes = billes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		int i;

		for (i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graphics);

		 System.out.println("billes dans le billard = " + billes);
	}

	public void render(Graphics graph) {		// en vue de supprimer la dépendance avec AWT
		int i;
		graph.clearRect(0, 0, getWidth(), getHeight());
		for(i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).dessine(graph);
	}

}
