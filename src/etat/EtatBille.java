package etat;
import modele.Bille;

public abstract class EtatBille {
    Bille parent;

    public EtatBille(Bille parent) {this.parent = parent;}

    public void deplacer(double deltaT) {
        parent.deplacer(deltaT);
    }
}
