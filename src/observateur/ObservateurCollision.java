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

    public boolean quiEntrechoque(Bille billeCourante, Bille billeObservee) {
            if ((entrechoc(billeCourante, billeObservee)))
                return true;
            else
                return false;
    }

    public boolean gestionCollisionMultiple(Bille billeCourante, Vector<Bille> billes) {
        for (int i = 0; i < billes.size(); i++) {
            if (billeCourante.getClef() == billes.get(i).getClef()) {
                continue;
            } else if (quiEntrechoque(billeCourante, billes.get(i))) {
                    System.out.println("///////////////");
                    System.out.println(billes.get(i).getCouleur() + " - " + billes.get(i));
                    System.out.println(billeCourante.getCouleur() + " - " + billeCourante);
                    System.out.println("///////////////");
                    billes.get(i).collisionCustom(observe);
                    return billeCourante.collisionCustom(observe);
            }
        }
        return false;
    }

}
