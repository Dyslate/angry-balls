package decorateur;

import java.io.File;
import java.util.Vector;

import base.OutilsConfigurationBilleHurlante;
import decorateur.decorateur.DecorateurBilleDVD;
import decorateur.bille.BilleDynamique;
import decorateur.decorateur.*;
import decorateur.decorateur.DecorateurPilote;
import decorateur.decorateur.state.ControleurGeneral;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;
import musique.SonLong;
import observateur.ObservateurCollision;
import observateur.ObservateurSonCollision;
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

        int choixHurlementInitial = 2;
        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes, hurlements, choixHurlementInitial);

        //Initialiser le controlleur générale
        new ControleurGeneral(cadre);



        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------

        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard(); // abscisse maximal
        yMax = cadre.hauteurBillard(); // ordonnee maximale

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais
        // ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, p5, p6, p7, p8,
                v0, v1, v2, v3, v4, v5, v6, v7, v8; // les positions des centres des billes et les vecteurs vitesse
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
        p7 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p8 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v6 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v7 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v8 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);


//--------------- ici commence la partie à changer ---------------------------------
        // Création Observateur Collisions
        ObservateurCollision observateur = new ObservateurCollision();

        //Création des billes dynamiques

        BilleDynamique bd1 = new BilleDynamique(p2,rayon,v2,new Vecteur(0,0.0025),Couleur.rouge, observateur);
        BilleDynamique bd2 = new BilleDynamique(p3,rayon,v3,new Vecteur(0,0.0025),Couleur.jaune, observateur);
        BilleDynamique bd3 = new BilleDynamique(p4,rayon,v4,new Vecteur(0,0.0025),Couleur.noir, observateur);
        BilleDynamique bd4 = new BilleDynamique(p1,rayon,v1,new Vecteur(0.05,0.0025),Couleur.bleu, observateur);
        BilleDynamique bd5 = new BilleDynamique(p0,rayon,v0,new Vecteur(0,0.0025),Couleur.rose, observateur);
        BilleDynamique bd6 = new BilleDynamique(p5, rayon, v5, new Vecteur(0, 0.0025), Couleur.mauve, observateur);
        BilleDynamique bd7 = new BilleDynamique(p6, rayon, v6, new Vecteur(0, 0.0025), Couleur.orange, observateur);
        BilleDynamique bd8 = new BilleDynamique(p7, rayon, v7, new Vecteur(0, 0.0025), Couleur.noir, observateur);
        BilleDynamique bd9 = new BilleDynamique(p8, rayon, v8, new Vecteur(0, 0.0025), Couleur.couleurSnoopDog, observateur);

        DecorateurBille b1 = new DecorateurPasseMurail(bd1);
        DecorateurBille b2 = new DecorateurPilote(new DecorateurBilleDVD(bd2));
        DecorateurBille b3 = new DecorateurSon(bd3,hurlements[choixHurlementInitial], cadre);
        DecorateurBille b4 = new DecorateurPesanteur(bd4,new Vecteur(0,0.001));
        DecorateurBille b5 = new DecorateurFrottement(new DecorateurPesanteur(bd5,new Vecteur(0,0.025)));
        DecorateurBille b6 = new DecorateurBilleNewton(new DecorateurBilleArret(bd6));
        DecorateurBille b7 = new DecorateurPilote(bd7);
        DecorateurBille b8 = new DecorateurLancePierre(bd8);
        DecorateurBille b9 = new DecorateurPoissonGlobe(new DecorateurBilleDVD(bd9));

        //Bille passe muraille
        billes.add(b1);

        //Bille DVD
        billes.add(b2);

        //Bille Hurlante
        //cadre.addChoixHurlementListener((ItemListener) b5);
        //billes.add(b3);

        //Bille rebondissante
        billes.add(b4);

        // Bille frottement
        billes.add(b5);

        // Bille Newton avec arrêt
        billes.add(b6);

        //Test Bille piloté
        billes.add(b7);

        //Test Bille LancePierre
        billes.add(b8);

        //Test bille Pufferfish
        billes.add(b9);

        // System.out.println(billes);
        cadre.createBufferStrategy(2);

//---------------------- ici finit la partie e changer -------------------------------------------------------------

        System.out.println("billes = " + billes);
    }
}
