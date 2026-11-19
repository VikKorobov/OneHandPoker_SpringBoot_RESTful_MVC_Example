package com.korobov.onehandpoker.model;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameState;

public interface IGameStateModel {

    Long getGameId();

    Long getPlayerId();
    
    Iterable<CardRecord> getPlayerCards();

    EGameState getGameState();

    BigDecimal getPlayerBet();

    BigDecimal getWinMultiplier();

    BigDecimal getPlayerWinnings();
}
