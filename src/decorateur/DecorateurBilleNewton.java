package decorateur;

import modele.Bille;
import modele.OutilsBille;

import java.util.Vector;

/**
 * Decorateur permettant à une bille de rebondir
 */
public class DecorateurBilleNewton extends DecorateurBille {
    public DecorateurBilleNewton(Bille b) {
        super(b);
    }
    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        this.bille.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));
    }
}
