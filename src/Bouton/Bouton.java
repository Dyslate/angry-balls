package Bouton;

import observateur.ObservableBouton;
import observateur.ObservateurBouton;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Classe Bouton : Permet l'implémentation des boutons de Marche / Arrêt, des sons et des scénarios
 */
public abstract  class Bouton extends Button implements ObservableBouton {
    protected ArrayList<ObservateurBouton> observe = new ArrayList<>();

    /**
     * @param label : Nom du bouton
     *              Constructeur permettant d'ajouter un bouton
     */
    protected Bouton(String label){
        this.setLabel(label);
        this.addActionListener(this::Appuye);
    }

    /**
     * Evenement onclick : se lance à chaque clic sur un bouton
     */
    protected void onClick(){
        for(ObservateurBouton ob : observe){
            ob.boutonAppuye(this,null);
        }
    }

    /**
     * Permet l'ajout d'un observateur de boutons
     */
    @Override
    public void ajoutObservateur(ObservateurBouton observateur){
        observe.add(observateur);
    }

    private void Appuye(ActionEvent actionEvent) {
        onClick();
    }
}
