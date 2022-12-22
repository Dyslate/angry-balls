package decorateur;

import java.awt.event.ItemListener;
import java.io.File;
import java.util.Vector;

import base.AnimationBilles;
import base.EcouteurBoutonArreter;
import base.EcouteurBoutonLancer;
import base.OutilsConfigurationBilleHurlante;
import decorateur.decorateur.DecorateurBilleDVD;
import decorateur.bille.BilleDynamique;
import decorateur.decorateur.*;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;
import musique.SonLong;
import vues.CadreAngryBalls;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * different
 *
 * Ideal pour mettre en place le DP decorator
 */
public class testDecorateur {

    /**
     * @param args
     */
    public static void main(String[] args) {
//---------------------- gestion des bruitages : parametrage du chemin du dossier contenant les fichiers audio --------------------------

        File file = new File(""); // le oe la JVM est lancee : racine du projet

        File repertoireSon = new File(file.getAbsoluteFile(),
                "src" + File.separatorChar + "bruits");
        System.out.println(repertoireSon);
//-------------------- chargement des sons pour les hurlements --------------------------------------

        Vector<SonLong> sonsLongs = OutilsConfigurationBilleHurlante.chargeSons(repertoireSon,
                "config_audio_bille_hurlante.txt");

        SonLong[] hurlements = SonLong.toTableau(sonsLongs); // on obtient un tableau de SonLong

//------------------- creation de la liste (pour l'instant vide) des billes -----------------------

        Vector<Bille> billes = new Vector<Bille>();

//---------------- creation de la vue responsable du dessin des billes -------------------------

        int choixHurlementInitial = 4;
        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes, hurlements, choixHurlementInitial);

        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------

        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard(); // abscisse maximal
        yMax = cadre.hauteurBillard(); // ordonnee maximale

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais
        // ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, p5, p6, v0, v1, v2, v3, v4, v5, v6; // les positions des centres des billes et les vecteurs vitesse
        // au demarrage.
        // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

        p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p6 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v6 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------

        DecorateurBille b3 = new DecorateurPasseMurail(new BilleDynamique(p2,rayon,v2,new Vecteur(0,0.0025),Couleur.rouge));
        DecorateurBille b4 = new DecorateurBilleDVD(new BilleDynamique(p3,rayon,v3,new Vecteur(0,0.0025),Couleur.jaune));
        DecorateurBille b5 = new DecorateurSon(new BilleDynamique(p4,rayon,v4,new Vecteur(0,0.0025),Couleur.noir),hurlements[choixHurlementInitial], cadre);
        DecorateurBille b6 = new DecorateurPesanteur(new BilleDynamique(p1,rayon,v1,new Vecteur(0.05,0.0025),Couleur.bleu),new Vecteur(0,0.001));
        DecorateurBille b7 = new DecorateurFrottement(new DecorateurPesanteur(new BilleDynamique(p0,rayon,v0,new Vecteur(0,0.0025),Couleur.rose),new Vecteur(0,0.025)));
        DecorateurBille b8 = new DecorateurBilleNewton(new DecorateurBilleArret(new BilleDynamique(p5, rayon, v5, new Vecteur(0, 0.0025), Couleur.mauve)));
        DecorateurBille b9 = new DecorateurPoissonGlobe(new DecorateurPasseMurail(new BilleDynamique(p6, rayon, v6, new Vecteur(0, 0.0025), Couleur.orange)));

        //Bille passe muraille
        billes.add(b3);

        //Bille DVD
        billes.add(b4);

        //Bille Hurlante
        cadre.addChoixHurlementListener((ItemListener) b5);
        billes.add(b5);

        //Bille rebondissante
        billes.add(b6);

        // Bille frottement
        billes.add(b7);

        // Bille Newton avec arrêt
        billes.add(b8);

        // Bille Poisson Globe + Bille Passe Muraille
        billes.add(b9);

        System.out.println(billes);
        cadre.createBufferStrategy(2);
        /*
        billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
        billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0, 0.001), Color.yellow));
        billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
        billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));

        BilleHurlanteMvtNewtonArret billeNoire; // cas particulier de la bille qui hurle

        billes.add(billeNoire = new BilleHurlanteMvtNewtonArret(p4, rayon, v4, Color.black,
                hurlements[choixHurlementInitial], cadre));

        cadre.addChoixHurlementListener(billeNoire); // e present on peut changer le son de la bille qui hurle
*/
//---------------------- ici finit la partie e changer -------------------------------------------------------------

        System.out.println("billes = " + billes);

//-------------------- creation de l'objet responsable de l'animation (c'est un thread separe) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des ecouteurs de boutons qui permettent de contreler (un peu...) l'application -----------------

        EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
        EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des ecouteurs des boutons et ea tourne tout seul ------------------------------

        cadre.lancerBilles.addActionListener(ecouteurBoutonLancer); // pourrait etre remplace par Observable - Observer
        cadre.arreterBilles.addActionListener(ecouteurBoutonArreter); // pourrait etre remplace par Observable -
        // Observer

    }

}
