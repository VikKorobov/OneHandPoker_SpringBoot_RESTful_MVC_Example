package com.korobov.onehandpoker.model;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;

public interface IGameStateModel {

    Long getGameId();

    Long getPlayerId();
    
    Iterable<CardRecord> getPlayerCards();

    EGameResult getGameState();

    BigDecimal getPlayerBet();

    BigDecimal getWinMultiplier();

    BigDecimal getPlayerWinnings();
}
