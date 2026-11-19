package com.korobov.onehandpoker.engine;

import java.math.BigDecimal;

import com.korobov.onehandpoker.errors.ErrorRecord;
import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameEngine {
    
    Result<IGameStateModel, ErrorRecord> play(Long playerId, BigDecimal playerBet);
}
