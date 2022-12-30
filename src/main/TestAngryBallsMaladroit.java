package main;

import java.awt.Color;
import java.io.File;
import java.util.Vector;

import maladroit.AnimationBillesMaladroit;
import maladroit.EcouteurBoutonArreter;
import maladroit.EcouteurBoutonLancer;
import maladroit.OutilsConfigurationBilleHurlante;
import maladroit.modele.*;
import maladroit.vues.CadreAngryBallsMaladroit;
import mesmaths.geometrie.base.Vecteur;
import musique.SonLong;



/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 * */
public class TestAngryBallsMaladroit
{

/**
 * @param args
 */
public static void main(String[] args)
{
//---------------------- gestion des bruitages : param�trage du chemin du dossier contenant les fichiers audio --------------------------

File file = new File(""); // l� o� la JVM est lanc�e : racine du projet

    File repertoireSon = new File(file.getAbsoluteFile(),
            "src" + File.separatorChar + "bruits");

//-------------------- chargement des sons pour les hurlements --------------------------------------

Vector<SonLong> sonsLongs = OutilsConfigurationBilleHurlante.chargeSons(repertoireSon, "config_audio_bille_hurlante.txt");
 
SonLong hurlements[] = SonLong.toTableau(sonsLongs);                // on obtient un tableau de SonLong

//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

Vector<BilleMaladroit> billes = new Vector<BilleMaladroit>();

//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

int choixHurlementInitial = 0;
CadreAngryBallsMaladroit cadre = new CadreAngryBallsMaladroit("Angry balls",
                                        "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator",
                                        billes,hurlements, choixHurlementInitial);

cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();      // abscisse maximal
yMax = cadre.hauteurBillard();      // ordonn�e maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au d�marrage. 
                                                    // Elles vont �tre choisies al�atoirement

//------------------- cr�ation des vecteurs position des billes ---------------------------------

p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie � changer ---------------------------------

billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));

BilleHurlanteMvtNewtonArret billeNoire;         // cas particulier de la bille qui hurle

billes.add(billeNoire = new BilleHurlanteMvtNewtonArret(p4, rayon, v4,  Color.black,hurlements[choixHurlementInitial], cadre));

cadre.addChoixHurlementListener(billeNoire);  // � pr�sent on peut changer le son de la bille qui hurle

//---------------------- ici finit la partie � changer -------------------------------------------------------------

System.out.println("billes = " + billes);


//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

AnimationBillesMaladroit animationBilles = new AnimationBillesMaladroit(billes, cadre);

//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------

EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------


cadre.lancerBilles.addActionListener(ecouteurBoutonLancer);             // pourrait �tre remplac� par Observable - Observer
cadre.arreterBilles.addActionListener(ecouteurBoutonArreter);           // pourrait �tre remplac� par Observable - Observer



}

}
