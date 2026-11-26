package com.korobov.onehandpoker.model.components;

import com.korobov.onehandpoker.model.IGameStateModel;
import java.util.Objects;

/**
 * Represents a playing card.
 *
 * @param suit the card suit.
 * @param rank the card rank.
 * 
 * @see IGameStateModel
 */
public record CardRecord(ECardSuit suit, ECardRank rank) {

    /**
     * Creates a playing card.
     *
     * @throws NullPointerException if either component is null.
     */
    public CardRecord {

        Objects.requireNonNull(suit);
        Objects.requireNonNull(rank);
    }
}