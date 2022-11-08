package decorator;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;
import musique.SonLong;
import vues.BoutonChoixHurlement;
import vues.VueBillard;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class BilleHurlanteMvtNewtonArret extends DecorateurBille implements ItemListener {
    private static final int DELAI_MIN=10;
    public static final int DELAI_MAX=150;
    public SonLong sonLong;
    int i;
    long dernierInstant;
    VueBillard vueBillard;
    private static final double COEFF_VOLUME = 6;



    public BilleHurlanteMvtNewtonArret(Bille b, SonLong sonLong, VueBillard vueBillard) {
        super(b);
        this.sonLong=sonLong;
        this.vueBillard=vueBillard;
    }

    @Override
    public void deplacer(double deltaT){
        super.deplacer(deltaT);
        Vecteur p = this.getPosition();
        Vecteur v = this.getVitesse();
        double xMax;
        xMax = vueBillard.largeurBillard();
        double n = v.norme();
        double y = Math.exp(-COEFF_VOLUME * n);
        double volume = 1-y;
        double x1 = p.x / xMax;
        double balance = 2 * x1 - 1;

        int delai = (int) (DELAI_MIN * volume
                + DELAI_MAX * y);
        long instant = System.currentTimeMillis();

        if(instant - this.dernierInstant >= delai){
            double coeffPitch = 1;
            this.sonLong.joue(i++,volume,balance,coeffPitch);
            this.dernierInstant = instant;

        }
    }


    @Override
    public void gestionAcceleration(Vector<Bille> billes){

        //TODO DEBUG L ACCELERATION
       // super.gestionAcceleration(billes);
       // this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this,billes));
    }


    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche,hauteur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche,hauteur);

    }
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if(itemEvent.getSource() instanceof BoutonChoixHurlement){
            BoutonChoixHurlement boutonChoixHurlement = (BoutonChoixHurlement) (itemEvent.getSource());
            this.sonLong = boutonChoixHurlement.sonLong;
        }
    }
}
