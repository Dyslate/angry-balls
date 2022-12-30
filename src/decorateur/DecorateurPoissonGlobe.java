package decorateur;

import decorateur.DecorateurBille;
import modele.Bille;

import java.util.Vector;

/**
 * Decorateur permettant à une bille d'agir comme un poisson globe: à l'approche d'une bille elle grossit.
 */
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
        gonfle();
        return super.gestionCollisionBilleBille(billes);
    }

    @Override
    public boolean collisionCustom(Vector<Bille> billes) {
        if (!gonfle)
            this.gonfle = true;
        return true;
    }

    public void gonfle() {
        if (this.gonfle) {
            if (this.getRayon() < 3* vraiRayon) {
                modifTaille(this.bille, 1.4);
            } else {
                this.gonfle = false;
            }
        } else {
            if (this.getRayon() > vraiRayon) {
                modifTaille(this.bille, 0.90);
            }
        }
    }

    public void modifTaille(Bille b, double pourcen) {
        b.setRayon(b.getRayon() * pourcen);
    }
}