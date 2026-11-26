package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;

public record QuickGameView(
        Long gameId,
        Iterable<CardRecord> playerCards,
        BigDecimal playerBet,
        BigDecimal playerWinnings
) {

    public QuickGameView {

        Objects.requireNonNull(gameId);
        Objects.requireNonNull(playerCards);
        Objects.requireNonNull(playerBet);
        Objects.requireNonNull(playerWinnings);
    }

    public static QuickGameView of(IGameStateModel model) {

        return new QuickGameView(
                model.getGameId(),
                model.getPlayerCards(),
                model.getPlayerBet(),
                model.getPlayerWinnings()
        );
    }
}