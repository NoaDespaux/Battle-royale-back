package com.nmeo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmeo.dto.GameListMessage;
import com.nmeo.dto.MessageType;
import com.nmeo.dto.ResponseMessage;
import com.nmeo.dto.WebSocketMessage;
import io.javalin.websocket.WsMessageContext;
import org.apache.logging.log4j.Logger;


public class BroadcastService {

    public void newGame(Logger logger, WsMessageContext ctx, WebSocketMessage newMessage, GameService gameService, String gameId, String gameName) {
        try {
            logger.info("New game created: {}", newMessage.gameId);
            gameService.createGame(newMessage.gameId, newMessage.gameName);
            ResponseMessage response = new ResponseMessage();
            response.status = "OK";
            ctx.send(response);
        } catch (Exception e) {
            logger.error("Error creating game", e);
            ResponseMessage response = new ResponseMessage();
            response.status = "KO";
            response.errorMessage = e.getMessage();
            ctx.send(response);
        }
    }

    public void listGames(Logger logger, GameService gameService, WsMessageContext ctx) {
        try {
            logger.info("Listing all games");
            GameListMessage response = new GameListMessage();
            response.gamelist = gameService.getGames();
            response.type = MessageType.LIST_GAME.type;
            ObjectMapper mapper = new ObjectMapper();
            String jsonResponse = mapper.writeValueAsString(response);
            ctx.send(response);
        } catch (Exception e) {
            logger.error("Error listing games", e);
            ResponseMessage response = new ResponseMessage();
            response.status = "KO";
            response.errorMessage = e.getMessage();
            ctx.send(response);
        }
    }

}
