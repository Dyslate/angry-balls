package vues;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import Bouton.Bouton;
import Bouton.BoutonArreter;
import Bouton.BoutonLancer;
import base.AnimationBilles;
import modele.Bille;
import musique.SonLong;
import observateur.ObservableBouton;
import observateur.ObservateurBouton;
import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrele (arret du
 * programme, lancer les billes, arreter les billes) et contenant la ligne des
 * boutons de choix des sons pour la bille hurlante
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
public class CadreAngryBalls extends Frame implements VueBillard {
	TextField presentation;



	public static Billard billard;
	public Button lancerBilles, arreterBilles;
	Panel haut, centre, bas, ligneBoutonsLancerArret;
	PanneauChoixHurlement ligneBoutonsChoixHurlement;

	EcouteurTerminaison ecouteurTerminaison;


	private AnimationBilles animationBilles;


	public CadreAngryBalls(String titre, String message, Vector<Bille> billes, SonLong[] hurlements,
			int choixHurlementInitial) throws HeadlessException {
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);

		//Si on enlève ça y a un probleme pour quitter la partie!
		this.ecouteurTerminaison = new EcouteurTerminaison(this);

		this.haut = new Panel();
		this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut, BorderLayout.NORTH);

		this.centre = new Panel();
		this.add(this.centre, BorderLayout.CENTER);

		this.bas = new Panel();
		this.bas.setBackground(Color.LIGHT_GRAY);
		this.add(this.bas, BorderLayout.SOUTH);


		Bouton boutonLancer = new BoutonLancer("Lancer les billes");
		bas.add(boutonLancer);

		Bouton boutonArreter = new BoutonArreter("Arrêter les billes");
		bas.add(boutonArreter);

		animationBilles = new AnimationBilles(billes, this);

		//Lambda expression
		boutonLancer.ajoutObservateur(this::onClickLance);
		boutonArreter.ajoutObservateur(this::onClickArrete);


		this.presentation = new TextField(message, 100);
		this.presentation.setEditable(false);
		this.haut.add(this.presentation);

		billard = new Billard(billes);
		this.add(billard);

//------------------- placement des composants du bas du cadre -------------------------------

		int nombreLignes = 2, nombreColonnes = 1;

		this.bas.setLayout(new GridLayout(nombreLignes, nombreColonnes));

//---------------- placement des boutons lancer - arreter ------------------------------------
		//Pu besoin de ça: on a l'observateur et l'observable
/*
		this.ligneBoutonsLancerArret = new Panel();
		this.bas.add(this.ligneBoutonsLancerArret);

		this.lancerBilles = new Button("lancer les billes");
		this.ligneBoutonsLancerArret.add(this.lancerBilles);
		this.arreterBilles = new Button("arreter les billes");
		this.ligneBoutonsLancerArret.add(this.arreterBilles);
*/
//---------------- placement de la ligne de boutons de choix des sons pour le hurlement ------


		//Ici il faut mettre l'observeur de sons!
		this.ligneBoutonsChoixHurlement = new PanneauChoixHurlement(hurlements, choixHurlementInitial);
		this.bas.add(this.ligneBoutonsChoixHurlement);

	}

	public double largeurBillard() {
		return billard.getWidth();
	}

	public double hauteurBillard() {
		return billard.getHeight();
	}

	@Override
	public void miseAJour() {
		// BufferStrategy pour l'Active Rendering
		BufferStrategy buffer = billard.getBufferStrategy();
		Graphics graph = buffer.getDrawGraphics();
		graph.clearRect(0,0,getWidth(),getHeight());
		billard.paint(graph);
		graph.dispose();
		buffer.show();
		// OLD : this.billard.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer() {
		this.setVisible(true);
		// Active Rendering
		billard.createBufferStrategy(2);
		billard.setIgnoreRepaint(true);
	}

	public void addChoixHurlementListener(ItemListener ecouteurChoixHurlant) {
		int i;

		for (i = 0; i < this.ligneBoutonsChoixHurlement.boutons.length; ++i)
			this.ligneBoutonsChoixHurlement.boutons[i].addItemListener(ecouteurChoixHurlant);

	}


	public Billard getBillard() {
		return billard;
	}

	private void onClickArrete(ObservableBouton observable, Object arg) {
		animationBilles.arreterAnimation();
	}

	private void onClickLance(ObservableBouton observable, Object arg) {
		animationBilles.lancerAnimation();
	}
}