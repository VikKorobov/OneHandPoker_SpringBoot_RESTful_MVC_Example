package com.korobov.onehandpoker.handler;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

/**
 * Defines the contract for coordinating the application operations
 * of One-Hand Poker.
 *
 * <p>
 * Implementations coordinate the game engine, repository and
 * external services to execute application operations.
 * </p>
 *
 * <p>
 * The handler is responsible for controlling application workflows
 * and propagating errors originating from the involved components
 * without exposing implementation-specific details to the controller.
 * </p>
 */
public interface IGameHandler {

    /**
     * Verifies the player, simulates a game and persists the result.
     *
     * @param playerId the positive player ID.
     * @param playerBet the positive amount wagered.
     * @return the persisted game model returned by the repository or an error.
     */
    Result<IGameStateModel, IError> play(Long playerId, BigDecimal playerBet);

    /**
     * Retrieves a persisted game by its ID.
     *
     * @param id the game ID.
     * @return the game model or an error.
     */
    Result<IGameStateModel, IError> getGame(Long id);

    /**
     * Retrieves all persisted games.
     *
     * @return the game models, an empty collection or an error.
     */
    Result<Iterable<IGameStateModel>, IError> getGames();

    /**
     * Retrieves all persisted games of a player.
     *
     * @param id the player ID.
     * @return the game models, an empty collection or an error.
     */
    Result<Iterable<IGameStateModel>, IError> getPlayerGames(Long id);
}
