package decorateur;

import decorateur.DecorateurBille;
import modele.Bille;
import modele.OutilsBille;

import java.util.Vector;

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
