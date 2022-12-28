package observateur;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;

import java.util.Vector;

public abstract class ObservateurCollisions {

    protected Vector<Bille> observe = new Vector<>();
    protected Bille billeCouranteLocale = null;

    public void inscription(Vector<Bille> billes) {
        for (int i = 0; i < billes.size(); i++) {
            if (billes.get(i).inscrit()) {
                this.observe.add(billes.get(i));
            }
            System.out.println(billes.get(i));
        }
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

        return !(nG1G2_2 >= r2);
    }

    public boolean quiEntrechoque(Bille billeCourante, Bille billeObservee) {
        return entrechoc(billeCourante, billeObservee);
    }

    public boolean gestionCollisionMultiple(Bille billeCourante) {
        getBilleCouranteLocale(billeCourante);
        for (int i = 0; i < observe.size(); i++) {
            if (observe.get(i) == null || billeCourante.getClef() == observe.get(i).getClef()) {
                continue;
            } else if (quiEntrechoque(billeCourante, observe.get(i))) {
                observe.get(i).collisionCustom(observe);
                return billeCouranteLocale.collisionCustom(observe);
            }
        }
        return false;
    }

    protected void getBilleCouranteLocale(Bille billeCourante) {
        for (int j = 0; j < observe.size(); j++) {
            if (billeCourante.getClef() == observe.get(j).getClef())
                billeCouranteLocale = observe.get(j);
        }
    }

}
