package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class AppSession {
    Random random;
    Map<String, Game> gameMap;

    public AppSession(){
        this.random = new Random();
        this.gameMap = new HashMap<>();
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Map<String, Game> getGameMap() {
        return gameMap;
    }

    public void setGameMap(Map<String, Game> gameMap) {
        this.gameMap = gameMap;
    }

    public void addGame(int id, Game game) {
        gameMap.put(String.valueOf(id), game);
    }

    public Game getGame(String idpartita) {
        return gameMap.get(idpartita);
    }
}
