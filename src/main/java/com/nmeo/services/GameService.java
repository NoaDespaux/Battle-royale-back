package com.nmeo.services;

import com.nmeo.models.Game;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public List<Game> games;

    public void createGame(String gameId, String gameName) {
        this.games.add(new Game(gameId, gameName));
    }

    public List<Game> getGames() {
        return games;
    }

}
