package decorator;

import java.awt.Color;
import java.io.File;
import java.util.Vector;

import base.AnimationBilles;
import base.EcouteurBoutonArreter;
import base.EcouteurBoutonLancer;
import base.OutilsConfigurationBilleHurlante;
import decorator.bille.BilleDVD;
import decorator.bille.BilleDynamique;
import decorator.decorateur.*;
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

        int choixHurlementInitial = 0;
        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes, hurlements, choixHurlementInitial);

        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------

        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard(); // abscisse maximal
        yMax = cadre.hauteurBillard(); // ordonnee maximale

        double rayon = 0.15 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais
        // ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
        // au demarrage.
        // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

        p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
        v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------
        BilleDynamique b1 = new BilleDynamique();
     //   System.out.println(b1);
        DecorateurBille b2 = new DecorateurPasseMurail(new DecorateurCouleur(new BilleDynamique(), Couleur.couleurDuSex));
        DecorateurBille b3 = new BilleDVD(new DecorateurCouleur(new BilleDynamique(p2,rayon,v2,new Vecteur(0,0.0025),Couleur.rouge),Couleur.vert));
        DecorateurBille b4 = new DecorateurPesenteurRebond(new DecorateurCouleur(new BilleDynamique(p3,rayon,v3,new Vecteur(0,0.0025),Couleur.rouge),Couleur.jaune),new Vecteur(0,0.00001));
        DecorateurBille b5= new DecorateurSon(new DecorateurCouleur(new BilleDynamique(p3,rayon,v3,new Vecteur(0,0.0025),Couleur.rouge),Couleur.jaune),hurlements[choixHurlementInitial], cadre);

        //Une bille normale colorée
        billes.add(b2);

        //Bille passe muraille
     //   billes.add(b2);

        //Bille rebondissante de type fond d'écran windows
      //  billes.add(b3);

        //Bille pesenteur avec rebond //TODO DEBUG L'ACCELERATION DECROISSANTE
      //  billes.add(b4);
       // System.out.println(b4);

        //Bille Hurlante //TODO DEBUG L'ACCELERATION
       // cadre.addChoixHurlementListener((ItemListener) b5);
     //   billes.add(b5);




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
