package com.korobov.onehandpoker.engine;

import java.util.Objects;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

public enum EEngineError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EEngineError(EErrorCode code, String message) {

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