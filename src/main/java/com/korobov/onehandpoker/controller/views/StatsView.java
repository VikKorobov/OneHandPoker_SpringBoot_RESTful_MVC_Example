package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.korobov.onehandpoker.model.IGameStateModel;

/**
 * Represents global game statistics from the players' perspective.
 * Break-even games count as neither wins nor losses.
 *
 * @param gameCount the total number of games.
 * @param playerCount the number of distinct players.
 * @param winCount the number of games with a net gain.
 * @param lossCount the number of games with a net loss.
 * @param totalWinnings the sum of positive net gains.
 * @param totalLosses the sum of absolute net losses.
 * @param totalProfit the difference between winnings and losses.
 */
public record StatsView(
        int gameCount,
        int playerCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses,
        BigDecimal totalProfit) {

    /**
     * Creates a global statistics view.
     *
     * @throws NullPointerException if any financial component is null.
     */
    public StatsView {

        Objects.requireNonNull(totalWinnings);
        Objects.requireNonNull(totalLosses);
        Objects.requireNonNull(totalProfit);
    }
    
    /**
     * Aggregates games into global statistics.
     * Empty input produces zero statistics.
     *
     * @param games the games to aggregate.
     * @return the global statistics.
     * @throws NullPointerException if a required value is null.
     */
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