package Bouton;


import vues.Scenario;

import java.awt.*;

/**
 * représente une case à cocher (ou bouton de radio) pour choisir un scénario
 *
 */
public class BoutonChoixScenario extends Checkbox {
    public Scenario scenario;
    /**
     * @param scenario : scénario associé à ce bouton
     */
    public BoutonChoixScenario(CheckboxGroup group, boolean state, Scenario scenario) throws HeadlessException {
        super(scenario.getNom(), group, state);
        this.scenario = scenario;
    }
}
