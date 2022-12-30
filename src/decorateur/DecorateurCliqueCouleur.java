package decorateur;

import etats.BilleAttrape;
import modele.Bille;
import modele.Couleur;

import java.util.Vector;

public class DecorateurCliqueCouleur extends DecorateurBille {
    public DecorateurCliqueCouleur(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        if(BilleAttrape.estPress&&BilleAttrape.estRelache&&this.getClef()==BilleAttrape.billeCourante) {
            bille.setCouleur(Couleur.getRandomCouleur());
            BilleAttrape.estPress=false;
            BilleAttrape.estRelache=false;
        }
    }
}