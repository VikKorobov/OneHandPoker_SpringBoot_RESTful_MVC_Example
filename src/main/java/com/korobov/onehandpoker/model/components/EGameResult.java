package com.korobov.onehandpoker.model.components;

import com.korobov.onehandpoker.model.IGameStateModel;

/**
 * Defines the possible poker hand evaluation results.
 * 
 * @see IGameStateModel
 */
public enum EGameResult {
    ROYAL_FLUSH,
    STRAIGHT_FLUSH,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    FLUSH,
    STRAIGHT,
    THREE_OF_A_KIND,
    TWO_PAIR,
    JACKS_OR_BETTER,
    LOW_PAIR,
    HIGH_CARD
}
