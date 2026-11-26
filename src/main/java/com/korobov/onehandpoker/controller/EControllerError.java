package com.korobov.onehandpoker.controller;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

/**
 * Defines errors related to request handling and response generation.
 * 
 * @see IGameController
 * @see EErrorCode
 * @see IError
 */
public enum EControllerError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EControllerError(EErrorCode code, String message) {

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
