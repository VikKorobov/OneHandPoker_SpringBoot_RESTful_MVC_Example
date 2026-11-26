package com.korobov.onehandpoker.utilities;

/**
 * Defines a common contract for representing application errors.
 *
 * <p>
 * This interface allows errors from different application components
 * to be handled uniformly by providing a standardized error code
 * and a descriptive error message.
 * </p>
 *
 * @author Korobov Viktor
 * @version 1.0
 */
public interface IError {

    /**
     * Retrieves the error code associated with this error.
     *
     * @return the corresponding error code.
     */
    EErrorCode getCode();

    /**
     * Retrieves the descriptive message associated with this error.
     *
     * @return the corresponding error message.
     */
    String getMessage();
}