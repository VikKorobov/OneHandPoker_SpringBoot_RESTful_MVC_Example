package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

public record StatsView(
        int gameCount,
        int playerCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses,
        BigDecimal totalProfit
) {

    public StatsView {

        Objects.requireNonNull(totalWinnings);
        Objects.requireNonNull(totalLosses);
        Objects.requireNonNull(totalProfit);
    }
}