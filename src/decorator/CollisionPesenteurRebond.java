package decorator;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

import java.util.Vector;

public class CollisionPesenteurRebond extends DecorateurBille {
    Vecteur acceleration;
    protected CollisionPesenteurRebond(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }


    @Override
    public void gestionAcceleration(Vector<Bille> billes)
    {
        System.out.println(this.getAcceleration());
        //TODO DEBUG LACCELERATION DECROISSANTE DE CETTE BILLE
       // super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
      //  this.getAcceleration().ajoute(this.getAcceleration());          // contribution du champ de pesanteur (par exemple)
       // this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'accélération due au frottement dans l'air
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
        }
    }



