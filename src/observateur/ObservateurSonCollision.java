package observateur;

import modele.Bille;

import java.util.ArrayList;
import java.util.Vector;

public class ObservateurSonCollision extends ObservateurCollision {

    @Override
    public boolean gestionCollisionMultiple(Bille b1) {
        // float forceChoc = (float) (b1.getVitesse().norme() + b2.getVitesse().norme());
        return false;
    }
}
