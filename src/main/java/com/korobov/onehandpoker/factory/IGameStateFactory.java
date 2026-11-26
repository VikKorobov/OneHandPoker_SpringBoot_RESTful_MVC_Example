package com.korobov.onehandpoker.factory;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameStateFactory {

    Result<IGameStateModel, IError> create(
            Long playerId,
            BigDecimal playerBet,
            Iterable<CardRecord> playerCards,
            EGameResult gameState,
            BigDecimal winMultiplier,
            BigDecimal playerWinnings
    );
}
