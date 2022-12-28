package vues;

import java.awt.*;

public class PanneauChoixScenario extends Panel {
    BoutonChoixScenario[] boutons;
    CheckboxGroup checkboxGroup;

    /**
     * @param scenarios : tous les scénarios disponibles.
     * @param choixScenarioInitial : Scenario choisi par defaut à l'initialisation de l'application.
     *                                  choixScenarioInitial doit representer un indice valide du tableau hurlements
     * */
    public PanneauChoixScenario(Scenario[] scenarios, int choixScenarioInitial)
    {
        this.boutons = new BoutonChoixScenario [scenarios.length];
        this.checkboxGroup = new CheckboxGroup();
        this.setLayout(new GridLayout(1, this.boutons.length));
        for ( int i = 0; i < this.boutons.length; ++i) {
            this.boutons[i] = new BoutonChoixScenario(checkboxGroup, false, scenarios[i]);
            this.add(this.boutons[i]);
        }

        this.boutons[choixScenarioInitial].setState(true);

        System.out.println(checkboxGroup.getSelectedCheckbox());
    }

}