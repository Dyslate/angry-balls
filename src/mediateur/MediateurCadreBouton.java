package mediateur;

import modele.Bille;
import vues.CadreAngryBalls;
import vues.Scenario;

import java.util.Vector;

public class MediateurCadreBouton {
    CadreAngryBalls cadre;

    public MediateurCadreBouton(CadreAngryBalls cadre) {
        this.cadre = cadre;
    }

    public void changeScenario(Vector<Bille> billes) {
        this.cadre.changeBillard(billes);
        this.cadre.changeAnimations(billes);
    }
}
