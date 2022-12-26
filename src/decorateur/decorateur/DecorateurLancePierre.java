package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

import java.util.Vector;

public class DecorateurLancePierre extends DecorateurBille {
    public DecorateurLancePierre(Bille b) {
        super(b);
    }
    @Override
    public boolean estPilotable(){
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération
        if(BilleAttrape.estPress&BilleAttrape.estRelache){
            this.bille.getAcceleration().set(BilleRelache.vitesseSouris);
            System.out.println(this.bille.getAcceleration());
            // contribution du champ de pesanteur (par exemple)
            System.out.println("modification du vecteur acceleration de la bille");
            BilleAttrape.estPress=false;
            BilleAttrape.estRelache=false;
        }
    }
}
