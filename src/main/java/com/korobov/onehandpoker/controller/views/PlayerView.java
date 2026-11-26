package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

public record PlayerView(
        long playerId,
        int gameCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses,
        BigDecimal totalProfit
) {

    public PlayerView {

        Objects.requireNonNull(totalWinnings);
        Objects.requireNonNull(totalLosses);
        Objects.requireNonNull(totalProfit);
    }
}