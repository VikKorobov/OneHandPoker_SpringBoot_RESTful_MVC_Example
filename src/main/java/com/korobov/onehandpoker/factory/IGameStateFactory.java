package com.korobov.onehandpoker.factory;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

/**
 * Defines the contract for constructing completed game state models.
 *
 * <p>
 * Implementations are responsible for constructing valid game state
 * models from the results of a completed game simulation.
 * </p>
 *
 * <p>
 * The factory does not execute game mechanics, assign persistent
 * game identifiers or perform persistence operations.
 * </p>
 */
public interface IGameStateFactory {
    
    /**
     * Creates a completed game model without an assigned game ID.
     *
     * @param playerId the positive player ID.
     * @param playerBet the positive amount wagered.
     * @param playerCards the five distinct cards.
     * @param gameState the evaluated hand.
     * @param winMultiplier the non-negative payout multiplier.
     * @param playerWinnings the non-negative gross payout.
     * @return the constructed game model or an error.
     */
    Result<IGameStateModel, IError> create(
            Long playerId,
            BigDecimal playerBet,
            Iterable<CardRecord> playerCards,
            EGameResult gameState,
            BigDecimal winMultiplier,
            BigDecimal playerWinnings
    );
}
