package com.nmeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nmeo.models.Game;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameListMessage {

    public int type = MessageType.LIST_GAME.type;
    public List<Game> gamelist;

}
