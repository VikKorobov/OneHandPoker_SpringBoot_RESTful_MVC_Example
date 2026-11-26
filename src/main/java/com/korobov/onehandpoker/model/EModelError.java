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

    ;
    
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