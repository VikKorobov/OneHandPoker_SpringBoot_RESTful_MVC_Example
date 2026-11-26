package com.korobov.onehandpoker.utilities;

import java.util.Objects;

/**
 * Represents the result of an operation that can succeed or fail
 * without producing success data.
 *
 * <p>
 * A successful result contains no data, whereas a failed result
 * contains non-null failure data.
 * </p>
 *
 * @param <FailureType> the type of data associated with failure.
 *
 * @see Result
 *
 * @author Korobov Viktor
 * @version 1.0
 */
public class ErrorResult<FailureType> {

    private final boolean success;
    private final FailureType failureData;

    private ErrorResult(boolean success, FailureType failureData) {

        this.success = success;
        this.failureData = failureData;
    }

    /**
     * Creates a successful {@code ErrorResult} instance without associated data.
     *
     * @param <F> the type of failure data.
     * @return a successful {@code ErrorResult}.
     */
    public static <F> ErrorResult<F> success() {

        return new ErrorResult<>(true, null);
    }

    /**
     * Creates a failed {@code ErrorResult} instance with the specified failure data.
     *
     * @param <F> the type of failure data.
     * @param error the failure data.
     * @return a failed {@code ErrorResult} containing the specified failure data.
     * @throws NullPointerException if {@code error} is {@code null}.
     */
    public static <F> ErrorResult<F> failure(F error) {

        return new ErrorResult<>(false, Objects.requireNonNull(error));
    }

    /**
     * Checks whether the result represents a success.
     *
     * @return {@code true} if the result represents a success, {@code false} otherwise.
     */
    public boolean isSuccess() {

        return success;
    }

    /**
     * Checks whether the result represents a failure.
     *
     * @return {@code true} if the result represents a failure, {@code false} otherwise.
     */
    public boolean isFailure() {

        return !success;
    }

    /**
     * Retrieves the failure data associated with the result.
     *
     * @return the failure data if the result represents a failure, {@code null} otherwise.
     */
    public FailureType getFailureData() {

        return failureData;
    }
}