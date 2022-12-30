package maladroit.vues;

import java.io.File;
import java.util.Vector;

import maladroit.OutilsConfigurationBilleHurlante;
import maladroit.modele.BilleMaladroit;
import musique.SonLong;


public class TestCadreAngryBallsSeul
{

/**
 * @param args
 */
public static void main(String[] args)
{
//---------------------- gestion des bruitages : param�trage du chemin du dossier contenant les fichiers audio --------------------------

File file = new File(""); // l� o� la JVM est lanc�e : racine du projet

File repertoireSon = new File(file.getAbsoluteFile(),
      "exodecorateur_angryballs"+File.separatorChar+
      "maladroit"+File.separatorChar+"bruits");

//-------------------- chargement des sons pour les hurlements --------------------------------------

Vector<SonLong> sonsLongs = OutilsConfigurationBilleHurlante.chargeSons(repertoireSon, "config_audio_bille_hurlante.txt");
   
SonLong hurlements[] = SonLong.toTableau(sonsLongs); // on obtient un tableau de SonLong
  
Vector<BilleMaladroit> billes = new Vector<BilleMaladroit>();
int choixHurlementInitial = 0;
CadreAngryBallsMaladroit cadre =new CadreAngryBallsMaladroit("angry balls", "animation de billes marrantes", billes, hurlements, choixHurlementInitial);
cadre.montrer();
}

}
