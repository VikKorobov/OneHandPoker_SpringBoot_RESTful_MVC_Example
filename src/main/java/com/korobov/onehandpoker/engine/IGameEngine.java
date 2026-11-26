package com.korobov.onehandpoker.engine;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameEngine {
    
    Result<IGameStateModel, IError> play(Long playerId, BigDecimal playerBet);
}
