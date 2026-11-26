package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;

/**
 * Represents a detailed view of a persisted game.
 *
 * @param gameId the game ID.
 * @param playerCards the dealt cards.
 * @param gameResult the evaluated hand.
 * @param playerBet the amount wagered.
 * @param winMultiplier the payout multiplier.
 * @param playerWinnings the gross payout.
 */
public record FullGameView(
        Long gameId,
        Iterable<CardRecord> playerCards,
        EGameResult gameResult,
        BigDecimal playerBet,
        BigDecimal winMultiplier,
        BigDecimal playerWinnings
) {

    /**
     * Creates a game view.
     *
     * @throws NullPointerException if any component is null.
     */
    public FullGameView {

        Objects.requireNonNull(gameId);
        Objects.requireNonNull(playerCards);
        Objects.requireNonNull(gameResult);
        Objects.requireNonNull(playerBet);
        Objects.requireNonNull(winMultiplier);
        Objects.requireNonNull(playerWinnings);
    }

    /**
     * Creates a detailed view of a persisted game.
     *
     * @param model the persisted game model.
     * @return the game view.
     * @throws NullPointerException if the model or a required property is null.
     */
    public static FullGameView of(IGameStateModel model) {

        Objects.requireNonNull(model);

        return new FullGameView(
                model.getGameId(),
                model.getPlayerCards(),
                model.getGameResult(),
                model.getPlayerBet(),
                model.getWinMultiplier(),
                model.getPlayerWinnings()
        );
    }
}
