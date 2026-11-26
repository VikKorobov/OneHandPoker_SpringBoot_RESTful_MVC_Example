package com.korobov.onehandpoker.utilities;

/**
 * Represents the result of an operation that can succeed or fail.
 * 
 * <p>
 * This class encapsulates a success or failure state and includes the
 * associated
 * data for both scenarios.
 * </p>
 * 
 * @param <SuccessType> the type of data associated with success.
 * @param <FailureType> the type of data associated with failure.
 * 
 * @see ErrorResult
 * 
 * @author Korobov Viktor
 * @version 1.0
 */
public class Result<SuccessType, FailureType> {

    private final boolean success;
    private final SuccessType successData;
    private final FailureType failureData;

    private Result(boolean success, SuccessType successData, FailureType failureData) {

        this.success = success;
        this.successData = successData;
        this.failureData = failureData;
    }

    /**
     * Creates a successful {@code Result} instance with the specified data.
     * 
     * @param <S>  the type of success data.
     * @param <F>  the type of failure data.
     * @param data the success data.
     * @return a successful {@code Result}.
     */
    public static <S, F> Result<S, F> success(S data) {

        return new Result<>(true, data, null);
    }

    /**
     * Creates a failed {@code Result} instance with the specified error data.
     * 
     * @param <S>   the type of success data.
     * @param <F>   the type of failure data.
     * @param error the error data.
     * @return a failed {@code Result}.
     */
    public static <S, F> Result<S, F> failure(F error) {

        return new Result<>(false, null, error);
    }

    /**
     * Creates a failed {@code Result} instance from an {@code ErrorResult}.
     *
     * <p>
     * This method allows failure data to be propagated from an
     * {@code ErrorResult} whose failure type is equal to or a subtype
     * of the resulting failure type.
     * </p>
     *
     * @param <S>         the type of success data.
     * @param <F>         the type of failure data.
     * @param errorResult the failed {@code ErrorResult} containing the error data.
     * @return a failed {@code Result} containing the original error data.
     * @throws IllegalArgumentException if {@code errorResult} represents a success.
     * @throws NullPointerException if {@code errorResult} is {@code null}.
     */
    public static <S, F> Result<S, F> failure(ErrorResult<? extends F> errorResult) {

        if (errorResult.isSuccess()) {

            throw new IllegalArgumentException("The provided ErrorResult represents a success.");
        }

        return Result.failure(errorResult.getFailureData());
    }

    /**
     * Checks if the result represents a success.
     * 
     * @return {@code true} if the result is a success, {@code false} otherwise.
     */
    public boolean isSuccess() {
        
        return success;
    }

    /**
     * Checks if the result represents a failure.
     * 
     * @return {@code true} if the result is a failure, {@code false} otherwise.
     */
    public boolean isFailure() {

        return !success;
    }

    /**
     * Retrieves the success data, if any.
     */
    public SuccessType getSuccessData() {

        return successData;
    }

    /**
     * Retrieves the failure data, if any.
     */
    public FailureType getFailureData() {

        return failureData;
    }
}
