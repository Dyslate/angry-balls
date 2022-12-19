package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

import java.util.Vector;

public class DecorateurFrottement extends DecorateurBille {
    public DecorateurFrottement(Bille bille) {
        super(bille);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.bille.gestionAcceleration(billes);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(masse(), getVitesse()));
    }

}
