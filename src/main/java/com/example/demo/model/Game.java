package com.example.demo.model;

import com.example.demo.util.Utilities;
import jdk.nashorn.internal.objects.IteratorResult;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game {
    //private int id;
    private List<Player> players;
    private List<String> occasioni;
    private List<String> esperienze;
    private final String[] colors = {"blue", "yellow", "green", "black", "cyan"};
    private int nextcolor = 0;

    // constructors

    public Game() {
        this.occasioni = Utilities.inizializzaOccasioni();
        this.esperienze = Utilities.inizializzaEsperienze();
        this.players = new LinkedList<>();

        if(occasioni.isEmpty() || esperienze.isEmpty()){
            System.out.println("Nessuna carta caricata");
        }
    }

    // getters

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getOccasioni() {
        return occasioni;
    }

    public List<String> getEsperienze() {
        return esperienze;
    }

    public boolean addPlayer(String nomeGiocatore) {
        if(doublePlayer(nomeGiocatore)) return false;
        return this.players.add(new Player(nomeGiocatore));
    }

    private boolean doublePlayer(String nomeGiocatore) {
        Iterator<Player> i = this.players.iterator();
        while(i.hasNext()){
            Player p = (Player) i.next();
            if (p.getNome().equalsIgnoreCase(nomeGiocatore)) return true;
        }
        return false;
    }

    public String nextColor() throws IndexOutOfBoundsException {
        String color = colors[nextcolor];
        nextcolor++;
        return color;
    }
}