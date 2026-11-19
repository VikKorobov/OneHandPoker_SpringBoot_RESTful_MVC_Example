package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;

public record PlayerView(
        long playerId,
        int gameCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses,
        BigDecimal totalProfit) {

}
