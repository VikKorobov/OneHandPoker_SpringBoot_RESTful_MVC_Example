package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;

public record FullGameView(
        Long gameId,
        Iterable<CardRecord> playerCards,
        EGameResult gameState,
        BigDecimal playerBet,
        BigDecimal winMultiplier,
        BigDecimal playerWinnings
) {

    public FullGameView {

        Objects.requireNonNull(gameId);
        Objects.requireNonNull(playerCards);
        Objects.requireNonNull(gameState);
        Objects.requireNonNull(playerBet);
        Objects.requireNonNull(winMultiplier);
        Objects.requireNonNull(playerWinnings);
    }

    public static FullGameView of(IGameStateModel model) {

        Objects.requireNonNull(model);

        return new FullGameView(
                model.getGameId(),
                model.getPlayerCards(),
                model.getGameState(),
                model.getPlayerBet(),
                model.getWinMultiplier(),
                model.getPlayerWinnings()
        );
    }
}
