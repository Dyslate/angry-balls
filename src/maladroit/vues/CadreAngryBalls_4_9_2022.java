package maladroit.vues;

import java.awt.*;
import java.util.Vector;

import maladroit.modele.BilleMaladroit;


import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contr�le (arr�t du programme, lancer les billes, arr�ter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls_4_9_2022 extends Frame implements VueBillardMaladroit
{
TextField presentation;
BillardMaladroit billard;
public Button lancerBilles, arreterBilles;
Panel haut, centre, bas;

EcouteurTerminaison ecouteurTerminaison;

public CadreAngryBalls_4_9_2022(String titre, String message, Vector<BilleMaladroit> billes) throws HeadlessException
{
super(titre);
Outils.place(this, 0.33, 0.33, 0.5, 0.5);
this.ecouteurTerminaison = new EcouteurTerminaison(this);


this.haut = new Panel(); this.haut.setBackground(Color.LIGHT_GRAY);
this.add(this.haut,BorderLayout.NORTH);

this.centre = new Panel();
this.add(this.centre,BorderLayout.CENTER);

this.bas = new Panel(); this.bas.setBackground(Color.LIGHT_GRAY);
this.add(this.bas,BorderLayout.SOUTH);

this.presentation = new TextField(message, 100); this.presentation.setEditable(false);
this.haut.add(this.presentation);

this.billard = new BillardMaladroit(billes);
this.add(this.billard);

this.lancerBilles = new Button("lancer les billes"); this.bas.add(this.lancerBilles);
this.arreterBilles = new Button("arr�ter les billes"); this.bas.add(this.arreterBilles);

}

public double largeurBillard() 
{
return this.billard.getWidth();
}

public double hauteurBillard()
{
return this.billard.getHeight();
}

@Override
public void miseAJour()
{
this.billard.repaint();
}

/* (non-Javadoc)
 * @see exodecorateur.vues.VueBillard#montrer()
 */
@Override
public void montrer()
{
this.setVisible(true);
}



}