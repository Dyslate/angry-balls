package observateur;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;

import java.util.Vector;

public class ObservateurCollision {

    protected Vector<Bille> observe = new Vector<>();

    public void ajouteBille(Bille b) {
        this.observe.add(b);
    }

    public static boolean entrechoc(Bille b1, Bille b2) {
        final Vecteur G1 = b1.getPosition();
        double rayon1 = b1.getRayon();
        Vecteur v1 = b1.getVitesse();
        double m1 = b1.masse();

        final Vecteur G2 = b2.getPosition();
        double rayon2 = b2.getRayon();
        Vecteur v2 = b2.getVitesse();
        double m2 = b2.masse();

        Vecteur G1G2 = Vecteur.difference(G2, G1);

        double nG1G2_2 = G1G2.normeCarrée();

        double r = rayon1 + rayon2;
        double r2 = r * r;

        return (nG1G2_2 >= r2) ? false : true;
    }

    public Bille quiEntrechoque(Bille billeCourante) {
        Vector<Bille> collisions = new Vector<>();
        collisions.add(billeCourante);
        for (Bille billeObservee : observe) {
            if (billeCourante.getClef() == billeObservee.getClef())
                continue;
            if ((entrechoc(billeCourante, billeObservee)))
                return billeObservee;
        }
        return null;
    }

    public boolean gestionCollisionMultiple(Bille billeCourante) {
        Bille b = quiEntrechoque(billeCourante);
        if (b != null)
            OutilsBille.gestionCollisionBilleBille(b, observe);
        return OutilsBille.gestionCollisionBilleBille(billeCourante, observe);

    }

}
