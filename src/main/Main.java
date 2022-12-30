package main;

import java.awt.event.ItemListener;
import java.io.File;
import java.util.Vector;

import base.OutilsConfigurationBilleHurlante;
import decorateur.*;
import modele.BilleDynamique;
import etats.ControleurGeneral;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;
import musique.SonLong;
import observateur.ObservateurCollisionBille;
import observateur.ObservateurSonCollision;
import vues.CadreAngryBalls;
import vues.Scenario;


/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * different
 *
 * Ideal pour mettre en place le DP decorator
 */
public class Main {

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
        Vector<SonLong> sonBillard = OutilsConfigurationBilleHurlante.chargeSons(repertoireSon, "config_audio_billard.txt");

        SonLong[] hurlements = SonLong.toTableau(sonsLongs); // on obtient un tableau de SonLong
        SonLong[] choc = SonLong.toTableau(sonBillard);
//------------------Chargement des différents scénarios----------------------------------------------

        Scenario scenario1 = new Scenario("Scenario1");
        Scenario scenario2 = new Scenario("Scenario2");

        Scenario[] scenarios=new Scenario[2];
        scenarios[0]=scenario1;
        scenarios[1]=scenario2;

        Scenario lesScenarios = new Scenario(scenarios);

//------------------- creation de la liste (pour l'instant vide) des billes -----------------------

        Vector<Bille> billesS1 = new Vector<>();
        Vector<Bille> billesS2 = new Vector<>();

//---------------- creation de la vue responsable du dessin des billes -------------------------

        int choixHurlementInitial = 2;
        int choixScenarioInitial = 0;
        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Application pour test DP Decorateur / DP Observer / DP State",
                billesS1, hurlements, choixHurlementInitial, scenarios,choixScenarioInitial);

        //Initialiser le controlleur générale
        new ControleurGeneral(cadre);

        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------

        double xMax, yMax, xMilieu, yMilieu;
        double vMax = 0.1;
        xMax = cadre.largeurBillard(); // abscisse maximal
        xMilieu = xMax/2;
        yMax = cadre.hauteurBillard(); // ordonnee maximale
        yMilieu = yMax/2;

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais
        // ce n'est pas obligatoire
