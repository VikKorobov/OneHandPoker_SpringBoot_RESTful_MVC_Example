package com.korobov.onehandpoker.utilities;

import java.util.Objects;

/**
 * Represents the result of an operation that can succeed or fail.
 *
 * <p>
 * A successful result contains non-null success data, whereas a failed
 * result contains non-null failure data.
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
     * Creates a successful {@code Result} instance with the specified success data.
     *
     * @param <S> the type of success data.
     * @param <F> the type of failure data.
     * @param data the success data.
     * @return a successful {@code Result} containing the specified success data.
     * @throws NullPointerException if {@code data} is {@code null}.
     */
    public static <S, F> Result<S, F> success(S data) {

        return new Result<>(true, Objects.requireNonNull(data), null);
    }

    /**
     * Creates a failed {@code Result} instance with the specified failure data.
     *
     * @param <S> the type of success data.
     * @param <F> the type of failure data.
     * @param error the failure data.
     * @return a failed {@code Result} containing the specified failure data.
     * @throws NullPointerException if {@code error} is {@code null}.
     */
    public static <S, F> Result<S, F> failure(F error) {

        return new Result<>(false, null, Objects.requireNonNull(error));
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
     * @param <S> the type of success data.
     * @param <F> the type of failure data.
     * @param errorResult the failed {@code ErrorResult} containing the failure data.
     * @return a failed {@code Result} containing the original failure data.
     * @throws NullPointerException if {@code errorResult} is {@code null}.
     * @throws IllegalArgumentException if {@code errorResult} represents a success.
     */
    public static <S, F> Result<S, F> failure(ErrorResult<? extends F> errorResult) {

        Objects.requireNonNull(errorResult);

        if (errorResult.isSuccess()) {

            throw new IllegalArgumentException("The provided ErrorResult represents a success.");
        }

        return Result.failure(errorResult.getFailureData());
    }

    /**
     * Creates a failed {@code Result} instance from another {@code Result}.
     *
     * <p>
     * This method allows failure data to be propagated independently
     * of the original success type, provided that the original failure
     * type is equal to or a subtype of the resulting failure type.
     * </p>
     *
     * @param <S> the type of success data.
     * @param <F> the type of failure data.
     * @param result the failed {@code Result} containing the failure data.
     * @return a failed {@code Result} containing the original failure data.
     * @throws NullPointerException if {@code result} is {@code null}.
     * @throws IllegalArgumentException if {@code result} represents a success.
     */
    public static <S, F> Result<S, F> failure(Result<?, ? extends F> result) {

        Objects.requireNonNull(result);

        if (result.isSuccess()) {

            throw new IllegalArgumentException("The provided Result represents a success.");
        }

        return Result.failure(result.getFailureData());
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
     * Retrieves the success data associated with the result.
     *
     * @return the success data if the result represents a success, {@code null} otherwise.
     */
    public SuccessType getSuccessData() {

        return successData;
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