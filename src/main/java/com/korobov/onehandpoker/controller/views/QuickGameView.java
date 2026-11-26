package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;

/**
 * Represents a simplified view of a persisted game.
 *
 * @param gameId the game ID.
 * @param playerCards the dealt cards.
 * @param playerBet the amount wagered.
 * @param playerWinnings the gross payout.
 */
public record QuickGameView(
        Long gameId,
        Iterable<CardRecord> playerCards,
        BigDecimal playerBet,
        BigDecimal playerWinnings
) {

    /**
     * Creates a game view.
     *
     * @throws NullPointerException if any component is null.
     */
    public QuickGameView {

        Objects.requireNonNull(gameId);
        Objects.requireNonNull(playerCards);
        Objects.requireNonNull(playerBet);
        Objects.requireNonNull(playerWinnings);
    }

    /**
     * Creates a simplified view of a persisted game.
     *
     * @param model the persisted game model.
     * @return the game view.
     * @throws NullPointerException if the model or a required property is null.
     */
    public static QuickGameView of(IGameStateModel model) {

        Objects.requireNonNull(model);

        return new QuickGameView(
                model.getGameId(),
                model.getPlayerCards(),
                model.getPlayerBet(),
                model.getPlayerWinnings()
        );
    }
}