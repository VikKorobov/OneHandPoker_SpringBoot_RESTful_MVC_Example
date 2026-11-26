package com.korobov.onehandpoker.model;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;

/**
 * Defines the contract for representing the state of a completed
 * One-Hand Poker game.
 *
 * <p>
 * A game state model contains the player identifier, the player's
 * bet, the dealt cards, the evaluated game result and the
 * corresponding payout information.
 * </p>
 *
 * <p>
 * A valid game state contains a positive player identifier,
 * a positive bet, exactly five distinct cards, a valid game result,
 * a non-negative payout multiplier and a non-negative payout.
 * </p>
 *
 * <p>
 * A newly constructed game state model does not have an assigned
 * game identifier until it is persisted. The public contract provides
 * read-only access to the completed game data.
 * </p>
 */
public interface IGameStateModel {


    /**
     * @return the game ID or null if the game has not been persisted.
     */
    Long getGameId();

    /**
     * @return the positive player ID.
     */
    Long getPlayerId();

    /**
     * @return the five distinct, non-null cards dealt to the player.
     */
    Iterable<CardRecord> getPlayerCards();

    /**
     * @return the evaluated hand.
     */
    EGameResult getGameResult();

    /**
     * @return the positive amount wagered.
     */
    BigDecimal getPlayerBet();

    /**
     * @return the non-negative payout multiplier.
     */
    BigDecimal getWinMultiplier();
    
    /**
     * @return the non-negative gross payout, including any returned stake.
     */
    BigDecimal getPlayerWinnings();
}
