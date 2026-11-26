package com.korobov.onehandpoker.utilities;

/**
 * Represents a standardized error code associated with a failed operation.
 *
 * <p>
 * This enum defines common error categories and their corresponding
 * numeric codes, allowing errors from different application components
 * to be mapped consistently to HTTP responses without introducing
 * framework-specific dependencies.
 * </p>
 *
 * @author Korobov Viktor
 * @version 1.0
 */
public enum EErrorCode {

    /** Indicates that the provided request or input is invalid. */
    BAD_REQUEST(400),

    /** Indicates that the requested resource could not be found. */
    NOT_FOUND(404),

    /** Indicates that an unexpected internal error has occurred. */
    INTERNAL_ERROR(500);

    private final int code;

    EErrorCode(int code) {

        this.code = code;
    }

    /**
     * Retrieves the numeric code associated with this error category.
     *
     * @return the corresponding numeric error code.
     */
    public int getCode() {

        return code;
    }
}
