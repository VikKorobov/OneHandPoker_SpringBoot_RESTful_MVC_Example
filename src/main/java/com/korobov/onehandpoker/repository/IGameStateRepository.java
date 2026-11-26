package com.korobov.onehandpoker.repository;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

/**
 * Defines the application-level contract for persisting and
 * retrieving completed game state models.
 *
 * <p>
 * This interface abstracts the underlying persistence mechanism
 * and allows application components to access persistent game
 * data without depending on concrete model implementations
 * or persistence frameworks.
 * </p>
 *
 * <p>
 * Expected persistence and retrieval failures are represented
 * using the application's result and error contracts.
 * </p>
 */
public interface IGameStateRepository {

    /**
     * Persists a completed game.
     *
     * @param model the game model to persist.
     * @return the persisted game model with its assigned ID or an error.
     */
    Result<IGameStateModel, IError> save(IGameStateModel model);

    /**
     * Retrieves a game by its ID.
     *
     * @param id the game ID.
     * @return the game model or an error if retrieval fails or no game exists.
     */
    Result<IGameStateModel, IError> findById(Long id);

    /**
     * Retrieves all persisted games.
     *
     * @return the game models, an empty collection or an error.
     */
    Result<Iterable<IGameStateModel>, IError> findAll();
    
    /**
     * Retrieves games filtered by player ID.
     *
     * @param playerId the player ID.
     * @return the game models, an empty collection or an error.
     */
    Result<Iterable<IGameStateModel>, IError> findAllByPlayerId(Long playerId);
}