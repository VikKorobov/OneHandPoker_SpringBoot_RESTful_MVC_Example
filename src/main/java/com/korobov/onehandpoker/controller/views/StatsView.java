package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;

public record StatsView(
        int gameCount,
        int playerCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses, BigDecimal totalProfit) {

}
