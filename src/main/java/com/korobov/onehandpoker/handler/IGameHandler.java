package com.korobov.onehandpoker.handler;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;

public interface IGameHandler {
    
    IGameStateModel play(Long playerId, BigDecimal playerBet);

    IGameStateModel getGame(Long id);

    Iterable<IGameStateModel> getGames();

    Iterable<IGameStateModel> getPlayerGames(Long id);
}
