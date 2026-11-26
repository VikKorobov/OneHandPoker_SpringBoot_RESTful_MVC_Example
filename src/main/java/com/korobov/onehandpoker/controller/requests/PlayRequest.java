package com.korobov.onehandpoker.controller.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Represents a request to play a game.
 *
 * @param playerId the positive player ID.
 * @param playerBet the positive amount wagered.
 */
public record PlayRequest(
        @NotNull @Positive Long playerId,
        @NotNull @Positive BigDecimal playerBet
) {

}