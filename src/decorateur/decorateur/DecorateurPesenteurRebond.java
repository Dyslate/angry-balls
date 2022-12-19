package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

import java.util.Vector;

public class DecorateurPesenteurRebond extends DecorateurBille {
    private Vecteur acceleration;

    public DecorateurPesenteurRebond(Bille b, Vecteur acceleration) {
        super(b);
        this.acceleration=acceleration;
    }



    @Override
    public void gestionAcceleration(Vector<Bille> billes)
    {
        bille.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        getAcceleration().ajoute(this.acceleration);          // contribution du champ de pesanteur (par exemple)
        //getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'accélération due au frottement dans l'air
    }



    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonnéeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

    }
    }

