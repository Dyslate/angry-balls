package decorateur.decorateur;

import decorateur.DecorateurBille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import musique.SonLong;
import vues.BoutonChoixHurlement;
import vues.VueBillard;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DecorateurSon extends DecorateurBille implements ItemListener {
    private static final int DELAI_MIN=10;
    public static final int DELAI_MAX=150;
    public SonLong sonLong;
    int i;
    long dernierInstant;
    VueBillard vueBillard;
    private static final double COEFF_VOLUME = 6;
    public DecorateurSon(Bille b, SonLong sonLong, VueBillard vueBillard) {
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
    public void itemStateChanged(ItemEvent itemEvent) {
        if(itemEvent.getSource() instanceof BoutonChoixHurlement){
            BoutonChoixHurlement boutonChoixHurlement = (BoutonChoixHurlement) (itemEvent.getSource());
            this.sonLong = boutonChoixHurlement.sonLong;
        }
    }
}
