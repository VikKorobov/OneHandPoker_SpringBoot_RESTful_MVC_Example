package com.korobov.onehandpoker.service;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

/**
 * Defines errors related to external service communication.
 * 
 * @see IUserService
 * @see EErrorCode
 * @see IError
 */
public enum EServiceError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EServiceError(EErrorCode code, String message) {

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
