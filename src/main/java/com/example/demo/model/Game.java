package com.example.demo.model;

import com.example.demo.util.Utilities;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;

public class Game {
    //private int id;
    private List<Player> players;
    private List<String> occasioni;
    private List<String> esperienze;
    private ArrayList<String> colors;
    private ListIterator<String> colorsIterator;

    // constructors

    public Game() {
        this.occasioni = Utilities.inizializzaOccasioni();
        this.esperienze = Utilities.inizializzaEsperienze();
        this.colors = Utilities.inizializzaColori();
        this.colorsIterator = colors.listIterator();
        this.players = new ArrayList<>();

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
        String color = null;
        if(colorsIterator.hasNext()){
            color =  colorsIterator.next();
            colorsIterator.remove();
        }
        if(colorsIterator.hasPrevious()){
            color =  colorsIterator.previous();
            colorsIterator.remove();
        }
        return color;
    }

    public boolean hasplayer(String nomegiocatore) {
        Iterator<Player> i = players.iterator();
        while (i.hasNext()){ if(i.next().getNome().equals(nomegiocatore)) return true; }
        return false;
    }
}