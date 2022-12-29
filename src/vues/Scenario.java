package vues;


import modele.Bille;
import musique.SonLong;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
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
        this.billesScenario = new Vector<>();
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

    public void setBillesScenario(Vector<Bille> billes) {
        this.billesScenario = billes;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int i = 0;
        while (i<scenario.length) {
            if(e.getItem()==scenario[i].nomScenario){
                CadreAngryBalls.animationBilles.lancerAnimation();
                System.out.println(scenario[i].billesScenario);
                CadreAngryBalls.billard.billes = scenario[i].billesScenario;
                CadreAngryBalls.animationBilles.setBilles(scenario[i].billesScenario);
                CadreAngryBalls.animationBilles.arreterAnimation();
            }
            i++;
        }
    }
}