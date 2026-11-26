package com.korobov.onehandpoker.repository;

/**
 * Defines the intended Spring Data JPA repository contract
 * for the concrete game state entity.
 *
 * <p>
 * This interface represents the framework-specific persistence
 * mechanism used by the game state repository implementation.
 * </p>
 *
 * <p>
 * Application components should access persistent game data
 * through {@link IGameStateRepository} rather than depending
 * directly on this interface.
 * </p>
 *
 * @see IGameStateRepository
 */
public interface IGameStateJPARepository {
    
    //TODO: extend with JPA repository when concrete model implementation is created
}
