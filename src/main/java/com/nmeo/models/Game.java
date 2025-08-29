package com.nmeo.models;

public class Game {

    private String gameId;
    private String gameName;

    public Game(String id, String name) {
        this.gameId = id;
        this.gameName = name;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

}
