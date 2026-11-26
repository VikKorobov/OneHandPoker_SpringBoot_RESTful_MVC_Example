package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.korobov.onehandpoker.model.IGameStateModel;

public record StatsView(
                int gameCount,
                int playerCount,
                int winCount,
                int lossCount,
                BigDecimal totalWinnings,
                BigDecimal totalLosses,
                BigDecimal totalProfit) {

        public StatsView {

                Objects.requireNonNull(totalWinnings);
                Objects.requireNonNull(totalLosses);
                Objects.requireNonNull(totalProfit);
        }

        public static StatsView of(Iterable<IGameStateModel> games) {

                Objects.requireNonNull(games);

                int gameCount = 0;
                int winCount = 0;
                int lossCount = 0;

                Set<Long> playerIds = new HashSet<>();

                BigDecimal totalWinnings = BigDecimal.ZERO;
                BigDecimal totalLosses = BigDecimal.ZERO;

                for (IGameStateModel game : games) {

                        gameCount++;
                        playerIds.add(game.getPlayerId());

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

                return new StatsView(
                                gameCount,
                                playerIds.size(),
                                winCount,
                                lossCount,
                                totalWinnings,
                                totalLosses,
                                totalWinnings.subtract(totalLosses)
                );
        }
}