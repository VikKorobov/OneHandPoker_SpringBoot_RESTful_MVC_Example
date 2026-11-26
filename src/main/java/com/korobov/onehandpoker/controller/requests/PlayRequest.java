package com.korobov.onehandpoker.controller.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PlayRequest(
        @NotNull @Positive Long playerId,
        @NotNull @Positive BigDecimal playerBet
) {

}