package com.korobov.onehandpoker.controller.views;

import java.math.BigDecimal;
import java.util.Objects;

import com.korobov.onehandpoker.model.IGameStateModel;

/**
 * Represents a player's game statistics.
 * Break-even games count as neither wins nor losses.
 *
 * @param playerId      the player ID.
 * @param gameCount     the total number of games.
 * @param winCount      the number of games with a net gain.
 * @param lossCount     the number of games with a net loss.
 * @param totalWinnings the sum of positive net gains.
 * @param totalLosses   the sum of absolute net losses.
 * @param totalProfit   the difference between winnings and losses.
 */
public record PlayerView(
        long playerId,
        int gameCount,
        int winCount,
        int lossCount,
        BigDecimal totalWinnings,
        BigDecimal totalLosses,
        BigDecimal totalProfit) {

    /**
     * Creates a player statistics view.
     *
     * @throws NullPointerException if any financial component is null.
     */
    public PlayerView {

        Objects.requireNonNull(totalWinnings);
        Objects.requireNonNull(totalLosses);
        Objects.requireNonNull(totalProfit);
    }
    
    /**
     * Aggregates a player's games into statistics.
     * Empty input produces zero statistics.
     *
     * @param playerId the player ID.
     * @param games the games already filtered by player ID.
     * @return the player's statistics.
     * @throws NullPointerException if a required value is null.
     */
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