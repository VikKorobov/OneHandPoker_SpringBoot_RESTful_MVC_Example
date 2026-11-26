package com.korobov.onehandpoker.engine;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

/**
 * Defines the contract for executing the game mechanics of One-Hand Poker.
 *
 * <p>
 * Implementations are responsible for generating the player's hand,
 * evaluating the game result and determining the corresponding
 * payout according to the game rules.
 * </p>
 *
 * <p>
 * The engine delegates the construction of the completed game state
 * model to the game state factory and does not perform persistence
 * or communication with external services.
 * </p>
 */
public interface IGameEngine {
    
    /**
     * Simulates a complete game without persisting it.
     *
     * @param playerId the positive player ID.
     * @param playerBet the positive amount wagered.
     * @return the completed game model or an error.
     */
    Result<IGameStateModel, IError> play(Long playerId, BigDecimal playerBet);
}
