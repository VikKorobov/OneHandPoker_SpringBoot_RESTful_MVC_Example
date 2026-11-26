package com.korobov.onehandpoker.handler;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

/**
 * Defines errors related to application workflows.
 * 
 * @see IGameHandler
 * @see EErrorCode
 * @see IError
 */
public enum EHandlerError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EHandlerError(EErrorCode code, String message) {

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