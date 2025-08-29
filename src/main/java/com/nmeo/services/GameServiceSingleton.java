package com.nmeo.services;

import java.util.ArrayList;

public class GameServiceSingleton {

    private static GameService instance;

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
            instance.games = new ArrayList<>();
        }
        return instance;
    }
}