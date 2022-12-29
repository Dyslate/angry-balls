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
    public Scenario[] scenario;


    public Scenario(String nom) {
        this.id = prochainID++;
        this.nomScenario = nom;
        this.billesScenario = new Vector<Bille>();
    }


    public Scenario(Scenario[] scenarios){
        this.scenario=scenarios;
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
        System.out.println(e.getItem());
        if(e.getItem()=="Scenario1"){
            System.out.println(scenario[0].billesScenario);
            CadreAngryBalls.billard.billes = scenario[0].billesScenario;
        } else {
            System.out.println(scenario[1].billesScenario);
            CadreAngryBalls.billard.billes = scenario[1].billesScenario;
        }

    }
}