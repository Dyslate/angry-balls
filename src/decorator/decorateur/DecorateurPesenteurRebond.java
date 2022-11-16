package decorator.decorateur;

import decorator.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

import java.util.Vector;

public class DecorateurPesenteurRebond extends DecorateurBille {
    Vecteur acceleration;

    public DecorateurPesenteurRebond(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }



    @Override
    public Vecteur gestionAcceleration(Vector<Bille> billes)
    {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
      //  this.getAcceleration().ajoute(this.acceleration);          // contribution du champ de pesanteur (par exemple)
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'accélération due au frottement dans l'air
        return this.getAcceleration();
    }



    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

    }
    }

