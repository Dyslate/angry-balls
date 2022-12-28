package vues;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Scenario implements ItemListener {


    String nomScenario;
    public Scenario(String nom) {
        this.nomScenario = nom;
    }

    public String getNom() {
        return nomScenario;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Le scenario "+e.getItem()+" a ete selectionne");
    }
}