package decorateur.decorateur;

import decorateur.DecorateurBille;
import modele.Bille;

import java.util.Vector;

public class DecorateurFantome extends DecorateurBille {
    public DecorateurFantome(Bille b) {
        super(b);
    }

    @Override
    public boolean inscrit() {
        return false;
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return false;
    }


}
