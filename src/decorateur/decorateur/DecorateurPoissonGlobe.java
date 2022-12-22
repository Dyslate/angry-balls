package decorateur.decorateur;

import decorateur.DecorateurBille;
import modele.Bille;

import java.util.Vector;

public class DecorateurPoissonGlobe extends DecorateurBille {
    private boolean gonfle = false;
    private static double vraiRayon;

    public DecorateurPoissonGlobe(Bille b) {
        super(b);
        vraiRayon = this.bille.getRayon();
    }

    public DecorateurPoissonGlobe(Bille b, double modifRayon) {
        super(b);
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        boolean collision = super.gestionCollisionBilleBille(billes);

        if (collision || gonfle) {
            if (this.bille.getRayon() < 3*vraiRayon) {
                if (!gonfle)
                    gonfle = true;
                modifTaille(this.bille, 1.1);
            } else
                gonfle = false;
        } else {
            if (this.bille.getRayon() > vraiRayon)
                modifTaille(this.bille, 0.95);
        }

        return collision;
    }

    public void modifTaille(Bille b, double pourcen) {
        b.setRayon(b.getRayon() * pourcen);
    }
}