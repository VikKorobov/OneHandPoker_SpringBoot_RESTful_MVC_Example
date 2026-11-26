package com.korobov.onehandpoker.model;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

/**
 * Defines errors related to invalid game model data.
 * 
 * @see IGameStateModel
 * @see EErrorCode
 * @see IError
 */
public enum EModelError implements IError {

    INVALID_PLAYER_ID(EErrorCode.BAD_REQUEST, "The player ID must be greater than zero and not null."),
    INVALID_PLAYER_CARDS(EErrorCode.BAD_REQUEST, "The player must have exactly five distinct, non-null cards."),
    INVALID_GAME_RESULT(EErrorCode.BAD_REQUEST, "The game result must not be null."),
    INVALID_PLAYER_BET(EErrorCode.BAD_REQUEST, "The player bet must be positive and not null."),
    INVALID_WIN_MULTIPLIER(EErrorCode.BAD_REQUEST, "The win multiplier must be non-negative and not null."),
    INVALID_PLAYER_WINNINGS(EErrorCode.BAD_REQUEST, "The player winnings must be non-negative and not null."),
    INCONSISTENT_GAME_RESULT(EErrorCode.BAD_REQUEST, "The game result must correspond to the player cards."),
    INCONSISTENT_PLAYER_WINNINGS(EErrorCode.BAD_REQUEST, "The player winnings must equal the player bet multiplied by the win multiplier."),
    DUPLICATE_PLAYER_CARDS(EErrorCode.BAD_REQUEST, "The player cards must be distinct.");
  
    private final EErrorCode code;
    private final String message;

    EModelError(EErrorCode code, String message) {

        this.code = Objects.requireNonNull(code);
        this.message = Objects.requireNonNull(message);
    }

    @Override
    public EErrorCode getCode() {

        return code;
    }

    @Override
    public String getMessage() {

        return message;
    }
}