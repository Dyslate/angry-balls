package decorateur.decorateur;

import decorateur.DecorateurBille;
import modele.Bille;

import java.util.Vector;

public class DecorateurFantome extends DecorateurBille {
    public DecorateurFantome(Bille b) {
        super(b);
        this.bille.enleverInscrit();
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return super.gestionCollisionBilleBille(billes);
    }


}
