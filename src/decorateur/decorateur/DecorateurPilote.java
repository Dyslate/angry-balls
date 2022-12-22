package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import modele.Bille;

import java.util.Vector;


public class DecorateurPilote extends DecorateurBille {
    public DecorateurPilote(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes)
    {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        if(BilleAttrape.estPress&&BilleRelache.vitesseSouris.x!=-1){
            this.bille.getAcceleration().ajoute(BilleRelache.vitesseSouris);          // contribution du champ de pesanteur (par exemple)

        }
    }
}
