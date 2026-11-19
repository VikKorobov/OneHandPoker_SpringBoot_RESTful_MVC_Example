package com.korobov.onehandpoker.model;

import java.math.BigDecimal;

public interface IGameStateModel {

    Long getGameId();

    Long getPlayerId();
    
    Iterable<CardRecord> getPlayerCards();

    EGameState getGameState();

    BigDecimal getPlayerBet();

    BigDecimal getWinMultiplier();

    BigDecimal getPlayerWinnings();
}
