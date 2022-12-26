package Bouton;

import observateur.ObservableBouton;
import observateur.ObservateurBouton;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public abstract  class Bouton extends Button implements ObservableBouton {

    protected ArrayList<ObservateurBouton> observateurs = new ArrayList<>();

    protected Bouton(String label){
        this.setLabel(label);
        this.addActionListener(this::Appuye);
    }

    protected void onClick(){
        for(ObservateurBouton ob : observateurs){
            ob.boutonAppuye(this,null);
        }
    }

    @Override
    public void ajoutObservateur(ObservateurBouton observateur){
        observateurs.add(observateur);
    }

    private void Appuye(ActionEvent actionEvent) {
        onClick();
    }
}
