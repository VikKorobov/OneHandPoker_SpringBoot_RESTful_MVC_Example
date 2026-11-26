package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;

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

    public static PlayerView of(long playerId, Iterable<IGameStateModel> games) {

        Objects.requireNonNull(games);

        int gameCount = 0;
        int winCount = 0;
        int lossCount = 0;

        BigDecimal totalWinnings = BigDecimal.ZERO;
        BigDecimal totalLosses = BigDecimal.ZERO;

        for (IGameStateModel game : games) {

                gameCount++;

                BigDecimal netGain = game.getPlayerWinnings().subtract(game.getPlayerBet());

                if (netGain.signum() > 0) {

                        winCount++;
                        totalWinnings = totalWinnings.add(netGain);

                } 
                else if (netGain.signum() < 0) {

                        lossCount++;
                        totalLosses = totalLosses.add(netGain.abs());
                }
        }

        return new PlayerView(
                playerId,
                gameCount,
                winCount,
                lossCount,
                totalWinnings,
                totalLosses,
                totalWinnings.subtract(totalLosses)
        );
}
}