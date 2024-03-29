package base;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import musique.SonLong;
import musique.SonLongFantome;
import musique.javax.SonLongJavax;

/**
 * sert e construire tous les sons qui seront proposes pour animer la bille hurlante
 * 
 *  ICI : IL N'Y A RIEN A CHANGER
 *  
 * */
public class OutilsConfigurationBilleHurlante
{

/**
 * La seule teche de cette methode est d'ouvrir le fichier de configuration de SonLong de la bille hurlante
 * cf. methode chargeSons1 juste apres
 * */
public static Vector<SonLong>  chargeSons(File repertoireBruits, String nomFichierConfigAudio) //throws IOException
{
Vector<SonLong> resultat;
try
    {
    File f = new File(repertoireBruits,nomFichierConfigAudio);
    FileInputStream f1 = new FileInputStream(f);
    BufferedReader fichierConfigBilleHurlante = new BufferedReader(new InputStreamReader(f1));
    
    resultat = OutilsConfigurationBilleHurlante.chargeSons1(repertoireBruits, fichierConfigBilleHurlante);
    fichierConfigBilleHurlante.close();
    }

catch (IOException e)
    {
    resultat = new Vector<SonLong>();
    resultat.add(new SonLongFantome());
    System.err.println("sons indisponibles pour les hurlements");
    }
return resultat;
}

/**
 * Teche : construit une liste de SonLong.
 *  
 * @param repertoireBruits : construit une liste de SonLong e partir de fichiers audio places sur le dossier defini par le chemin repertoireBruits
 * @param fichierConfigBilleHurlante : indique comment construire les SonLong.
 * 
 * fichierConfigBilleHurlante respecte le format suivant :
 * sur les 8 premieres lignes est detaille le format du fichier lui-meme
 * puis chaque ligne suivante permet de construire un SonLong. 
 * 
 * Exemple de fichierConfigBilleHurlante : 
 * 
        configuration des fichiers audios e utiliser pour la bille hurlante. Un fichier audio au format wav par ligne. 
        4 informations sur une ligne : 
        nom du fichier (sans l'extention .wav) debut de l'extrait (en centiemes de secondes) fin de l'extrait (en centiemes de secondes) effectif (nombre de morceaux composant l'extrait)
        separateur : espace. exemple :  sabrelaser 0 150 15  
        Important ===> On doit toujours avoir : effectif^2 >= (finExtrait - debutExtrait) / BilleHurlante.DELAI_MIN
        Important ===> On doit toujours avoir : (finExtrait - debutExtrait) / effectif >= SonJavax.TAILLE_BUFFER_LIGNE
        Les fichiers audio doivent etre dans le meme repertoire que ce fichier
        Les 8 premieres lignes du fichier sont ignorees
        huey2 1200 1300 10
        spitfire 1100 1700 30
        sabrelaser 0 150 15
        loups 0 600 40
        crapaud 20 120 10
 * 
 * A partir de la 9eme ligne, toute ligne contenant une erreur est ignoree
 * 
 * Si e partir du fichier, on est incapable de construire au moins un SonLong valide, la methode renvoie un Vector contenant un unique SonLongFantome
 * pour que l'application puisse quand meme tourner. 
 * */
public static Vector<SonLong>  chargeSons1(File repertoireBruits, BufferedReader fichierConfigBilleHurlante)
{
Vector<SonLong> sons = new Vector<SonLong>();

int i;
String ligne = null;

try
    {
    for (i = 0; i < 8; ++i) ligne = fichierConfigBilleHurlante.readLine(); /* on ignore les 8 premieres lignes du fichier qui contiennent le resume */
    }
catch (IOException e1)  /* l'entete du fichier contient un probleme */
    {
    sons.add(new SonLongFantome());         /* on cree un son bidon pour que l'application puisse quand meme tourner sans la diffusion du son */
    return sons;
    }

/* e present on est sûr que la lecture des 8 lignes d'entete s'est bien passee. le pointeur de ligne de fichierConfigBilleHurlante pointe sur la 9eme ligne */

for ( /* rien e faire ici*/; ligne != null; ++i)
    {
    try
      {
      ligne = fichierConfigBilleHurlante.readLine();        /*ligne est supposee respecter le format suivant : "spitfire 1100 1700 30" */
      
      if (ligne != null) sons.add(SonLongJavax.crée(repertoireBruits, ligne) );
      }
    catch (Exception e)
      {
      /* on ignore la ligne generant une erreur et on passe au prochain son sur la ligne suivante */
      System.err.println("Dans OutilsConfigurationBilleHurlante.chargeSons1() : ligne ne " + i + " ignoree car contenant une erreur : " + e);            
      }
    }       // for

if (sons.isEmpty()) sons.add(new SonLongFantome());
return sons;
}
//SonLongJavax( File repertoire, String nomFichier, int debutExtrait, int finExtrait, int effectif)
}
