package com.korobov.onehandpoker.model;

import com.korobov.onehandpoker.utilities.EErrorCode;
import com.korobov.onehandpoker.utilities.IError;

public enum EModelError implements IError {

    ;
    
    private final EErrorCode code;
    private final String message;

    EModelError(EErrorCode code, String message) {

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