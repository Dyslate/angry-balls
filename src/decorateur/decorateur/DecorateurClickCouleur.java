package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Couleur;

import java.util.Vector;

public class DecorateurClickCouleur extends DecorateurBille {
    public DecorateurClickCouleur(Bille b) {
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