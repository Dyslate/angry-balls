package observateur;

import modele.Bille;

public class ObservateurSonCollision implements ObservateurCollision {
    @Override
    public void collision(Bille b1, Bille b2) {
        float forceChoc = (float) (b1.getVitesse().norme() + b2.getVitesse().norme());
    }
}
