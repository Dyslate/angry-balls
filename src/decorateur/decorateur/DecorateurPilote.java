package decorateur.decorateur;

import decorateur.DecorateurBille;
import decorateur.decorateur.state.BilleAttrape;
import decorateur.decorateur.state.BilleRelache;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.CadreAngryBalls;

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
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);          // remise é zéro du vecteur accélération

        if(BilleAttrape.estPress&BilleAttrape.estRelache){
            //   this.bille.getPosition().set(new Vecteur(BilleAttrape.posSouris1X,BilleAttrape.posSouris1Y));
            this.bille.getAcceleration().ajoute(BilleRelache.vitesseSouris);          // contribution du champ de pesanteur (par exemple)
            System.out.println("modification du vecteur acceleration de la bille");
            BilleAttrape.estPress=false;
            BilleAttrape.estRelache=false;
        }
    }
}
