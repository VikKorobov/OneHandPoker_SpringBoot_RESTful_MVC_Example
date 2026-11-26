package com.korobov.onehandpoker.model.components;

import java.util.Objects;

public record CardRecord(ECardSuit suit, ECardRank rank) {

    public CardRecord {

        Objects.requireNonNull(suit);
        Objects.requireNonNull(rank);
    }
}