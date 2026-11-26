package com.korobov.onehandpoker.factory;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

public enum EFactoryError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EFactoryError(EErrorCode code, String message) {

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