package observateur;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import musique.SonLong;
import musique.SonLongFantome;
import vues.VueBillard;

public class ObservateurSonCollision extends ObservateurCollisionBille {

    private SonLong son;
    private VueBillard vueBillard;
    private static int coeff_pitch = 1;
    private static final double COEFF_VOLUME = 6;

    public ObservateurSonCollision(SonLong son, VueBillard billard) {
        super();
        this.son = son;
        this.vueBillard = billard;
    }

    @Override
    public boolean gestionCollisionMultiple(Bille b1) {
        this.getBilleCouranteLocale(b1);
        for (int i = 0; i < observe.size(); i++) {
            if (observe.get(i) == null || b1.getClef() == observe.get(i).getClef()) {
                continue;
            } else if (quiEntrechoque(b1, observe.get(i))) {
                Bille b2 = observe.get(i);
                double forceChoc = b1.getVitesse().norme() + b2.getVitesse().norme();
                Vecteur impact = new Vecteur((b1.getPosition().x + b2.getPosition().x)/2, (b1.getPosition().y + b2.getPosition().y)/2);
                double xMax = vueBillard.largeurBillard();
                double y = Math.exp(-COEFF_VOLUME * forceChoc);
                double volume = 1-y;
                double x1 = impact.x / xMax;
                double balance = 2 * x1 - 1;
                this.son.joue(0, volume, balance, coeff_pitch);
                observe.get(i).collisionCustom(observe);
                return billeCouranteLocale.collisionCustom(observe);
            }
        }
        return false;
    }
}
