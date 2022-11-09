package modele;

import java.awt.*;

public class testCouleur {

    public static void main(String[]args){


        System.out.println("\n\n Test Constructeur par défaut  : " + new Couleur());


        Color red = Color.RED;
        System.out.println("Test AWT : "+ red + " et alpha " + red.getAlpha());
        System.out.println("Test transformeAWT : " + Couleur.rouge.transformeAWT() + " et alpha :" + Couleur.rouge.transformeAWT().getAlpha());

        System.out.println("\n\n Test static : Rouge : "+ Couleur.rouge);
    }
}
