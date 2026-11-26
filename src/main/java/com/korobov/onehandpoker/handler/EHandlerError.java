package com.korobov.onehandpoker.handler;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

public enum EHandlerError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EHandlerError(EErrorCode code, String message) {

        this.code = code;
        this.message = message;
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