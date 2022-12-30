package maladroit;

import java.awt.Color;
import java.io.IOException;
import java.util.Vector;

import base.VueBillardFactice;
import maladroit.modele.BilleMaladroit;
import maladroit.modele.BilleMvtRUPasseMurailles;
import maladroit.vues.VueBillardMaladroit;
import mesmaths.geometrie.base.Vecteur;
import vues.VueBillard;

public class TestAnimationBillesMaladroit
{

/**
 * @param args
 * @throws IOException 
 */
public static void main(String[] args) throws IOException
{
Vector<BilleMaladroit> billes = new Vector<BilleMaladroit>();

Vecteur centreBille1 = new Vecteur(110,70);
double rayonBille1 = 12;
Vecteur vitesseBille1 = new Vecteur (10,-30);
    BilleMaladroit bille1 = new BilleMvtRUPasseMurailles(centreBille1, rayonBille1, vitesseBille1, Color.blue);
billes.add(bille1);

Vecteur centreBille2 = new Vecteur(20,50);
double rayonBille2 = 15;
Vecteur vitesseBille2 = new Vecteur (5,-5);
BilleMaladroit bille2 = new BilleMvtRUPasseMurailles(centreBille2, rayonBille2, vitesseBille2, Color.blue);
billes.add(bille2);


double vmax2 = AnimationBillesMaladroit.maxVitessesCarrees(billes);
double rayonmin2 = AnimationBillesMaladroit.minRayons(billes);

System.out.println("vmax2 = " + vmax2 + "rayonMin2 = " + rayonmin2);
int c = System.in.read();

VueBillardMaladroit vueBillardFactice = new VueBillardMaladroitFacticeMaladroit();

AnimationBillesMaladroit animation = new AnimationBillesMaladroit(billes, vueBillardFactice);
animation.lancerAnimation();
}

}
