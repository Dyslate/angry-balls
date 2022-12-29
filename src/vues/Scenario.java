package vues;


import modele.Bille;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Scenario implements ItemListener {


    String nomScenario;
    public Vector<Bille> billesScenario;

    public Scenario(String nom) {
        this.nomScenario = nom;
        this.billesScenario = new Vector<Bille>();
    }

    public Scenario(String nom, Vector<Bille> billes) {
        this.nomScenario = nom;
        this.billesScenario = billes;
    }

    public String getNom() {
        return nomScenario;
    }

    public Vector<Bille> getBillesScenario() {
        return this.billesScenario;
    }

    public void setBillesScenario(Vector<Bille> billes) {
        this.billesScenario = billes;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Le scenario " + e.getItem() + " a ete selectionne");
        CadreAngryBalls.billard.billes = this.billesScenario;
    }
}