package vues;


import modele.Bille;
import musique.SonLong;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Scenario implements ItemListener {

    int id;
    String nomScenario;
    String description;
    public Vector<Bille> billesScenario;

    private static int prochainID = 0;



    public Scenario(String nom) {
        this.id = prochainID++;
        this.nomScenario = nom;
        this.billesScenario = new Vector<Bille>();
    }

    public Scenario(String nom, String description, Vector<Bille> billes) {
        this.id = prochainID++;
        this.nomScenario = nom;
        this.description = description;
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
        CadreAngryBalls.billard.billes = this.billesScenario;

    }
}