//--------------- ici commence la partie à changer ---------------------------------
        // Création partie Scénario 1
            // Création Observateur Collisions
        ObservateurCollisionBille observateurScenario1 = new ObservateurCollisionBille();
            // Création des vecteurs de position, d'accélération et de vitesse pour le scénario 1
        Vecteur p0s1, p1s1, p2s1, p3s1, p4s1,        // Position X Scénario Y
                v0s1, v1s1, v2s1, v3s1, v4s1,        // Vitesse X Scénario Y
                a0s1, a1s1, a2s1, a3s1, a4s1;         // Accélération X Scénario Y

        p0s1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p1s1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p2s1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p3s1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p4s1 = Vecteur.créationAléatoire(0,0, xMax, yMax);

        v0s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v1s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v2s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v3s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v4s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

        a0s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        a1s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        a2s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        a3s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        a4s1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

            // Création Billes dynamiques pour le Scénario 1
        BilleDynamique bd0s1 = new BilleDynamique(p0s1, rayon*1.2, v0s1, a0s1, Couleur.rouge, observateurScenario1);
        BilleDynamique bd1s1 = new BilleDynamique(p1s1, rayon*2, v1s1, a1s1, Couleur.bleu, observateurScenario1);
        BilleDynamique bd2s1 = new BilleDynamique(p2s1, rayon, v2s1, a2s1, Couleur.vert, observateurScenario1);
        BilleDynamique bd3s1 = new BilleDynamique(p3s1, rayon*0.8, v3s1, a3s1, Couleur.noir, observateurScenario1);
        BilleDynamique bd4s1 = new BilleDynamique(p4s1, rayon*1.7, v4s1, a4s1, Couleur.orange, observateurScenario1);
            // Création des décorateurs pour le Scénario 1
            // Pour bille son   DecorateurBille b0s1 = new DecorateurSon(bd0s1, hurlements[choixHurlementInitial], cadre);
            //                  cadre.addChoixHurlementListener((ItemListener) b0s1);
        //DecorateurBille b0s1 = new DecorateurCliqueCouleur(new DecorateurFrottement(new DecorateurBilleDVD(bd0s1)));
        //DecorateurBille b1s1 = new DecorateurSouris(new DecorateurBilleArret(bd1s1));
        //DecorateurBille b2s1 = new DecorateurTeleportation(new DecorateurPesanteur(new DecorateurFrottement(bd2s1)));
        //DecorateurBille b3s1 = new DecorateurBilleNewton(new DecorateurBilleArret(new DecorateurFantome(bd3s1)));
        //DecorateurBille b4s1 = new DecorateurLancePierre(new DecorateurFantome(new DecorateurBilleArret(bd4s1)));

        DecorateurBille b0s1 = new DecorateurBilleDVD(bd0s1);
        DecorateurBille b1s1 = new DecorateurPesanteur(new DecorateurFrottement(bd1s1));
        DecorateurBille b2s1 = new DecorateurBilleNewton(new DecorateurFrottement(new DecorateurBilleArret(bd2s1)));
        DecorateurBille b3s1 = new DecorateurBilleDVD(new DecorateurPasseMuraille(bd3s1));
        DecorateurBille b4s1 = new DecorateurSon(new DecorateurBilleArret(new DecorateurBilleNewton(bd4s1)), hurlements[choixHurlementInitial], cadre);
        cadre.addChoixHurlementListener((ItemListener) b4s1);
            // Création du Vecteur de billes et ajout dans Scénario 1

        billesS1.add(b0s1);
        billesS1.add(b1s1);
        billesS1.add(b2s1);
        billesS1.add(b3s1);
        billesS1.add(b4s1);

        scenario1.setBillesScenario(billesS1);
            // Inscription à l'observateur
        observateurScenario1.inscription(billesS1);


        // Création partie Scénario 2
            // Création Observateur Collisions
        ObservateurCollisionBille observateurScenario2 = new ObservateurSonCollision(sonsLongs.get(4),cadre);
         // Création des vecteurs de position pour le scénario 2
        Vecteur p0s2, p1s2, p2s2, p3s2, p4s2, p5s2, p6s2, p7s2, p8s2, p9s2, p10s2,
                p11s2, p12s2, p13s2, p14s2, p15s2;                          // Position X Scénario Y
        double differenceBilles = rayon + 0.5*rayon;

        double xligne1 = xMilieu -100;
        double xligne2 = xligne1 - (differenceBilles);
        double xligne3 = xligne2 - (differenceBilles);
        double xligne4 = xligne3 - (differenceBilles);
        double xligne5 = xligne4 - (differenceBilles);

        double yligne5 = yMilieu;
        double yligne4 = yMilieu - (differenceBilles);
        double yligne3 = yligne4 - (differenceBilles);
        double yligne2 = yligne3 - (differenceBilles);
        double yligne1 = yligne2 - (differenceBilles);
        double yligne6 = yligne5 + (differenceBilles);
        double yligne7 = yligne6 + (differenceBilles);
        double yligne8 = yligne7 + (differenceBilles);
        double yligne9 = yligne8 + (differenceBilles);

        p0s2 = new Vecteur(xMilieu+250, yMilieu);
        p1s2 = new Vecteur(xligne1, yligne5);
        p2s2 = new Vecteur(xligne2, yligne6);
        p3s2 = new Vecteur(xligne3, yligne7);
        p4s2 = new Vecteur(xligne4, yligne8);
        p5s2 = new Vecteur(xligne5, yligne9);
        p6s2 = new Vecteur(xligne2, yligne4);
        p7s2 = new Vecteur(xligne4, yligne6);
        p8s2 = new Vecteur(xligne3, yligne5);
        p9s2 = new Vecteur(xligne5, yligne7);
        p10s2 = new Vecteur(xligne3, yligne3);
        p11s2 = new Vecteur(xligne4, yligne4);
        p12s2 = new Vecteur(xligne5, yligne5);
        p13s2 = new Vecteur(xligne4, yligne2);
        p14s2 = new Vecteur(xligne5, yligne3);
        p15s2 = new Vecteur(xligne5, yligne1);

        // Création Billes dynamiques pour le Scénario 2
        BilleDynamique bd0s2 = new BilleDynamique(p0s2, rayon*0.95, Couleur.blancCreme, observateurScenario2);
        BilleDynamique bd8s2 = new BilleDynamique(p8s2, rayon, Couleur.noir, observateurScenario2);
        BilleDynamique bd1s2 = new BilleDynamique(p1s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd2s2 = new BilleDynamique(p6s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd3s2 = new BilleDynamique(p13s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd4s2 = new BilleDynamique(p3s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd5s2 = new BilleDynamique(p7s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd6s2 = new BilleDynamique(p12s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd7s2 = new BilleDynamique(p5s2, rayon, Couleur.rouge, observateurScenario2);
        BilleDynamique bd9s2 = new BilleDynamique(p2s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd10s2 = new BilleDynamique(p4s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd11s2 = new BilleDynamique(p10s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd12s2 = new BilleDynamique(p14s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd13s2 = new BilleDynamique(p11s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd14s2 = new BilleDynamique(p9s2, rayon, Couleur.jaune, observateurScenario2);
        BilleDynamique bd15s2 = new BilleDynamique(p15s2, rayon, Couleur.jaune, observateurScenario2);

        // Création des décorateurs pour le Scénario 2
        DecorateurBille bBlanche = new DecorateurLancePierre(new DecorateurFrottement(bd0s2));
        DecorateurBille bNoire = new DecorateurFrottement(bd8s2);
        DecorateurBille bRouge1 = new DecorateurFrottement(bd1s2);
        DecorateurBille bRouge2 = new DecorateurFrottement(bd2s2);
        DecorateurBille bRouge3 = new DecorateurFrottement(bd3s2);
        DecorateurBille bRouge4 = new DecorateurFrottement(bd4s2);
        DecorateurBille bRouge5 = new DecorateurFrottement(bd5s2);
        DecorateurBille bRouge6 = new DecorateurFrottement(bd6s2);
        DecorateurBille bRouge7 = new DecorateurFrottement(bd7s2);
        DecorateurBille bJaune1 = new DecorateurFrottement(bd9s2);
        DecorateurBille bJaune2 = new DecorateurFrottement(bd10s2);
        DecorateurBille bJaune3 = new DecorateurFrottement(bd11s2);
        DecorateurBille bJaune4 = new DecorateurFrottement(bd12s2);
        DecorateurBille bJaune5 = new DecorateurFrottement(bd13s2);
        DecorateurBille bJaune6 = new DecorateurFrottement(bd14s2);
        DecorateurBille bJaune7 = new DecorateurFrottement(bd15s2);

         // Création du Vecteur de billes et ajout dans Scénario 2
        billesS2.add(bBlanche);
        billesS2.add(bNoire);
        billesS2.add(bRouge1);billesS2.add(bRouge2);billesS2.add(bRouge3);billesS2.add(bRouge4);
        billesS2.add(bRouge5);billesS2.add(bRouge6);billesS2.add(bRouge7);
        billesS2.add(bJaune1);billesS2.add(bJaune2);billesS2.add(bJaune3);billesS2.add(bJaune4);
        billesS2.add(bJaune5);billesS2.add(bJaune6);billesS2.add(bJaune7);

        //Ajout des billes du scenario2.
        scenario2.setBillesScenario(billesS2);

         // Inscription à l'observateur
        observateurScenario2.inscription(billesS2);


        cadre.addChoixScenarioListener(lesScenarios);
//---------------------- ici finit la partie e changer -------------------------------------------------------------

        System.out.println("billes = " + billesS1);

    }
}
