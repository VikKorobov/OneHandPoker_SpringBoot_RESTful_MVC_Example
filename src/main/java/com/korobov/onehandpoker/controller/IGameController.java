package com.korobov.onehandpoker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import com.korobov.onehandpoker.controller.requests.PlayRequest;

/**
 * Defines the REST API contract for the One-Hand Poker application.
 *
 * <p>
 * This interface exposes endpoints for playing games, retrieving game
 * information, retrieving statistical information and accessing
 * information about the game rules and probabilities.
 * </p>
 *
 * <p>
 * Implementations are responsible for handling incoming requests,
 * delegating application operations and converting their results
 * into appropriate HTTP responses.
 * </p>
 */
@RequestMapping("casino/onehandpoker/api/")
public interface IGameController {

    /**
     * Plays a new game.
     *
     * @param request the player ID and bet.
     * @return the completed game or an error response.
     */
    @PostMapping("play")
    ResponseEntity<?> play(@Valid @RequestBody PlayRequest request);

    /**
     * Retrieves a game by its ID.
     *
     * @param id the game ID.
     * @return the game or an error response.
     */
    @GetMapping("game/{id}")
    ResponseEntity<?> getGame(@Positive @PathVariable Long id);

    /**
     * Retrieves all games.
     *
     * @return the games or an error response.
     */
    @GetMapping("games")
    ResponseEntity<?> getGames();

    /**
     * Retrieves all games of a player.
     *
     * @param id the player ID.
     * @return the player's games or an error response.
     */
    @GetMapping("games/player/{id}")
    ResponseEntity<?> getPlayerGames(@Positive @PathVariable Long id);

    /**
     * Retrieves global game statistics.
     *
     * @return the statistics or an error response.
     */
    @GetMapping("stats")
    ResponseEntity<?> getStats();

    /**
     * Retrieves a player's game statistics.
     *
     * @param id the player ID.
     * @return the player's statistics or an error response.
     */
    @GetMapping("stats/player/{id}")
    ResponseEntity<?> getPlayerStats(@Positive @PathVariable Long id);

    //NOTE: The following two endpoints will serve static markdown files that are stored in the resources folder.

    /**
     * Retrieves the game rules.
     *
     * @return the rules in Markdown format or an error response.
     */
    @GetMapping(value = "info/rules", produces = "text/markdown")
    ResponseEntity<String> getRules();

    /**
     * Retrieves the game probabilities and gambling risks.
     *
     * @return the information in Markdown format or an error response.
     */
    @GetMapping(value = "info/chances", produces = "text/markdown")
    ResponseEntity<String> getChances();
}
