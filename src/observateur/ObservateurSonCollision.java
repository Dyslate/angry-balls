package observateur;

import modele.Bille;

import java.util.ArrayList;

public class ObservateurSonCollision extends ObservateurCollision {

    @Override
    public boolean gestionCollisionMultiple(Bille b1) {
        return false;
        // float forceChoc = (float) (b1.getVitesse().norme() + b2.getVitesse().norme());
    }
}
