package com.korobov.onehandpoker.handler;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameHandler {
    
    Result<IGameStateModel, IError> play(Long playerId, BigDecimal playerBet);

    Result<IGameStateModel, IError> getGame(Long id);

    Result<Iterable<IGameStateModel>, IError> getGames();

    Result<Iterable<IGameStateModel>, IError> getPlayerGames(Long id);
}
